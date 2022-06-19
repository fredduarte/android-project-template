package com.template.project.android.common.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView

class BindingNestedMultiViewHolder<T : BindingNestedUiModel>(
    private val binding: ViewDataBinding,
    private val lifecycleOwner: LifecycleOwner? = null
): RecyclerView.ViewHolder(binding.root), LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)

    fun bind(
        item: T,
        viewPool: RecyclerView.RecycledViewPool?,
        viewPoolVariableId: Int?
    ) {
        binding.apply {
            viewPool?.let { pool ->
                viewPoolVariableId?.let { poolVariableId ->
                    this.setVariable(poolVariableId, pool)
                }
            }
            lifecycleOwner?.let {
                this.lifecycleOwner = this@BindingNestedMultiViewHolder
            }
            this.setVariable(item.variableId, item)
            this.executePendingBindings()
        }
    }

    init {
        // viewholder's lifecycle should follow parent lifecycle
        lifecycleOwner?.let {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
            // keep track of parent lifecycle and handle events accordingly
            lifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                fun onResume(owner: LifecycleOwner) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }

                fun onPause(owner: LifecycleOwner) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                }

                fun onDestroy(owner: LifecycleOwner) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                }
            })
        }
    }

    fun onAttached() {
        if (lifecycleOwner != null) {
            if (lifecycleRegistry.currentState != Lifecycle.State.DESTROYED) {
                lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
            }
        }
    }

    fun onDetached() {
        if (lifecycleOwner != null) {
            if (lifecycleRegistry.currentState != Lifecycle.State.DESTROYED) {
                lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            }
        }
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}

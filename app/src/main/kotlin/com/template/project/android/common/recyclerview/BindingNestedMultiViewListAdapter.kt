package com.template.project.android.common.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingNestedMultiViewListAdapter<T : BindingNestedUiModel>(
    diffUtilCallback: DiffUtil.ItemCallback<T> = DiffUtilCallback(),
    private val lifecycleOwner: LifecycleOwner? = null
) : ListAdapter<T, BindingNestedMultiViewHolder<T>>(diffUtilCallback),
    LifecycleOwner {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingNestedMultiViewHolder<T> {
        val binding: ViewDataBinding = DataBindingUtil.inflate<ViewDataBinding?>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        ).apply {
            lifecycleOwner?.let { owner ->
                lifecycleOwner = owner
            }
        }

        return BindingNestedMultiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingNestedMultiViewHolder<T>, position: Int) {
        getItem(position).let { item ->
            item.recyclerParameters?.let { recyclerParams ->
                recyclerParams.layoutParameters?.let { layoutParams ->
                    holder.itemView.layoutParams =
                        ViewGroup.LayoutParams(layoutParams.width, layoutParams.height)
                }

                return holder.bind(
                    item = item,
                    viewPool = viewPool,
                    viewPoolVariableId = item.recyclerParameters?.viewPoolVariableId
                )
            }
        }

        return holder.bind(
            item = getItem(position),
            viewPool = null,
            viewPoolVariableId = null
        )
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }

    override fun onViewAttachedToWindow(holder: BindingNestedMultiViewHolder<T>) {
        super.onViewAttachedToWindow(holder)
        holder.onAttached()
    }

    override fun onViewDetachedFromWindow(holder: BindingNestedMultiViewHolder<T>) {
        super.onViewDetachedFromWindow(holder)
        holder.onDetached()
    }

    private val lifecycleRegistry = LifecycleRegistry(this)
    private var wasPaused: Boolean = false
    init {
        lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
    }
    fun markCreated() {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }
    fun markAttach() {
        if (wasPaused) {
            lifecycleRegistry.currentState = Lifecycle.State.RESUMED
            wasPaused = false
        } else {
            lifecycleRegistry.currentState = Lifecycle.State.STARTED
        }
    }
    fun markDetach() {
        wasPaused = true
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }
    fun markDestroyed() {
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}

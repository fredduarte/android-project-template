package com.template.project.android.common.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingNestedMultiViewHolder<T : BindingNestedUiModel>(
    private val binding: ViewDataBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: T,
        viewPool: RecyclerView.RecycledViewPool?,
        viewPoolVariableId: Int?
    ) {
        viewPool?.let { pool ->
            viewPoolVariableId?.let { poolVariableId ->
                binding.setVariable(poolVariableId, pool)
            }
        }
        binding.setVariable(item.variableId, item)
        binding.executePendingBindings()
    }
}

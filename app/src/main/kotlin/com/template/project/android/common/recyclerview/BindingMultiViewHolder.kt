package com.template.project.android.common.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingMultiViewHolder<T : BindingUiModel>(
    private val binding: ViewDataBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(item.variableId, item)
        binding.executePendingBindings()
    }
}

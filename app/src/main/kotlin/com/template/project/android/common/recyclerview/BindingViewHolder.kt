package com.template.project.android.common.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingViewHolder<T>(
    private val binding: ViewDataBinding,
    private val bindingVariableId: Int
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(bindingVariableId, item)
        binding.executePendingBindings()
    }
}

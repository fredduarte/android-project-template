package com.template.project.android.common.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class BindingListAdapter<T>(
    private val bindingVariableId: Int,
    private val itemsLayoutId: Int,
    diffUtilCallback: DiffUtil.ItemCallback<T> = DiffUtilCallback()
) : ListAdapter<T, BindingViewHolder<T>>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<T> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

        return BindingViewHolder(binding, bindingVariableId)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<T>, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return itemsLayoutId
    }
}

package com.template.project.android.common.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class BindingMultiViewListAdapter<T : BindingUiModel>(
    diffUtilCallback: DiffUtil.ItemCallback<T> = DiffUtilCallback()
) : ListAdapter<T, BindingMultiViewHolder<T>>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingMultiViewHolder<T> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

        return BindingMultiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingMultiViewHolder<T>, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).layoutId
    }
}

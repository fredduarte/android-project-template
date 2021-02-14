package com.template.project.android.common.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingNestedMultiViewListAdapter<T : BindingNestedUiModel>(
    diffUtilCallback: DiffUtil.ItemCallback<T> = DiffUtilCallback()
) : ListAdapter<T, BindingNestedMultiViewHolder<T>>(diffUtilCallback) {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingNestedMultiViewHolder<T> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

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
}

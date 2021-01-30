package com.template.project.android.common.recyclerview

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<T>(
    private val areItemsTheSame: (T, T) -> Boolean = ::itemsAreTheSame,
    private val areContentsTheSame: (T, T) -> Boolean = ::itemsAreTheSame
) : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return areItemsTheSame.invoke(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areContentsTheSame.invoke(oldItem, newItem)
    }
}

private fun <T>itemsAreTheSame(item1: T, item2: T): Boolean {
    return item1 == item2
}

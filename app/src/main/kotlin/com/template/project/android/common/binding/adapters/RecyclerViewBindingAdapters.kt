package com.template.project.android.common.binding.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.project.android.common.recyclerview.BindingMultiViewListAdapter
import com.template.project.android.common.recyclerview.BindingUiModel
import com.template.project.android.common.recyclerview.LayoutManagerType

@BindingAdapter("multiViewItems")
fun <T : BindingUiModel> setMultiViewItems(
    recyclerView: RecyclerView,
    items: List<T>,
) {
    recyclerView.apply {
        if (this.adapter == null) {
            this.adapter = BindingMultiViewListAdapter<T>().apply {
                submitList(items)
            }
        } else {
            (this.adapter as BindingMultiViewListAdapter<T>).submitList(items)
        }
    }
}

@BindingAdapter("layoutManagerType")
fun setLayoutManagerType(
    recyclerView: RecyclerView,
    layoutManagerType: LayoutManagerType = LayoutManagerType.Vertical
) {
    recyclerView.apply {
        when (layoutManagerType) {
            is LayoutManagerType.Vertical -> {
                this.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            }
            is LayoutManagerType.Horizontal -> {
                this.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            }
            is LayoutManagerType.Grid -> {
                this.layoutManager = GridLayoutManager(this.context, layoutManagerType.spanCount)
            }
        }
    }
}

@BindingAdapter("itemDecoration")
fun setItemDecoration(
    recyclerView: RecyclerView,
    itemDecoration: RecyclerView.ItemDecoration? = null
) {
    recyclerView.apply {
        itemDecoration?.let { decoration ->
            if (this.itemDecorationCount == 0) {
                this.addItemDecoration(decoration)
            }
        }
    }
}

@BindingAdapter("hasFixedSize")
fun setHasFixedSize(
    recyclerView: RecyclerView,
    hasFixedSize: Boolean = false
) {
    recyclerView.setHasFixedSize(hasFixedSize)
}

@BindingAdapter("viewPool")
fun setViewPool(
    recyclerView: RecyclerView,
    viewPool: RecyclerView.RecycledViewPool? = null
) {
    recyclerView.setRecycledViewPool(viewPool)
}

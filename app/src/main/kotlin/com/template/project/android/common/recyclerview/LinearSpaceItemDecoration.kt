package com.template.project.android.common.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LinearSpaceItemDecoration(
    private val spacing: Int,
    private val orientation: Int,
    private val spaceFromTop: Int? = null,
    private val spaceFromBottom: Int? = null
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if (position != RecyclerView.NO_POSITION) {
            if (orientation == LinearLayoutManager.VERTICAL) {
                if (position > 0) {
                    outRect.top = spacing
                }
            } else {
                if (position > 0) {
                    outRect.left = spacing
                }
            }
        }

        // if it is the first item (the item on top)
        if ((position == 0) && (orientation == LinearLayoutManager.VERTICAL)) {
            spaceFromTop?.let { spacing ->
                outRect.top = spacing
            }
        }

        // if it is the last item (the item on bottom)
        if ((position == (state.itemCount - 1)) && (orientation == LinearLayoutManager.VERTICAL)) {
            spaceFromBottom?.let { spacing ->
                outRect.bottom = spacing
            }
        }
    }
}

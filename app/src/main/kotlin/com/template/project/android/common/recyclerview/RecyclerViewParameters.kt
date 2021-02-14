package com.template.project.android.common.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.template.project.android.BR
import com.template.project.android.common.LayoutParameters

data class RecyclerViewParameters(
    val layoutManagerType: LayoutManagerType? = null,
    val itemDecoration: RecyclerView.ItemDecoration? = null,
    val layoutParameters: LayoutParameters? = null,
    val viewPoolVariableId: Int = BR.viewPool
)

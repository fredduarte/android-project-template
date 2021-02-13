package com.template.project.android.common.recyclerview

sealed class LayoutManagerType {
    object Vertical : LayoutManagerType()
    object Horizontal : LayoutManagerType()
    class Grid(val spanCount: Int) : LayoutManagerType()
}

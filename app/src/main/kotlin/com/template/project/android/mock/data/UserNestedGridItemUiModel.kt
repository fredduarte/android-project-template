package com.template.project.android.mock.data

import android.view.ViewGroup
import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.LayoutParameters
import com.template.project.android.common.dp2Px
import com.template.project.android.common.recyclerview.BindingNestedUiModel
import com.template.project.android.common.recyclerview.LayoutManagerType
import com.template.project.android.common.recyclerview.RecyclerViewParameters

class UserNestedGridItemUiModel(
    val users: List<UserListItemUiModel>
) : BindingNestedUiModel {

    override val variableId: Int = BR.uiModel
    override val layoutId: Int = R.layout.user_nested_grid_item
    override val recyclerParameters: RecyclerViewParameters = RecyclerViewParameters(
        layoutManagerType = LayoutManagerType.Grid(spanCount = 2),
        itemDecoration = null,
        layoutParameters = LayoutParameters(
            width = ViewGroup.LayoutParams.MATCH_PARENT,
            height = 200.dp2Px()
        ),
        viewPoolVariableId = BR.viewPool
    )
}

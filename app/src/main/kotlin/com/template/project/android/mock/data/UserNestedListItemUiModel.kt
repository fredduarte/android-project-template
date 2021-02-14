package com.template.project.android.mock.data

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.Constants.LIST_ITEMS_SPACING_IN_DP
import com.template.project.android.common.LayoutParameters
import com.template.project.android.common.dp2Px
import com.template.project.android.common.recyclerview.*

class UserNestedListItemUiModel(
    val users: List<UserListItemUiModel>
) : BindingNestedUiModel {

    override val variableId: Int = BR.uiModel
    override val layoutId: Int = R.layout.user_nested_list_item
    override val recyclerParameters: RecyclerViewParameters = RecyclerViewParameters(
        layoutManagerType = LayoutManagerType.Horizontal,
        itemDecoration = LinearSpaceItemDecoration(
            spacing = LIST_ITEMS_SPACING_IN_DP.dp2Px(),
            orientation = LinearLayoutManager.HORIZONTAL,
            spaceFromTop = LIST_ITEMS_SPACING_IN_DP.dp2Px(),
            spaceFromBottom = LIST_ITEMS_SPACING_IN_DP.dp2Px()
        ),
        layoutParameters = LayoutParameters(
            width = ViewGroup.LayoutParams.MATCH_PARENT,
            height = 100.dp2Px()
        ),
        viewPoolVariableId = BR.viewPool
    )
}

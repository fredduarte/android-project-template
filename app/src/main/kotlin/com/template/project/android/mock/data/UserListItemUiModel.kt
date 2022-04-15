package com.template.project.android.mock.data

import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.recyclerview.BindingNestedUiModel
import com.template.project.android.common.recyclerview.RecyclerViewParameters

class UserListItemUiModel(
    val id: Int,
    val name: String,
    val age: Int,
    val profilePhoto: String? = null
) : BindingNestedUiModel {

    override val variableId: Int = BR.uiModel
    override val layoutId: Int = R.layout.user_list_item
    override val recyclerParameters: RecyclerViewParameters? = null
}

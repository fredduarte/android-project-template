package com.template.project.android.mock.data

import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.recyclerview.BindingUiModel

class UserListItemUiModel(
    val id: Int,
    val name: String,
    val age: Int,
    val profilePhoto: String? = null
) : BindingUiModel {

    override val variableId: Int = BR.uiModel
    override val layoutId: Int = R.layout.user_list_item
}

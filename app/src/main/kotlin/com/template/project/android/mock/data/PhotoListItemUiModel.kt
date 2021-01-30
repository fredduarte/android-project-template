package com.template.project.android.mock.data

import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.recyclerview.BindingUiModel

class PhotoListItemUiModel(
    val photoUrl: String? = null
) : BindingUiModel {

    override val variableId: Int = BR.uiModel
    override val layoutId: Int = R.layout.photo_list_item
}


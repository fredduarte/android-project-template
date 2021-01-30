package com.template.project.android.common.uimodel

import android.view.View

class ButtonListItemUiModel(
    val text: String,
    val onClicked: ((View) -> Unit)? = null
) {
    fun onClicked(view: View) {
        onClicked?.invoke(view)
    }
}

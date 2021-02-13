package com.template.project.android.common.binding.adapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.template.project.android.common.LayoutParameters

@BindingAdapter("layoutParameters")
fun layoutParameters(view: View, layoutParameters: LayoutParameters) {
    val layoutParams = view.layoutParams

    layoutParams.width = layoutParameters.width
    layoutParams.height = layoutParameters.height

    view.layoutParams = layoutParams
}

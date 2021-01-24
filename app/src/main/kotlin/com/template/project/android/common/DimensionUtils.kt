package com.template.project.android.common

import android.content.res.Resources

fun Int.dp2Px(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

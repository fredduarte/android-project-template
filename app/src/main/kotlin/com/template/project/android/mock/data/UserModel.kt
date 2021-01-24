package com.template.project.android.mock.data

data class UserModel(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val profilePhoto: String? = null
)

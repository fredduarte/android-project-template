package com.template.project.android.mock.data

private fun UserModel.getFullName(): String {
    var fullName = "NO NAME"

    if (this.firstName.isNotEmpty()) {
        fullName = this.firstName

        if (this.lastName.isNotEmpty()) {
            fullName += " ${this.lastName}"
        }
    } else {
        if (this.lastName.isNotEmpty()) {
            fullName = this.lastName
        }
    }

    return fullName
}

fun UserModel.toUserListItemUiModel(): UserListItemUiModel {
    return UserListItemUiModel(
        id = this.id,
        name = this.getFullName(),
        age = this.age,
        profilePhoto = this.profilePhoto
    )
}

fun UserModel.toPhotoListItemUiModel(): PhotoListItemUiModel {
    return PhotoListItemUiModel(
        photoUrl = this.profilePhoto
    )
}

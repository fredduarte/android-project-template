package com.template.project.android.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.project.android.mock.UsersMockData
import com.template.project.android.mock.data.UserListItemUiModel
import com.template.project.android.mock.data.toUserListItemUiModel

class SimpleListViewModel : ViewModel() {

    private val _users = MutableLiveData<List<UserListItemUiModel>>()
    val users: LiveData<List<UserListItemUiModel>> = _users

    fun getNewUsers() {
        val newUsers = UsersMockData.generateUserModels(count = 30).map { userModel ->
            userModel.toUserListItemUiModel()
        }

        _users.postValue(newUsers)
    }
}
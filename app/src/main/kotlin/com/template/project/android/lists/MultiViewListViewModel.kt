package com.template.project.android.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.project.android.common.recyclerview.BindingUiModel
import com.template.project.android.mock.UsersMockData
import com.template.project.android.mock.data.toPhotoListItemUiModel
import com.template.project.android.mock.data.toUserListItemUiModel
import java.util.Random

class MultiViewListViewModel : ViewModel() {

    private val _uiModels = MutableLiveData<List<BindingUiModel>>()
    val uiModels: LiveData<List<BindingUiModel>> = _uiModels

    fun getNewUiModels() {
        val random = Random()
        var nextInt: Int

        val newUiModels = UsersMockData.generateUserModels(count = 30).map { userModel ->
            nextInt = random.nextInt() % 2

            when {
                (nextInt == 0) -> { userModel.toUserListItemUiModel() }
                else -> { userModel.toPhotoListItemUiModel() }
            }
        }

        _uiModels.postValue(newUiModels)
    }
}

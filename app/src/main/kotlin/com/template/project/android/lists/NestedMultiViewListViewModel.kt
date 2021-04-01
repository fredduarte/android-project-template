package com.template.project.android.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.project.android.common.recyclerview.BindingNestedUiModel
import com.template.project.android.mock.UsersMockData
import com.template.project.android.mock.data.toNestedUserGridItemUiModelList
import com.template.project.android.mock.data.toNestedUserListItemUiModelList
import com.template.project.android.mock.data.toUserListItemUiModel
import java.util.Random

class NestedMultiViewListViewModel : ViewModel() {

    private val _uiModelsNested = MutableLiveData<List<BindingNestedUiModel>>()
    val uiModelsNested: LiveData<List<BindingNestedUiModel>> = _uiModelsNested

    fun getNewUiModelsNested() {
        val maxNumberOfTypes = 3
        val numberOfUiModels = 20
        val newUiModels = mutableListOf<BindingNestedUiModel>()
        val random = Random()
        var nextInt: Int

        for (i in 1..numberOfUiModels) {
            nextInt = random.nextInt() % maxNumberOfTypes

            newUiModels.add(
                when {
                    (nextInt == 0) -> { UsersMockData.generateUserModels(count = 10).toNestedUserListItemUiModelList() }
                    (nextInt == 1) -> { UsersMockData.generateUserModels(count = 10).toNestedUserListItemUiModelList() }
                    else -> { UsersMockData.generateUserModels(count = 10).toNestedUserListItemUiModelList() }
                }
            )
        }

        _uiModelsNested.postValue(newUiModels)
    }
}

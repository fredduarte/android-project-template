package com.template.project.android.mock

import com.template.project.android.mock.data.UserModel
import java.util.Random

object UsersMockData {

    private const val DEFAULT_USERS_COUNT = 10

    private var idCount = 0

    private val USER_FIRST_NAMES = listOf(
        "John", "Maria", "Allan", "Daniel", "Martin", "Paula", "Charlie"
    )
    private val USER_LAST_NAMES = listOf(
        "Doe", "Christine", "Poe", "Sam", "Scorcese", "Adbul", "Brown"
    )
    private val USER_AGES = listOf(
        14, 20, 2, 150, 7, 38, 60
    )
    private val USER_PROFILE_PHOTOS = listOf(
        "https://avatarfiles.alphacoders.com/460/46097.jpg",
        "https://avatarfiles.alphacoders.com/181/181685.jpg",
        "https://avatarfiles.alphacoders.com/108/108459.jpg",
        "https://iodogtraining-wpengine.netdna-ssl.com/wp-content/uploads/2017/04/Barbie-Dog-For-Adoption-Riverside-Ca--thegem-post-thumb-large.jpg",
        "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2018/01/12201051/cute-puppy-body-image.jpg",
        "https://avatarfiles.alphacoders.com/126/126396.jpg",
        "https://images-na.ssl-images-amazon.com/images/I/71qRP8fBVxL._CR0,204,1224,1224_UX256.jpg"
    )

    private val random = Random()

    fun generateUserModels(count: Int = DEFAULT_USERS_COUNT): List<UserModel> {
        val users = mutableListOf<UserModel>()

        for (i in 0 until count) {
            users.add(generateUserModel())
        }

        return users
    }

    private fun generateUserModel(): UserModel {
        val index = random.nextInt(USER_FIRST_NAMES.size) % USER_FIRST_NAMES.size

        return UserModel(
            generateNewId(),
            USER_FIRST_NAMES[index],
            USER_LAST_NAMES[index],
            USER_AGES[index],
            USER_PROFILE_PHOTOS[index]
        )
    }

    private fun generateNewId(): Int {
        return idCount++
    }
}

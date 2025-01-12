package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.UserResponse
import com.example.nelumbotechnicaltest.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() {
    fun mapResponseToUser(userResponse: UserResponse?): User? {
        return userResponse?.let {
            User(
                id = it.id,
                firstName = it.firstName ?: "",
                lastName = it.lastName ?: ""
            )
        }
    }
}

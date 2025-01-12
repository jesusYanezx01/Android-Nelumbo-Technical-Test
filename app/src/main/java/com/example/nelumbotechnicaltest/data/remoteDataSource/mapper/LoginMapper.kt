package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.request.LoginRequest
import com.example.nelumbotechnicaltest.domain.model.Login
import javax.inject.Inject

class LoginMapper @Inject constructor() {
    fun mapLoginToRequest(login: Login): LoginRequest {
        return LoginRequest(
            username = login.userName,
            password = login.password,
        )
    }
}

package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.AuthResponse
import com.example.nelumbotechnicaltest.domain.model.Auth
import javax.inject.Inject

class AuthMapper @Inject constructor() {

    fun mapResponseToAuth(authResponse: AuthResponse?): Auth? {
        return authResponse?.let {
            Auth(
                token = it.token,
            )
        }
    }
}

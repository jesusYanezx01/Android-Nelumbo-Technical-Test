package com.example.nelumbotechnicaltest.data.remoteDataSource.auth

import com.example.nelumbotechnicaltest.data.api_models.Auth
import com.example.nelumbotechnicaltest.data.api_models.AuthResponse
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiClient: AuthApiClient)
{
    suspend fun login(userName: String, password: String): Response<AuthResponse> {
        return authApiClient.login(Auth(userName, password))
    }
}

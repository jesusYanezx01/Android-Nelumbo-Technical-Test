package com.example.nelumbotechnicaltest.data.remoteDataSource.auth

import com.example.nelumbotechnicaltest.data.models.Auth
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiClient: AuthApiClient)
{
    suspend fun login(userName: String, password: String): Response<Unit> {
        return authApiClient.login(Auth(userName, password))
    }
}

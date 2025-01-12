package com.example.nelumbotechnicaltest.data.remoteDataSource.auth

import com.example.nelumbotechnicaltest.data.remoteDataSource.mapper.AuthMapper
import com.example.nelumbotechnicaltest.data.remoteDataSource.mapper.LoginMapper
import com.example.nelumbotechnicaltest.domain.model.Auth
import com.example.nelumbotechnicaltest.domain.model.Login
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiClient: AuthApiClient,
    private val authMapper: AuthMapper,
    private val loginMapper: LoginMapper
) {
    suspend fun login(login: Login): Auth? {
        val response = authApiClient.login(loginMapper.mapLoginToRequest(login))
        return authMapper.mapResponseToAuth(response.body())
    }
}

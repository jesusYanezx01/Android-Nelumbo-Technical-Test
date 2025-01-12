package com.example.nelumbotechnicaltest.data.repositories

import com.example.nelumbotechnicaltest.data.localDataSource.auth.AuthLocalDataSource
import com.example.nelumbotechnicaltest.data.api_models.AuthResponse
import com.example.nelumbotechnicaltest.data.remoteDataSource.auth.AuthRemoteDataSource
import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override suspend fun login(userName: String, password: String): Response<AuthResponse> {
        return authRemoteDataSource.login(userName, password)
    }

    override suspend fun saveToken(token: String) {
        return authLocalDataSource.saveToken(token)
    }
}

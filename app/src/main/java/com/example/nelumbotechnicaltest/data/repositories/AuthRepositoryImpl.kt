package com.example.nelumbotechnicaltest.data.repositories

import com.example.nelumbotechnicaltest.data.localDataSource.auth.AuthLocalDataSource
import com.example.nelumbotechnicaltest.data.remoteDataSource.auth.AuthRemoteDataSource
import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import com.example.nelumbotechnicaltest.domain.model.Auth
import com.example.nelumbotechnicaltest.domain.model.Login
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override suspend fun login(login: Login): Auth? {
        return authRemoteDataSource.login(login)
    }

    override suspend fun saveToken(token: String) {
        return authLocalDataSource.saveToken(token)
    }
}

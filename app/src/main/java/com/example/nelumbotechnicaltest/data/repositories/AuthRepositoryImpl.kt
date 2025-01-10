package com.example.nelumbotechnicaltest.data.repositories

import com.example.nelumbotechnicaltest.data.remoteDataSource.auth.AuthRemoteDataSource
import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {

    override suspend fun login(userName: String, password: String): Response<Unit> {
        return authRemoteDataSource.login(userName, password)
    }
}

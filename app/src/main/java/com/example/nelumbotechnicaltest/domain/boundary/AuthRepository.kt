package com.example.nelumbotechnicaltest.domain.boundary

import retrofit2.Response

interface AuthRepository{
    suspend fun login(userName: String, password: String): Response<Unit>
}

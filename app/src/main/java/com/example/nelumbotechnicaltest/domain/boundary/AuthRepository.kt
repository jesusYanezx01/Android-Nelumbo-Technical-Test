package com.example.nelumbotechnicaltest.domain.boundary

import com.example.nelumbotechnicaltest.data.api_models.AuthResponse
import retrofit2.Response

interface AuthRepository{
    suspend fun login(userName: String, password: String): Response<AuthResponse>

    suspend fun saveToken(token: String)
}

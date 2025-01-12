package com.example.nelumbotechnicaltest.data.remoteDataSource.auth

import com.example.nelumbotechnicaltest.data.api_models.Auth
import com.example.nelumbotechnicaltest.data.api_models.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiClient {

    @POST("/api/v1/auth/signin")
    suspend fun login(@Body loginRequest: Auth): Response<AuthResponse>
}
package com.example.nelumbotechnicaltest.domain.boundary

import com.example.nelumbotechnicaltest.domain.model.Auth
import com.example.nelumbotechnicaltest.domain.model.Login

interface AuthRepository{
    suspend fun login(login: Login): Auth?

    suspend fun saveToken(token: String)
}

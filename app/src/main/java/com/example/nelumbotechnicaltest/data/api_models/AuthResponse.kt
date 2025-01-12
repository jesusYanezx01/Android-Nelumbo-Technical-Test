package com.example.nelumbotechnicaltest.data.api_models

import com.google.gson.annotations.SerializedName

data class AuthResponse (
    @SerializedName("token")
    val token: String
)

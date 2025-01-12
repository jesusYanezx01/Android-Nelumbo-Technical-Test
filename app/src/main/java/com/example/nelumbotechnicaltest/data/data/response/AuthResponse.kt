package com.example.nelumbotechnicaltest.data.data.response

import com.google.gson.annotations.SerializedName

data class AuthResponse (
    @SerializedName("token")
    val token: String
)

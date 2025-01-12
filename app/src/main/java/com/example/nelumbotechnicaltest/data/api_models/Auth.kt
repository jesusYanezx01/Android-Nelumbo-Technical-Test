package com.example.nelumbotechnicaltest.data.api_models

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
)

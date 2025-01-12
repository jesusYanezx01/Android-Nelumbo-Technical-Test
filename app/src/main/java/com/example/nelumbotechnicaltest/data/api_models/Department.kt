package com.example.nelumbotechnicaltest.data.api_models

import com.google.gson.annotations.SerializedName

data class Department(
    @SerializedName("name")
    val name: String,
    @SerializedName("userManage")
    val userManage: User?
)

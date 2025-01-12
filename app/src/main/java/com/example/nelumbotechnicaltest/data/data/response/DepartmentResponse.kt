package com.example.nelumbotechnicaltest.data.data.response

import com.google.gson.annotations.SerializedName

data class DepartmentResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("userManage")
    val userManage: UserResponse?
)

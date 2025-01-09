package com.example.nelumbotechnicaltest.data.models

data class User(
    val id: Int,
    val firstName: String?,
    val lastName: String,
    val email: String,
    val username: String,
    val curp: String,
)
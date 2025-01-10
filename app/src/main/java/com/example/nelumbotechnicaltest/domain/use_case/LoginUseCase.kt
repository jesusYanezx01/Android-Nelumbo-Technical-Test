package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): Result<Unit> {
        return try {
            val response = authRepository.login(username, password)
            if (response.isSuccessful) {
                val authResponse = response.body()
                authResponse?.let { authRepository.saveToken(it.token) }
                Result.success(Unit)
            } else {
                Result.failure(Exception("Error en el login: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

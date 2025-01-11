package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import com.example.nelumbotechnicaltest.domain.helpers.CoroutineExecutor
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val coroutineExecutor: CoroutineExecutor
) {
    suspend fun execute(username: String, password: String): Result<Unit> {
        return coroutineExecutor.execute {
            val response = authRepository.login(username, password)
            if (response.isSuccessful) {
                val authResponse = response.body()
                authResponse?.let { authRepository.saveToken(it.token) }
                Unit
            }
        }
    }
}

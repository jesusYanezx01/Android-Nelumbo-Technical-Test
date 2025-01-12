package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import com.example.nelumbotechnicaltest.domain.helpers.CoroutineExecutor
import com.example.nelumbotechnicaltest.domain.model.Login
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val coroutineExecutor: CoroutineExecutor
) {
    suspend fun execute(login: Login): Result<Unit> {
        return coroutineExecutor.execute {
            val response = authRepository.login(login)
            response?.let {
                authRepository.saveToken(it.token)
            }
        }
    }
}

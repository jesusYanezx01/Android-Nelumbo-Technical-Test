package com.example.nelumbotechnicaltest.domain.helpers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoroutineExecutor @Inject constructor() {
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    suspend fun <T> execute(task: suspend () -> T): Result<T> {
        return try {
            val result = withContext(dispatcher) {
                task()
            }
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
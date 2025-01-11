package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.domain.boundary.RequestRepository
import com.example.nelumbotechnicaltest.domain.helpers.CoroutineExecutor
import javax.inject.Inject

class FetchRequestUseCase @Inject constructor(
    private val requestRepository: RequestRepository,
    private val coroutineExecutor: CoroutineExecutor
) {

    suspend fun execute(limit: Int, order: String): Result<List<Request>> {
        return coroutineExecutor.execute {
            requestRepository.getRequests(limit, order)
        }
    }
}
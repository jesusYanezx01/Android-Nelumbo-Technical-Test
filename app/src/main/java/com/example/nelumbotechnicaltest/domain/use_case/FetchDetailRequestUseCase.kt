package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.domain.boundary.RequestRepository
import com.example.nelumbotechnicaltest.domain.helpers.CoroutineExecutor
import com.example.nelumbotechnicaltest.domain.model.Request
import javax.inject.Inject

class FetchDetailRequestUseCase @Inject constructor(
    private val requestRepository: RequestRepository,
    private val coroutineExecutor: CoroutineExecutor
) {

    suspend fun execute(idRequest: String): Result<Request?> {
        return coroutineExecutor.execute {
            requestRepository.getDetailRequest(idRequest)
        }
    }
}

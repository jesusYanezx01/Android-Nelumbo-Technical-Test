package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.domain.boundary.RequestRepository
import javax.inject.Inject

class FetchDetailRequestUseCase @Inject constructor(private val requestRepository: RequestRepository) {
    suspend operator fun invoke(idRequest: String): Request {
        return requestRepository.getDetailRequest(idRequest)
    }
}

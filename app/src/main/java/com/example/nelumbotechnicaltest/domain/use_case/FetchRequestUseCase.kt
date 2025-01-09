package com.example.nelumbotechnicaltest.domain.use_case

import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.domain.boundary.RequestRepository
import javax.inject.Inject

class FetchRequestUseCase @Inject constructor(private val requestRepository: RequestRepository) {
    suspend operator fun invoke(limit: Int, order: String): List<Request> {
        return requestRepository.getRequests(limit, order)
    }
}
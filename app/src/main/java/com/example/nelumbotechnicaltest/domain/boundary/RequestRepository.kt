package com.example.nelumbotechnicaltest.domain.boundary

import com.example.nelumbotechnicaltest.data.api_models.Request

interface RequestRepository {
    suspend fun getRequests(limit: Int, order: String): List<Request>
    suspend fun getDetailRequest(idRequest: String): Request
}

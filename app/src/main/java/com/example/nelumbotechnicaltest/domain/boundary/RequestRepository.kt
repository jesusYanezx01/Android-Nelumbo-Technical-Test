package com.example.nelumbotechnicaltest.domain.boundary

import com.example.nelumbotechnicaltest.domain.model.Request

interface RequestRepository {
    suspend fun getRequests(limit: Int, order: String): List<Request>?
    suspend fun getDetailRequest(idRequest: String): Request?
}

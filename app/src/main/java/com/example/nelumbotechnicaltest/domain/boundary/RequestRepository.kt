package com.example.nelumbotechnicaltest.domain.boundary

import com.example.nelumbotechnicaltest.data.models.Request

interface RequestRepository {
    suspend fun getRequests(limit: Int, order: String): List<Request>
}
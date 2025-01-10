package com.example.nelumbotechnicaltest.data.remoteDataSource.request

import com.example.nelumbotechnicaltest.data.models.Request
import javax.inject.Inject

class RequestRemoteDataSource @Inject constructor(
    private val requestApiClient: RequestApiClient,
) {
    suspend fun fetchRequests(limit: Int, order: String): List<Request> {
        return requestApiClient.getRequests(limit, order)
    }

    suspend fun fetchDetailRequest(idRequest: String): Request {
        return requestApiClient.getDetailRequest(idRequest)
    }
}

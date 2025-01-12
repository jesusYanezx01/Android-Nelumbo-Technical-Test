package com.example.nelumbotechnicaltest.data.remoteDataSource.request

import com.example.nelumbotechnicaltest.data.remoteDataSource.mapper.RequestMapper
import com.example.nelumbotechnicaltest.domain.model.Request
import javax.inject.Inject

class RequestRemoteDataSource @Inject constructor(
    private val requestApiClient: RequestApiClient,
    private val requestMapper: RequestMapper
) {
    suspend fun fetchRequests(limit: Int, order: String): List<Request>? {
        val response = requestApiClient.getRequests(limit, order)
        return requestMapper.mapResponseToRequestList(response.body())
    }

    suspend fun fetchDetailRequest(idRequest: String): Request? {
        val response = requestApiClient.getDetailRequest(idRequest)
        return requestMapper.mapResponseToRequest(response.body())
    }
}

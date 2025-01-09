package com.example.nelumbotechnicaltest.data.repositories

import com.example.nelumbotechnicaltest.data.models.Request
import com.example.nelumbotechnicaltest.data.remoteDataSource.request.RequestRemoteDataSource
import com.example.nelumbotechnicaltest.domain.boundary.RequestRepository
import javax.inject.Inject

class RequestRepositoryImpl @Inject constructor(
    private val remoteDataSource: RequestRemoteDataSource
) : RequestRepository {

    override suspend fun getRequests(limit: Int, order: String): List<Request> {
        return remoteDataSource.fetchRequests(limit, order)
    }
}
package com.example.nelumbotechnicaltest.data.remoteDataSource.request

import com.example.nelumbotechnicaltest.data.models.Request
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestApiClient {
    @GET("api/v1/report-folio/mobile/filters")
    suspend fun getRequests(
        @Query("limit") limit: Int,
        @Query("order") order: String
    ): List<Request>

    @GET("/api/v1/report-folio/{id}")
    suspend fun getDetailRequest(
        @Path("id") idRequest: String,
    ): Request
}

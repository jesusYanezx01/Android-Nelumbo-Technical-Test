package com.example.nelumbotechnicaltest.data.remoteDataSource.request

import com.example.nelumbotechnicaltest.data.data.response.RequestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestApiClient {
    @GET("api/v1/report-folio/mobile/filters")
    suspend fun getRequests(
        @Query("limit") limit: Int,
        @Query("order") order: String
    ): Response<List<RequestResponse>>

    @GET("/api/v1/report-folio/{id}")
    suspend fun getDetailRequest(
        @Path("id") idRequest: String,
    ): Response<RequestResponse>
}

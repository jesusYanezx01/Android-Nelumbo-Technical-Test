package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.StatusResponse
import com.example.nelumbotechnicaltest.domain.model.Status
import javax.inject.Inject

class StatusMapper @Inject constructor() {
    fun mapResponseToStatus(statusResponse: StatusResponse?): Status? {
        return statusResponse?.let {
            Status(
                description = it.description,
            )
        }
    }
}

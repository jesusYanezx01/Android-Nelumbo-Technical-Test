package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.PriorityResponse
import com.example.nelumbotechnicaltest.domain.model.Priority
import javax.inject.Inject

class PriorityMapper @Inject constructor() {
    fun mapResponseToPriority(priorityResponse: PriorityResponse?): Priority? {
        return priorityResponse?.let {
            Priority(
                name = it.name,
            )
        }
    }
}

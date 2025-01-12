package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.AreaResponse
import com.example.nelumbotechnicaltest.domain.model.Area
import javax.inject.Inject

class AreaMapper @Inject constructor() {
    fun mapAreaResponseToArea(areaResponse: AreaResponse?): Area? {
        return areaResponse?.let {
            Area(
                name = it.name,
            )
        }
    }
}

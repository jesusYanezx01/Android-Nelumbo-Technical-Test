package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.StoreResponse
import com.example.nelumbotechnicaltest.domain.model.Store
import javax.inject.Inject

class StoreMapper @Inject constructor() {
    fun mapResponseToStore(storeResponse: StoreResponse?): Store? {
        return storeResponse?.let {
            Store(
                name = it.name,
            )
        }
    }
}

package com.example.nelumbotechnicaltest.di

import com.example.nelumbotechnicaltest.data.repositories.AuthRepositoryImpl
import com.example.nelumbotechnicaltest.data.repositories.RequestRepositoryImpl
import com.example.nelumbotechnicaltest.domain.boundary.AuthRepository
import com.example.nelumbotechnicaltest.domain.boundary.RequestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRequestRepository(requestRepository: RequestRepositoryImpl): RequestRepository

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}
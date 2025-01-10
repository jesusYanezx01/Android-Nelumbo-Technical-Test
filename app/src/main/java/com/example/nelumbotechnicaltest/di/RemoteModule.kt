package com.example.nelumbotechnicaltest.di

import com.example.nelumbotechnicaltest.data.localDataSource.auth.AuthLocalDataSource
import com.example.nelumbotechnicaltest.data.remoteDataSource.auth.AuthApiClient
import com.example.nelumbotechnicaltest.data.remoteDataSource.interceptor.AuthInterceptor
import com.example.nelumbotechnicaltest.data.remoteDataSource.request.RequestApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun provideAuthInterceptor(authLocalDataSource: AuthLocalDataSource): AuthInterceptor {
        return AuthInterceptor(authLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://checkapidev.nelumbo.com.co")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRequestApiClient(retrofit: Retrofit): RequestApiClient {
        return retrofit.create(RequestApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthApiClient(retrofit: Retrofit): AuthApiClient {
        return retrofit.create(AuthApiClient::class.java)
    }
}

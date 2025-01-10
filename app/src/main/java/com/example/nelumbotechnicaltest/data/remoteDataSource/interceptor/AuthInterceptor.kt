package com.example.nelumbotechnicaltest.data.remoteDataSource.interceptor

import com.example.nelumbotechnicaltest.data.localDataSource.auth.AuthLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = authLocalDataSource.loadToken()

        val request = chain.request().newBuilder().apply {
            if (token.isNotEmpty()) {
                addHeader("Authorization", "Bearer $token")
            }
        }.build()

        return chain.proceed(request)
    }
}
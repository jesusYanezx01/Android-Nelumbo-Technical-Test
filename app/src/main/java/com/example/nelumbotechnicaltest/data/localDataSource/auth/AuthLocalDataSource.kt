package com.example.nelumbotechnicaltest.data.localDataSource.auth

import com.example.nelumbotechnicaltest.data.localDataSource.preferences.SharedPreferencesHelper
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) {

    fun saveToken(token: String) {
        sharedPreferencesHelper.writeString("token", token)
    }

    fun loadToken(): String = sharedPreferencesHelper.readString("token")

    fun deleteToken() {
        sharedPreferencesHelper.remove("token")
    }

    fun isUserLogged(): Boolean = sharedPreferencesHelper.readString("token").isNotEmpty()
}

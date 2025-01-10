package com.example.nelumbotechnicaltest.data.localDataSource.preferences

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesHelper @Inject constructor(@ApplicationContext val context: Context) {

    companion object {
        private const val PREFS_NAME = "PrefsFile"
    }

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun writeString(key: String, value: String) {
        with(prefs.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun readString(key: String): String = prefs.getString(key, "") ?: ""

    fun remove(key: String) {
        with(prefs.edit()) {
            remove(key)
            apply()
        }
    }
}

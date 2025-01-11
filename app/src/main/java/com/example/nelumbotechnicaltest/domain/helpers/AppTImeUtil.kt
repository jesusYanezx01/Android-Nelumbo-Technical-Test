package com.example.nelumbotechnicaltest.domain.helpers

import android.annotation.SuppressLint
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class AppTimeUtil {

    companion object {
        @SuppressLint("NewApi")
        private val outputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

        @SuppressLint("NewApi")
        fun formatIsoDateToCustom(dateString: String): String {
            return try {
                val instant = Instant.parse(dateString)
                val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                outputFormatter.format(localDateTime)
            } catch (e: Exception) {
                "Fecha inválida"
            }
        }
    }
}
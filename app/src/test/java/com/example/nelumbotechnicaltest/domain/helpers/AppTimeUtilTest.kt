package com.example.nelumbotechnicaltest.domain.helpers

import junit.framework.TestCase.assertEquals
import org.junit.Test

class AppTimeUtilTest {

    @Test
    fun `formatIsoDateToCustom should format valid ISO date`() {
        val validIsoDate = "2023-01-12T15:30:00Z"
        val expectedFormattedDate = "12/01/2023 10:30"

        val result = AppTimeUtil.formatIsoDateToCustom(validIsoDate)

        assertEquals(expectedFormattedDate, result)
    }

    @Test
    fun `formatIsoDateToCustom should handle invalid date`() {
        val invalidDate = "Invalid Date"

        val result = AppTimeUtil.formatIsoDateToCustom(invalidDate)

        assertEquals("Fecha inválida", result)
    }

    @Test
    fun `formatIsoDateToCustom should handle empty date string`() {
        val emptyDate = ""

        val result = AppTimeUtil.formatIsoDateToCustom(emptyDate)

        assertEquals("Fecha inválida", result)
    }
}
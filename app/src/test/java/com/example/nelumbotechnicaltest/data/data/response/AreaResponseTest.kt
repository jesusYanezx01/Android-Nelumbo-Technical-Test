package com.example.nelumbotechnicaltest.data.data.response

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class AreaResponseTest {

    private val gson = Gson()

    @Test
    fun `test object creation`() {
        val name = "Test Area"
        val areaResponse = AreaResponse(name)

        assertEquals("Test Area", areaResponse.name)
    }

    @Test
    fun `test Gson deserialization`() {
        val json = """{"name": "Test Area"}"""
        val areaResponse = gson.fromJson(json, AreaResponse::class.java)

        assertEquals("Test Area", areaResponse.name)
    }

    @Test
    fun `test Gson serialization`() {
        val areaResponse = AreaResponse("Test Area")
        val json = gson.toJson(areaResponse)

        assertEquals("""{"name":"Test Area"}""", json)
    }
}

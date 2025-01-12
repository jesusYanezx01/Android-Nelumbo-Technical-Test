package com.example.nelumbotechnicaltest.data.remoteDataSource.mapper

import com.example.nelumbotechnicaltest.data.data.response.AreaResponse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Before
import org.junit.Test

class AreaMapperTest {

    private lateinit var areaMapper: AreaMapper

    @Before
    fun setUp() {
        areaMapper = AreaMapper()
    }

    @Test
    fun `mapAreaResponseToArea returns Area when AreaResponse is not null`() {
        val areaResponse = AreaResponse(name = "Test Area")

        val result = areaMapper.mapAreaResponseToArea(areaResponse)

        assertEquals("Test Area", result?.name)
    }

    @Test
    fun `mapAreaResponseToArea returns null when AreaResponse is null`() {
        val result = areaMapper.mapAreaResponseToArea(null)

        assertNull(result)
    }
}
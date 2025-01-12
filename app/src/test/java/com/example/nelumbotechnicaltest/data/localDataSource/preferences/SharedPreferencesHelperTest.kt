package com.example.nelumbotechnicaltest.data.localDataSource.preferences

import android.content.Context
import android.content.SharedPreferences
import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SharedPreferencesHelperTest {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    private val mockContext: Context = mockk()
    private val mockSharedPreferences: SharedPreferences = mockk()
    private val mockEditor: SharedPreferences.Editor = mockk()

    @Before
    fun setUp() {
        every { mockContext.getSharedPreferences(any(), any()) } returns mockSharedPreferences
        every { mockSharedPreferences.edit() } returns mockEditor
        every { mockEditor.putString(any(), any()) } returns mockEditor
        every { mockEditor.remove(any()) } returns mockEditor
        every { mockEditor.apply() } just Runs

        sharedPreferencesHelper = SharedPreferencesHelper(mockContext)
    }

    @Test
    fun `test writeString stores value`() {
        val key = "testKey"
        val value = "testValue"

        sharedPreferencesHelper.writeString(key, value)

        verify { mockEditor.putString(key, value) }
        verify { mockEditor.apply() }
    }

    @Test
    fun `test readString retrieves stored value`() {
        val key = "testKey"
        val expectedValue = "testValue"

        every { mockSharedPreferences.getString(key, "") } returns expectedValue

        val result = sharedPreferencesHelper.readString(key)

        assertEquals(expectedValue, result)
        verify { mockSharedPreferences.getString(key, "") }
    }

    @Test
    fun `test remove deletes value`() {
        val key = "testKey"

        sharedPreferencesHelper.remove(key)

        verify { mockEditor.remove(key) }
        verify { mockEditor.apply() }
    }
}
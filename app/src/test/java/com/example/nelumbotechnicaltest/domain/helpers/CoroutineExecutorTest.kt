package com.example.nelumbotechnicaltest.domain.helpers

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class CoroutineExecutorTest {

    private val coroutineExecutor = CoroutineExecutor()

    @Test
    fun `execute returns success result when task completes`() = runBlocking {
        val expectedValue = "Task Result"
        val task: suspend () -> String = { expectedValue }

        val result = coroutineExecutor.execute(task)

        assertTrue(result.isSuccess)
        assertEquals(expectedValue, result.getOrNull())
    }

    @Test
    fun `execute returns failure result when task throws exception`() = runBlocking {
        val exception = IllegalArgumentException("Test Exception")
        val task: suspend () -> String = { throw exception }

        val result = coroutineExecutor.execute(task)

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is IllegalArgumentException)
        assertEquals("Test Exception", result.exceptionOrNull()?.message)
    }
}
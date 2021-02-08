package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ExtensionsKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun sortDescAndDistinctAndRemoveNulls() {
    }

    @Test
    fun `should return empty list for null`() {
        val result = emptyList<Int>()
        val testData = null

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should return empty list for empty list`() {
        val result = emptyList<Int>()
        val testData = emptyList<Int>()

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should return same list for single mot null element list`() {
        val result = listOf(147)
        val testData = listOf(147)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should remove duplicate elements`() {
        val result = listOf(147)
        val testData = listOf(147, 147, 147, 147, 147, 147, 147)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should desc sort elements`() {
        val result = listOf(5, 4, 3, 2, 1)
        val testData = listOf(1, 4, 2, 5, 3)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should remove null elements`() {
        val result = listOf(5, 4, 3, 2, 1)
        val testData = listOf(1, 4, 2, null, 5, 3, null)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should do nothing for sorted list`() {
        val result = listOf(5, 4, 3, 2, 1)
        val testData = listOf(5, 4, 3, 2, 1)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should return desc sorted list`() {
        val result = listOf(5, 4, 3, 2, 1)
        val testData = listOf(1, 2, 3, 4, 5)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should return desc sorted list for elements with minus`() {
        val result = listOf(-1, -2, -3, -4, -5)
        val testData = listOf(-5, -4, -3, -2, -1)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should return desc sorted list with duplicate and null elements and minus elements`() {
        val result = listOf(2, 1, 0, -42)
        val testData = listOf(1, 1, 1, null, null, 0, 0, 0, -42, 0, -42, null, 2)

        assertEquals(result, sortDescAndDistinctAndRemoveNulls(testData))
    }

    @Test
    fun `should failed`() {
        val result = listOf(1, 2, 3, 4, 5)
        val testData = listOf(1, 2, 3, 4, 5)

        assertNotEquals("Should failed", result, sortDescAndDistinctAndRemoveNulls(testData))
    }
}
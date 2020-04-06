package com.ayon.core.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtensionsKtTest {

    @Test
    fun `should return expected hash for problematic string`() {
        val stringToEncode = "q4m'x68n6_YDB4ty8VC4&}wqBtn^68W"
        val expected = "0c70bb931f03b75af1591f261eb77d0b"

        assertEquals(expected, stringToEncode.toMD5())
    }

    @Test
    fun `should return expected hash for marvel`() {
        val stringToEncode = "marvel"
        val expected = "0e561187d51609f59a35e1079f062c7a"

        assertEquals(expected, stringToEncode.toMD5())
    }

    @Test
    fun `should return expected for empty`() {
        val expected = "d41d8cd98f00b204e9800998ecf8427e"
        assertEquals(expected, "".toMD5())
    }
}
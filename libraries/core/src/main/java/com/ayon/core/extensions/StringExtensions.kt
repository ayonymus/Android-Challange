package com.ayon.core.extensions

import java.security.MessageDigest

/* https://www.javacodemonk.com/md5-and-sha256-in-java-kotlin-and-android-96ed9628 */
fun String.toMD5(): String {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.toHex()
}

private fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}
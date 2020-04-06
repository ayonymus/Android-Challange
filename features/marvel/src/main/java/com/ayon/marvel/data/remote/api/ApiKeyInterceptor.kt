package com.ayon.marvel.data.remote.api

import com.ayon.core.extensions.toMD5
import com.ayon.marvel.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor(): Interceptor {

    private val timestamp = Date().time.toString()
    private val hash = (timestamp + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_KEY).toMD5()

    override fun intercept(chain: Interceptor.Chain): Response {

        val url = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("apikey", BuildConfig.MARVEL_KEY)
            .addQueryParameter("hash", hash)
            .addQueryParameter("ts", timestamp)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}
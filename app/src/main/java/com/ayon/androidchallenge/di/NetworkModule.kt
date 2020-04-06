package com.ayon.androidchallenge.di

import com.ayon.androidchallenge.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor

@Module
class NetworkModule {

    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = when {
                BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

}

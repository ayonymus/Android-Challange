package com.ayonymus.androidchallenge.di

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Module for providing the Android base framework related injections where necessary
 */
@Module
class AndroidModule(private val appContext: Context) {

    @Provides
    fun provideApplicationContext(): Context = appContext

}

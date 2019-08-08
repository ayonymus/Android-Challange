package com.ayonymus.androidchallenge.di

import android.content.Context
import com.ayonymus.androidchallenge.presentation.rx.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Module for providing the Android base framework related injections where necessary, e.g application context or
 * SharedPreferences
 */
@Module
class AndroidModule(private val appContext: Context) {

    @Provides
    fun provideApplicationContext(): Context = appContext

    @Provides
    fun provideRxSchedulers(): RxSchedulers {
        return object : RxSchedulers {
            override fun io() = Schedulers.io()
            override fun main() = AndroidSchedulers.mainThread()
        }
    }
}

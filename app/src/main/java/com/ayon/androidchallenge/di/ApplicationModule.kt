package com.ayon.androidchallenge.di

import android.app.Application
import com.ayon.androidchallenge.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Provides
    @JvmStatic
    @Singleton
    internal fun provideApplication(app: App): Application = app

}

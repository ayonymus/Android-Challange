package com.ayon.androidchallenge.di

import android.app.Application
import android.content.Context
import com.ayon.androidchallenge.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplication(app: App): Application = app

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context = application.applicationContext

}

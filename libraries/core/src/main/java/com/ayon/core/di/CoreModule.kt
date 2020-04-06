package com.ayon.core.di

import com.ayon.core.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideSchedulers() = SchedulerProvider()

}

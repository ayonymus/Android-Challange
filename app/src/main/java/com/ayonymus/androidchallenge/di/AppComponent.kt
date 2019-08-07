package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.presentation.MainFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AndroidModule::class,
    DataModule::class,
    FrameworkModule::class,
    NetworkModule::class,
    ViewModelModule::class
])
@Singleton
interface AppComponent {

    fun inject(fragment: MainFragment)

}

package com.ayon.androidchallenge.di

import com.ayon.androidchallenge.presentation.MainFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AndroidModule::class,
    DataModule::class,
    ViewModelModule::class
])
@Singleton
interface AppComponent {

    fun inject(fragment: MainFragment)

}

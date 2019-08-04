package com.ayonymus.androidchallenge.di

import com.ayonymus.androidchallenge.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    AndroidModule::class
])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

}

package com.ayon.androidchallenge.di

import com.ayon.androidchallenge.App
import com.ayon.core.di.CoreModule
import com.ayon.marvel.di.MarvelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        CoreModule::class,
        NetworkModule::class,
        MarvelModule::class ])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<App>()
}

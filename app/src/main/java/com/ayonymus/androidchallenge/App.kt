package com.ayonymus.androidchallenge

import android.app.Application
import com.ayonymus.androidchallenge.di.AndroidModule
import com.ayonymus.androidchallenge.di.AppComponent
import com.ayonymus.androidchallenge.di.DaggerAppComponent
import timber.log.Timber

class App: Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder()
            .androidModule(AndroidModule(this))
            .build()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {

        private lateinit var instance: App

        /**
         * getComponent() is safe to call from any activity or fragment's onCreate method.
         * Those lifecycle methods are not called by the framework unless the App's onCreate() had been
         * invoked first.
         */
        @JvmStatic
        fun getComponent(): AppComponent = instance.component

    }
}

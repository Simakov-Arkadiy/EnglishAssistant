package com.example.englishassistant.presentation.di

import android.app.Application
import com.example.englishassistant.presentation.di.DaggerAppComponent

class App : Application() {
    internal val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().providesModule(ProvidesModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}

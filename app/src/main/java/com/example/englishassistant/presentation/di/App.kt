package com.example.englishassistant.presentation.di

import android.app.Application
import com.example.englishassistant.presentation.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder()
            .providesModule(ProvidesModule(this))
            .build()
    }
}

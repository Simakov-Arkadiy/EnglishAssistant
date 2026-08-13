package com.example.englishassistant.presentation.di

import com.example.englishassistant.presentation.RecordScreenViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProvidesModule::class, BindsModule::class])
internal interface AppComponent {
    fun recordScreenViewModel(): RecordScreenViewModel
}
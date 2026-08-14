package com.example.englishassistant.presentation.di

import com.example.englishassistant.presentation.RecordScreenViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProvidesModule::class, BindsModule::class])
internal interface AppComponent {
    fun recordScreenViewModelFactory(): RecordScreenViewModelFactory
}
package com.example.englishassistant.presentation.di

import com.example.englishassistant.data.RepositoryImpl
import com.example.englishassistant.domain.WordPairRepository
import dagger.Binds
import dagger.Module

@Module
internal interface BindsModule {
    @Binds
    fun bindRepository(repository: RepositoryImpl): WordPairRepository
}
package com.example.englishassistant.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.englishassistant.data.EnglishAssistantDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
internal class ProvidesModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideEnglishAssistantDataBase(context: Application): EnglishAssistantDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = EnglishAssistantDataBase::class.java,
            name = "User_database"

        ).fallbackToDestructiveMigration().build()
    }
}
package com.example.englishassistant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(EntityWordPair::class)], version = 1)
internal abstract class EnglishAssistantDataBase : RoomDatabase() {

    abstract fun baseDao(): BaseDao
}
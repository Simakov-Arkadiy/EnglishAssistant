package com.example.englishassistant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(EntityWordPair::class)], version = 1)
internal abstract class EnglishAssistantDataBase : RoomDatabase() {

    abstract fun baseDao(): BaseDao
    companion object {
        private var INSTANCE: EnglishAssistantDataBase? = null
        fun getInstance(context: Context): EnglishAssistantDataBase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EnglishAssistantDataBase::class.java,
                        "User_database"

                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
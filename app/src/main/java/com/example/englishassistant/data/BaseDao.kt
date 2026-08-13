package com.example.englishassistant.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
internal interface BaseDao {
    @Insert
    suspend fun insert(wordPair: EntityWordPair)
}
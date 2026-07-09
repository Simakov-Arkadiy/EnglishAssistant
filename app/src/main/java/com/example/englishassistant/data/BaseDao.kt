package com.example.englishassistant.data

import androidx.room.Dao
import androidx.room.Insert
import com.example.englishassistant.domain.WordPairInterface

@Dao
internal interface BaseDao {
    @Insert
    suspend fun insert(wordPair: WordPairInterface)
}
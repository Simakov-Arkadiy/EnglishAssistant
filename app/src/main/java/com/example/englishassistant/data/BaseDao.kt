package com.example.englishassistant.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface BaseDao {
    @Insert
    suspend fun insert(wordPair: EntityWordPair)

    @Query("SELECT * FROM wordPairs WHERE wordEn = :word OR wordRu = :word")
    suspend fun getWordPairs(word:String): EntityWordPair
}
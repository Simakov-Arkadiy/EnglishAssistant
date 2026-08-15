package com.example.englishassistant.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface BaseDao {
    @Insert
    suspend fun insert(wordPair: EntityWordPair)

    @Query("SELECT * FROM wordPairs WHERE wordEn = :wordRu OR wordRu = :wordRu")
    suspend fun getWordPairs(wordRu:String, wordEn:String): List<EntityWordPair>
}
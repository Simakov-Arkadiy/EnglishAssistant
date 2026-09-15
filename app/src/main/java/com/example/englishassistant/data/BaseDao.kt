package com.example.englishassistant.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface BaseDao {
    @Insert
    suspend fun insert(wordPair: EntityWordPair)

    @Query("SELECT * FROM wordPairs WHERE wordEn = :word OR wordRu = :word")
    suspend fun getWordPairUnWeighted(word: String): EntityWordPair

    @Query("SELECT * FROM wordPairs ORDER BY weight ASC LIMIT :limit")
    suspend fun getWordPairsWeighted(limit: Int): List<EntityWordPair>

    @Query("UPDATE wordPairs SET weight = weight + 1 WHERE id IN (:pairs)")
    suspend fun updateWeights(pairs:List<Int>)
}
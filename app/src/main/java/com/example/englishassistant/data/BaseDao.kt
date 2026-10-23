package com.example.englishassistant.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface BaseDao {
    @Insert
    suspend fun insert(wordPair: EntityWordPair)

    @Query(
        """
    SELECT * FROM wordPairs 
    WHERE LOWER(wordRu) LIKE LOWER(:subStr) || '%' 
       OR LOWER(wordEn) LIKE LOWER(:subStr) || '%'
"""
    )
    suspend fun getWordPairUnWeighted(subStr: String): List<EntityWordPair>

    @Query("SELECT * FROM wordPairs ORDER BY weight ASC LIMIT :limit")
    suspend fun getWordPairsWeighted(limit: Int): List<EntityWordPair>

    @Query("UPDATE wordPairs SET weight = weight + 1 WHERE id IN (:pairs)")
    suspend fun updateWeights(pairs: List<Int>)
}
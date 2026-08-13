package com.example.englishassistant.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.englishassistant.domain.WordPair

@Entity(tableName = "wordPairs")
internal data class EntityWordPair(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    override val wordRu: String,
    override val wordEn: String,
) : WordPair
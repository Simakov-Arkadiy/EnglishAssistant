package com.example.englishassistant.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wordPairs")
internal data class WordPairsTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @Embedded
    val entityWordPair: EntityWordPair,
    )
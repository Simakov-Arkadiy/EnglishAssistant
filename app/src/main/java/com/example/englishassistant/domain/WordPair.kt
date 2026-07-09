package com.example.englishassistant.domain

internal data class WordPair(
    override val wordRu:String,
    override val wordEn:String,
): WordPairInterface {
}
package com.example.englishassistant.domain

internal data class WordPairImpl(
    override val wordRu: String,
    override val wordEn: String,
) : WordPair {
}
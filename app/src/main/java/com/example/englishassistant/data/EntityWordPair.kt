package com.example.englishassistant.data

import com.example.englishassistant.domain.WordPairInterface

internal data class EntityWordPair(
    override val wordRu: String,
    override val wordEn: String
) : WordPairInterface

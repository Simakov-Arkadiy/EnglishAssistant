package com.example.englishassistant.domain

internal interface Repository {
    suspend fun recordWordPair(wordPair: WordPair): Result<Boolean>
}
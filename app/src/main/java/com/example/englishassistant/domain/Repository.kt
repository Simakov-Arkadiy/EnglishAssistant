package com.example.englishassistant.domain

internal interface Repository {
    suspend fun writingWordPair(wordPair: WordPair): Result<Boolean>
}
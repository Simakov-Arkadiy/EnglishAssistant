package com.example.englishassistant.domain

internal interface RepositoryInterface {
    suspend fun writingWordPair(wordPair: WordPairInterface): Result<Boolean>
}
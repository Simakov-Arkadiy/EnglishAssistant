package com.example.englishassistant.domain

internal interface Repository {
    suspend fun recordWordPair(wordPair: WordPair): Result<Boolean>
    suspend fun getWordPairUnWeighted(word: String): Result<WordPair>
    suspend fun getWordPairsWeighted(): Result<List<WordPair>>
}
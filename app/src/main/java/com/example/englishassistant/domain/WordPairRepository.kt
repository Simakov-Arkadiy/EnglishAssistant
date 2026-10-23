package com.example.englishassistant.domain

internal interface WordPairRepository {
    suspend fun recordWordPair(wordPair: WordPair): Result<Boolean>
    suspend fun getWordPairUnweighted(subStr: String): Result<List<WordPair>>
    suspend fun getWordPairsWeighted(limit:Int): Result<List<WordPair>>
}
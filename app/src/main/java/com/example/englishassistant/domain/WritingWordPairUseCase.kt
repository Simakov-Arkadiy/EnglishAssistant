package com.example.englishassistant.domain

internal class WritingWordPairUseCase(
    val repository: Repository
) {
    suspend fun invoke(wordPair: WordPair) {
        repository.writingWordPair(wordPair)
    }
}
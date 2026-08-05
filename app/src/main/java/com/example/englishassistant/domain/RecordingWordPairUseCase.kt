package com.example.englishassistant.domain

internal class RecordingWordPairUseCase(
    val repository: Repository
) {
    suspend operator fun invoke(wordPair: WordPair) {
        repository.writingWordPair(wordPair)
    }
}
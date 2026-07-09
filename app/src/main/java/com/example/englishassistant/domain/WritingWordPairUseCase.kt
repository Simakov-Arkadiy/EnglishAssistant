package com.example.englishassistant.domain

internal class WritingWordPairUseCase(
    val repository: RepositoryInterface
) {
    suspend fun invoke(wordPair: WordPairInterface) {
        repository.writingWordPair(wordPair)
    }
}
package com.example.englishassistant.domain

import javax.inject.Inject

internal class RecordWordPairUseCase @Inject constructor(
    private val repository: WordPairRepository
) {
    suspend operator fun invoke(wordPair: WordPair) {
        repository.recordWordPair(wordPair)
    }
}
package com.example.englishassistant.domain

import javax.inject.Inject

internal class RecordWordPairUseCase @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke(wordPair: WordPair) {
        repository.recordWordPair(wordPair)
    }
}
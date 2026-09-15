package com.example.englishassistant.domain

import javax.inject.Inject

internal class GetTestUseCase @Inject constructor(
    val repository: WordPairRepository
) {
    suspend operator fun invoke(limit:Int): Result<Test> {
        return runCatching {
            val wordPairs = repository.getWordPairsWeighted(limit)
            Test.create(wordPairs.getOrThrow())
        }
    }
}
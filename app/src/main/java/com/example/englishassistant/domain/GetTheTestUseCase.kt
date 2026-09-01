package com.example.englishassistant.domain

import javax.inject.Inject

internal class GetTheTestUseCase @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke(): Result<Test> {
        return runCatching {
            val wordPairs = repository.getWordPairsWeighted()
            Test.create(wordPairs.getOrThrow())
        }
    }
}
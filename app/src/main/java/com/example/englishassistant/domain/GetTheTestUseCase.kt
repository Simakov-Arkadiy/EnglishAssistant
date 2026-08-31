package com.example.englishassistant.domain

import javax.inject.Inject

internal class GetTheTestUseCase @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke(): Result<List<WordPair>> {
        return repository.getWordPairsWeighted()
    }
}
package com.example.englishassistant.domain

import javax.inject.Inject

internal class SearchWordPairUseCase @Inject constructor(
    val repository: Repository
) {
    suspend operator fun invoke(word:String): Result<WordPair> {
        return repository.searchWordPair(word)
    }
}
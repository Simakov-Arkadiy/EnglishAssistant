package com.example.englishassistant.domain

import javax.inject.Inject

internal class SearchWordPairUseCase @Inject constructor(
    private val repository: WordPairRepository
) {
    suspend operator fun invoke(word:String): Result<WordPair> {
        return repository.getWordPairUnweighted(word)
    }
}
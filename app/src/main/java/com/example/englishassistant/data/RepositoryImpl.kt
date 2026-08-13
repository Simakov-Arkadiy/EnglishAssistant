package com.example.englishassistant.data

import com.example.englishassistant.domain.Repository
import com.example.englishassistant.domain.WordPair
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(val database: EnglishAssistantDataBase) : Repository {
    override suspend fun recordWordPair(wordPair: WordPair): Result<Boolean> {
        database.baseDao()
            .insert(EntityWordPair(wordRu = wordPair.wordRu, wordEn = wordPair.wordEn))
        return Result.success(true)
    }
}
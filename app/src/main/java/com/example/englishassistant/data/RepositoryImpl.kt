package com.example.englishassistant.data

import com.example.englishassistant.domain.Repository
import com.example.englishassistant.domain.WordPair

internal class RepositoryImpl(val database: EnglishAssistantDataBase) : Repository {
    override suspend fun writingWordPair(wordPair: WordPair): Result<Boolean> {
        database.baseDao()
            .insert(EntityWordPair(wordRu = wordPair.wordRu, wordEn = wordPair.wordEn))
        return Result.success(true)
    }
}
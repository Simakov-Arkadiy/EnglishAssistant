package com.example.englishassistant.data

import com.example.englishassistant.domain.RepositoryInterface
import com.example.englishassistant.domain.WordPair
import com.example.englishassistant.domain.WordPairInterface

internal class Repository(val database: EnglishAssistantDataBase): RepositoryInterface
 {
    override suspend fun writingWordPair(wordPair: WordPairInterface): Result<Boolean> {
        database.baseDao().insert(wordPair)
        return Result.success(true)
    }
}
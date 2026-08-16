package com.example.englishassistant.data

import com.example.englishassistant.domain.Repository
import com.example.englishassistant.domain.WordPair
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(val database: EnglishAssistantDataBase) :
    Repository {
    override suspend fun recordWordPair(wordPair: WordPair): Result<Boolean> {
        return runCatching {
            database.baseDao()
                .insert(wordPair = EntityWordPair(wordRu = wordPair.wordRu, wordEn = wordPair.wordEn))
            true
        }
    }

    override suspend fun searchWordPair(word: String): Result<WordPair> {
       return runCatching {
           database.baseDao().getWordPairs(word = word)
       }
    }
}
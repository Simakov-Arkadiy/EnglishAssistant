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

    override suspend fun getWordPairUnWeighted(word: String): Result<WordPair> {
       return runCatching {
           database.baseDao().getWordPairUnWeighted(word = word)
       }
    }

    override suspend fun getWordPairsWeighted(): Result<List<WordPair>> {
        return runCatching {
            database.baseDao().getWordPairsWeighted()
        }
    }
}
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
            val wordPairs = database.baseDao().getWordPairsWeighted()
            database.baseDao().updateWeights(listOf(wordPairs[0].id,wordPairs[1].id,wordPairs[2].id,wordPairs[3].id))
            wordPairs
        }
    }
}
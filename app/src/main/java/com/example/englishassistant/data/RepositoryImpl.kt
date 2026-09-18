package com.example.englishassistant.data

import com.example.englishassistant.domain.WordPairRepository
import com.example.englishassistant.domain.WordPair
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(val database: EnglishAssistantDataBase) :
    WordPairRepository {
    override suspend fun recordWordPair(wordPair: WordPair): Result<Boolean> {
        return runCatching {
            database.baseDao()
                .insert(wordPair = EntityWordPair(wordRu = wordPair.wordRu, wordEn = wordPair.wordEn))
            true
        }
    }

    override suspend fun getWordPairUnweighted(word: String): Result<WordPair> {
       return runCatching {
           database.baseDao().getWordPairUnWeighted(word = word)
       }
    }

    override suspend fun getWordPairsWeighted(limit:Int): Result<List<WordPair>> {
        return runCatching {
            val wordPairs = database.baseDao().getWordPairsWeighted(limit)
            database.baseDao().updateWeights(wordPairs.map{it.id})
            wordPairs
        }
    }
}
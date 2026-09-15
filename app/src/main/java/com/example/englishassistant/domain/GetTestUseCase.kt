package com.example.englishassistant.domain

import javax.inject.Inject
import kotlin.random.Random

internal class GetTestUseCase @Inject constructor(
    private val repository: WordPairRepository
) {
    suspend operator fun invoke(limit: Int): Result<Test> {
        return runCatching {
            val wordPairs = repository.getWordPairsWeighted(limit).getOrThrow()
            val answerOptions = wordPairs.map { it.wordRu }
            val random = Random.nextInt(wordPairs.size)
            val correctAnswerOption: String = wordPairs[random].wordRu
            val checkWord: String = wordPairs[random].wordEn
            Test.create(
                answerOptions = answerOptions,
                correctAnswerOption = correctAnswerOption,
                checkWord = checkWord
            )
        }
    }
}
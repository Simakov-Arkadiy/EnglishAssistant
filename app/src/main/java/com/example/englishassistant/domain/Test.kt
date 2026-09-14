package com.example.englishassistant.domain

import kotlin.random.Random

data class Test private constructor(
    val answerOptions: List<String>,
    val correctAnswerOption: String,
    val checkWord: String,
) {
    companion object {
        internal fun create(pairs: List<WordPair>): Test {
            val answerOptions = pairs.map { it.wordRu }
            val random = Random.nextInt(4)
            val correctAnswerOption: String = pairs[random].wordRu
            val checkWord: String = pairs[random].wordEn
            return Test(
                answerOptions = answerOptions.shuffled(),
                correctAnswerOption = correctAnswerOption,
                checkWord = checkWord
            )
        }
    }
}
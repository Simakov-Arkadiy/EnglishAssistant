package com.example.englishassistant.domain

import kotlin.random.Random

data class Test private constructor(
    val answerOptions: List<String>,
    val correctAnswerOption: String,
    val checkWord: String,
) {
    companion object {
        internal fun create(answerOptions: List<String>, correctAnswerOption: String, checkWord: String): Test {
            return Test(
                answerOptions = answerOptions.shuffled(),
                correctAnswerOption = correctAnswerOption,
                checkWord = checkWord
            )
        }
    }
}
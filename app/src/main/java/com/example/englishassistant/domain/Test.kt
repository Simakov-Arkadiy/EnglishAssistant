package com.example.englishassistant.domain

data class Test private constructor(
    val answerOptions: List<String>,
    val correctAnswerOption: String,
    val checkWord: String,
) {
    companion object {
        internal fun create(pairs: List<WordPair>): Test {
            val answerOptions: MutableList<String> = mutableListOf()
            for (pair in pairs) {
                answerOptions.add(pair.wordRu)
            }
            val correctAnswerOption: String = ""
            val checkWord: String = ""
            answerOptions.shuffled()
            return Test(
                answerOptions = answerOptions,
                correctAnswerOption = correctAnswerOption,
                checkWord = checkWord
            )
        }
    }
}
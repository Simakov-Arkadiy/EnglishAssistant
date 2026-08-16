package com.example.englishassistant.presentation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.englishassistant.domain.WordPair

@Composable
internal fun AlertDialogForSearchScreen(callBack:() -> Unit, wordPair: WordPair) {
    AlertDialog(
        onDismissRequest = callBack,
        text = {
            Text(text = "Слово на Русском: ${wordPair.wordRu}. Слово на Английском: ${wordPair.wordEn}.")
        },
        confirmButton = {
            TextButton(
                onClick = callBack
            ) {
                Text("Ok")
            }
        }
    )
}
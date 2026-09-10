package com.example.englishassistant.presentation.testScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
internal fun AlertDialogForTestScreen(callBack: () -> Unit, isRight: Boolean) {
    if (isRight) {
        AlertDialog(
            onDismissRequest = callBack,
            text = {
                Text(
                    text = "Не верно!",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            },
            confirmButton = {
                TextButton(
                    onClick = callBack
                ) {
                    Text("Ok")
                }
            }
        )
    } else {
        AlertDialog(
            onDismissRequest = callBack,
            text = {
                Text(
                    text = "Не верно!",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
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
}
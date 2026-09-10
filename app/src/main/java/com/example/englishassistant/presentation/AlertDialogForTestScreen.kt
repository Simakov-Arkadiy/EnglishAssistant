package com.example.englishassistant.presentation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
internal fun AlertDialogForTestScreen(callBack:() -> Unit, isRight:Boolean) {
    if(isRight){
        AlertDialog(
            onDismissRequest = callBack,
            text = {
                Text(text = "Верно!")
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
    else{
        AlertDialog(
            onDismissRequest = callBack,
            text = {
                Text(text = "Не верно!")
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
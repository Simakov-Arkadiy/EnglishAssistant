package com.example.englishassistant.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenButton(action: () -> Unit, text: String) {
    Button(
        onClick = action,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
    ) {
        Text(text = text)
    }
}
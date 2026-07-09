package com.example.englishassistant.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(128, 57, 57)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeScreenButton(
            { Toast.makeText(context, "Запись начата!", Toast.LENGTH_SHORT).show() },
            "recording"
        )
        HomeScreenButton(
            { Toast.makeText(context, "Поиск начат!", Toast.LENGTH_SHORT).show() },
            "search"
        )
        HomeScreenButton({
            Toast.makeText(context, "Тестирование начато!", Toast.LENGTH_SHORT).show()
        }, "test")
    }
}
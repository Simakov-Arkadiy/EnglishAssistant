package com.example.englishassistant

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(128, 57, 57)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { Toast.makeText(context, "Запись начата!", Toast.LENGTH_SHORT) },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp),
            colors = ButtonColors(
                Color(128, 89, 57),
                Color(0, 0, 0),
                Color(128, 89, 57),
                Color(0, 0, 0)
            )
        ) {
            Text(text = "recording")
        }
        Button(
            onClick = { Toast.makeText(context, "Поиск начат!", Toast.LENGTH_SHORT) },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp),
            colors = ButtonColors(
                Color(128, 89, 57),
                Color(0, 0, 0),
                Color(128, 89, 57),
                Color(0, 0, 0)
            )
        ) {
            Text(text = "search")
        }
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Тестирование начато!",
                    Toast.LENGTH_SHORT
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp),
            colors = ButtonColors(
                Color(128, 89, 57),
                Color(0, 0, 0),
                Color(128, 89, 57),
                Color(0, 0, 0)
            )
        ) {
            Text(text = "test")
        }
    }
}
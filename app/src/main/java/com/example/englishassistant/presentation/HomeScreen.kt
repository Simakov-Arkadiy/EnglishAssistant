package com.example.englishassistant.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(context: Context, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier.padding(20.dp, 100.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeScreenButton(
                    { navController.navigate("recordingScreen") },
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
    }
}
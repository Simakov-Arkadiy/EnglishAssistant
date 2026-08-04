package com.example.englishassistant.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun RecordingScreen() {
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
                var valueForRuTextField by remember {
                    mutableStateOf(TextFieldValue(text = ""))
                }
                TextField(value = valueForRuTextField,
                    onValueChange = { newValue: TextFieldValue -> valueForRuTextField = newValue },
                    label = {Text("Слово на русском")})
                var valueForEnTextField by remember {
                    mutableStateOf(TextFieldValue(text = ""))
                }
                TextField(value = valueForEnTextField ,
                    onValueChange = { newValue: TextFieldValue -> valueForEnTextField  = newValue },
                    label = {Text("Слово на английском")})
                Button(
                    onClick = {} ,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp),
                ) {
                    Text(text = "Записать")
                }
            }
        }
    }
}
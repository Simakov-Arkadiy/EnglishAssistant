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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun RecordScreen(viewModel: RecordScreenViewModel) {
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
                TextField(
                    value = viewModel.valueForRuTextField.value,
                    onValueChange = viewModel::updateValueForRuTextField,
                    label = { Text("Слово на русском") })

                TextField(
                    value = viewModel.valueForEnTextField.value,
                    onValueChange = viewModel::updateValueForEnTextField,
                    label = { Text("Слово на английском") })
                Button(
                    onClick = viewModel::recording,
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
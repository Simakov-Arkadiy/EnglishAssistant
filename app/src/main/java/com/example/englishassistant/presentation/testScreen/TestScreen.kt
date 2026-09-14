package com.example.englishassistant.presentation.testScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun TestScreen(viewModel: TestScreenViewModel) {
    LaunchedEffect(Unit) {
        viewModel.getTest()
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier.padding(20.dp, 100.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Как переводится слово ${viewModel.test.value.checkWord}?")
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.Start
                    ) {
                        for (i in 0..3) {
                            TestRadioButton(
                                viewModel.isSelected[i],
                                viewModel.test.value.answerOptions[i],
                                viewModel::activateRadioButton,
                                i
                            )
                        }
                    }
                    Button(
                        onClick = viewModel::clickButtonCheck,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp),
                    ) {
                        Text(text = "Проверить")
                    }
                    if (viewModel.isDialogVisible.value) {
                        AlertDialogForTestScreen(
                            viewModel::clickButtonOk,
                            viewModel.isResponseCorrect.value
                        )
                    }
                }
            }
        }
    }
}
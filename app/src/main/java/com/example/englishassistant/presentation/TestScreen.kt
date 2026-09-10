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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun TestScreen(viewModel: TestScreenViewModel) {
    viewModel.getTest()
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
                Text("Как переводится слово")
                TestRadioButton(viewModel.isSelected.value[0], viewModel.test.value.answerOptions[0],viewModel::updateValueForRadioButton,0)
                TestRadioButton(viewModel.isSelected.value[1],viewModel.test.value.answerOptions[1],viewModel::updateValueForRadioButton,1)
                TestRadioButton(viewModel.isSelected.value[2],viewModel.test.value.answerOptions[2],viewModel::updateValueForRadioButton,2)
                TestRadioButton(viewModel.isSelected.value[3],viewModel.test.value.answerOptions[3],viewModel::updateValueForRadioButton,3)

                Button(
                    onClick = viewModel::check,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp),
                ) {
                    Text(text = "Проверить")
                }
                if(viewModel.isResponseReceived.value){
                    AlertDialogForTestScreen(viewModel::updateValueResponseReceived,viewModel.isResponseCorrect.value)
                }
            }
        }
    }
}
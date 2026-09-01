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
import androidx.compose.ui.unit.dp

@Composable
internal fun SearchScreen(viewModel: SearchScreenViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val openDialog = remember { mutableStateOf(false) }
        val isSearching = remember { mutableStateOf(false) }
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
                    value = viewModel.valueForTextField.value,
                    onValueChange = viewModel::updateValueForTextField,
                    label = { Text("Искомое слово") })

                Button(
                    onClick = {
                        viewModel.search()
                        isSearching.value = true
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp),
                ) {
                    Text(text = "Найти")
                }
            }
            if (isSearching.value) {
                Loader()
            }
            if (viewModel.valueForAlertDialog.value.wordRu != "") {
                isSearching.value = false
                openDialog.value = true
                AlertDialogForSearchScreen(callBack = {
                    openDialog.value = false
                    viewModel.cleanValueForAlertDialog()
                }, wordPair = viewModel.valueForAlertDialog.value)
            }
        }
    }
}
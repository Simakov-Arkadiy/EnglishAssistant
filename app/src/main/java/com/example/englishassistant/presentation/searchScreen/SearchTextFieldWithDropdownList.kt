package com.example.englishassistant.presentation.searchScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
internal fun SearchTextFieldWithDropdownList(
    viewModel: SearchScreenViewModel,
    callBack: () -> Unit
) {

    var isDropdownVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = viewModel.valueForTextField.value,
            onValueChange = { newText ->
                viewModel.onSymbolChanged(newText)
                isDropdownVisible = newText.text.isNotBlank()
            },
            label = { Text("Искомое слово") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused) {
                        isDropdownVisible = false
                    }
                }
        )

        DropdownMenu(
            expanded = isDropdownVisible,
            onDismissRequest = { isDropdownVisible = false },
            properties = PopupProperties(focusable = false),
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            viewModel.valueForDropDawn.value.forEach { item ->
                DropdownMenuItem(
                    text = {
                        if (viewModel.valueForTextField.value.text.all { it in 'a'..'z' || it in 'A'..'Z' }) {
                            Text(item.wordEn)
                        } else {
                            Text(item.wordRu)
                        }
                    },
                    onClick = {
                        isDropdownVisible = false
                        callBack()
                        viewModel.updateValueForAlertDialog(item)
                    }
                )
            }
        }
    }
}
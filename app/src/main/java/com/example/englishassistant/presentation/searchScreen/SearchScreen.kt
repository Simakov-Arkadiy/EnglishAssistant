package com.example.englishassistant.presentation.searchScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun SearchScreen(viewModel: SearchScreenViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val openDialog = remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(20.dp, 100.dp)
        ) {
            SearchTextFieldWithDropdownList(viewModel, { openDialog.value = true })
            if (openDialog.value) {
                AlertDialogForSearchScreen(callBack = {
                    openDialog.value = false
                    viewModel.onClickButtonOk()
                }, wordPair = viewModel.valueForAlertDialog.value)
            }
        }
    }
}
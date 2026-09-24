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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
internal fun SearchScreen(viewModel: SearchScreenViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var openDialog by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(20.dp, 100.dp)
        ) {
            SearchTextFieldWithDropdownList(viewModel, { openDialog = true })
            if (openDialog) {
                AlertDialogForSearchScreen(callBack = {
                    openDialog = false
                    viewModel.onClickButtonOk()
                }, wordPair = viewModel.valueForAlertDialog.value)
            }
        }
    }
}
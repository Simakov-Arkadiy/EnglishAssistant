package com.example.englishassistant.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

internal class TestScreenViewModel: ViewModel() {
    val isSelectedS = mutableStateOf(mutableListOf(false,false,false,false))
}
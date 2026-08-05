package com.example.englishassistant.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.englishassistant.domain.RecordingWordPairUseCase
import com.example.englishassistant.domain.WordPairImpl
import kotlinx.coroutines.launch

internal class RecordingScreenViewModel(val useCase: RecordingWordPairUseCase) : ViewModel() {
    private val _valueForRuTextField = mutableStateOf(TextFieldValue(text = ""))
    val valueForRuTextField: State<TextFieldValue> = _valueForRuTextField
    private val _valueForEnTextField = mutableStateOf(TextFieldValue(text = ""))
    val valueForEnTextField: State<TextFieldValue> = _valueForEnTextField

    fun updateValueForRuTextField(newValue: TextFieldValue) {
        _valueForRuTextField.value = newValue
    }

    fun updateValueForEnTextField(newValue: TextFieldValue) {
        _valueForEnTextField.value = newValue
    }

    fun recording() {
        viewModelScope.launch {
            useCase(
                WordPairImpl(
                    valueForRuTextField.value.text,
                    valueForEnTextField.value.text
                )
            )
        }
    }
}
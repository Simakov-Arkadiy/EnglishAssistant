package com.example.englishassistant.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.englishassistant.domain.RecordWordPairUseCase
import com.example.englishassistant.domain.WordPairImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class RecordScreenViewModel @Inject constructor(val useCase: RecordWordPairUseCase) :
    ViewModel() {
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

    fun record() {
        viewModelScope.launch {
            useCase.invoke(
                WordPairImpl(
                    wordRu = valueForRuTextField.value.text,
                    wordEn = valueForEnTextField.value.text
                )
            )
        }
        _valueForRuTextField.value = TextFieldValue(text = "")
        _valueForEnTextField.value = TextFieldValue(text = "")
    }
}

internal class RecordScreenViewModelFactory @Inject constructor(
    private val useCase: RecordWordPairUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return RecordScreenViewModel(
            useCase = useCase
        ) as T
    }
}
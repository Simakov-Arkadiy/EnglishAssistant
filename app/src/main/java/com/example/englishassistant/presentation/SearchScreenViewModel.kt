package com.example.englishassistant.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.englishassistant.domain.SearchWordPairUseCase
import com.example.englishassistant.domain.WordPair
import com.example.englishassistant.domain.WordPairImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SearchScreenViewModel @Inject constructor(val useCase: SearchWordPairUseCase) :
    ViewModel() {
    private val _valueForTextField = mutableStateOf(TextFieldValue(text = ""))
    val valueForTextField: State<TextFieldValue> = _valueForTextField

    private val _valueForAlertDialog: MutableState<WordPair> = mutableStateOf(WordPairImpl("", ""))
    val valueForAlertDialog: State<WordPair> = _valueForAlertDialog

    fun updateValueForTextField(newValue: TextFieldValue) {
        _valueForTextField.value = newValue
    }
    fun cleanValueForAlertDialog(){
        _valueForAlertDialog.value = WordPairImpl("", "")
    }

    fun search() {
        viewModelScope.launch {
            val result = useCase.invoke(
                word = valueForTextField.value.text
            )
            synchronized(this){
                result.fold(onSuccess = {_valueForAlertDialog.value = it}, onFailure = {_valueForAlertDialog.value = WordPairImpl("", "")})
            }
        }
        _valueForTextField.value = TextFieldValue(text = "")
    }
}

internal class SearchScreenViewModelFactory @Inject constructor(
    private val useCase: SearchWordPairUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return SearchScreenViewModel(
            useCase = useCase
        ) as T
    }
}

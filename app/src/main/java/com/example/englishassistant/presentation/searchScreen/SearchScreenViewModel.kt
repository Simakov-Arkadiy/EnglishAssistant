package com.example.englishassistant.presentation.searchScreen

import android.util.Log
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
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SearchScreenViewModel @Inject constructor(val useCase: SearchWordPairUseCase) :
    ViewModel() {

    private var job: Job? = null
    private val _valueForTextField = mutableStateOf(TextFieldValue(text = ""))
    val valueForTextField: State<TextFieldValue> = _valueForTextField

    private val _valueForDropDawn = mutableStateOf<List<WordPair>>(emptyList())
    val valueForDropDawn: State<List<WordPair>> = _valueForDropDawn

    private val _valueForAlertDialog: MutableState<WordPair> = mutableStateOf(WordPairImpl("", ""))
    val valueForAlertDialog: State<WordPair> = _valueForAlertDialog

    fun onSymbolChanged(newValue: TextFieldValue) {
        _valueForTextField.value = newValue
        if (job?.isActive == true) return
        job = viewModelScope.launch {
            delay(300)
            val result = useCase.invoke(
                subStr = valueForTextField.value.text
            )
            result.fold(
                onSuccess = {
                    _valueForDropDawn.value = it
                },
                onFailure = {
                    _valueForAlertDialog.value = WordPairImpl("", "")
                })
        }
    }

    fun updateValueForAlertDialog(newValue: WordPair) {
        _valueForAlertDialog.value = newValue
    }

    fun onClickButtonOk() {
        _valueForAlertDialog.value = WordPairImpl("", "")
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

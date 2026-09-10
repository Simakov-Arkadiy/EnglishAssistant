package com.example.englishassistant.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.englishassistant.domain.GetTheTestUseCase
import com.example.englishassistant.domain.RecordWordPairUseCase
import com.example.englishassistant.domain.Test
import com.example.englishassistant.domain.WordPairImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class TestScreenViewModel @Inject constructor(val useCase: GetTheTestUseCase) : ViewModel() {
    private val _isSelected = mutableStateOf(mutableListOf(false, false, false, false))
    val isSelected: State<MutableList<Boolean>> = _isSelected

    private val _test = mutableStateOf(
        Test.create(
            listOf(
                WordPairImpl("", ""),
                WordPairImpl("", ""),
                WordPairImpl("", ""),
                WordPairImpl("", "")
            )
        )
    )

    val test: State<Test> = _test

    private val _isResponseReceived = mutableStateOf(false)

    val isResponseReceived:State<Boolean> = _isResponseReceived

    private val _isResponseCorrect = mutableStateOf(false)

    val isResponseCorrect:State<Boolean> = _isResponseCorrect

    fun updateValueForRadioButton(numberRadioButton: Int) {
        if(_isSelected.value[numberRadioButton]){
            _isSelected.value[numberRadioButton] = false
        }
        _isSelected.value[numberRadioButton] = true
    }

    fun updateValueResponseReceived() {
        _isResponseReceived.value = false
    }

    fun getTest() {
        viewModelScope.launch {
            _test.value = useCase.invoke().getOrThrow()
        }
    }

    fun check(){
        for((index,value) in _isSelected.value.withIndex()){
            _isResponseReceived.value = true
            if(value){
                if(_test.value.answerOptions[index] == _test.value.correctAnswerOption){
                    _isResponseCorrect.value = true
                }
            }
            else{
                if(index == 3){
                    _isResponseCorrect.value = false
                }
                continue
            }
        }
    }
}

internal class TestScreenViewModelFactory @Inject constructor(
    private val useCase: GetTheTestUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return TestScreenViewModel(
            useCase = useCase
        ) as T
    }
}
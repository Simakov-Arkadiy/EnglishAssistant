package com.example.englishassistant.presentation.testScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.englishassistant.domain.GetTheTestUseCase
import com.example.englishassistant.domain.Test
import com.example.englishassistant.domain.WordPairImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class TestScreenViewModel @Inject constructor(val useCase: GetTheTestUseCase) :
    ViewModel() {
    private val _isSelected = mutableStateListOf(false, false, false, false)
    val isSelected: List<Boolean> = _isSelected

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

    private val _isDialogVisible = mutableStateOf(false)

    val isDialogVisible: State<Boolean> = _isDialogVisible

    private val _isResponseCorrect = mutableStateOf(false)

    val isResponseCorrect: State<Boolean> = _isResponseCorrect

    fun activateRadioButton(numberRadioButton: Int) {
        resetAllRadioButton()
        _isSelected[numberRadioButton] = true
    }

    fun clickButtonOk() {
        resetAllRadioButton()
        _isDialogVisible.value = false
        _isResponseCorrect.value = true
        getTest()
    }

    fun getTest() {
        viewModelScope.launch {
            _test.value = useCase.invoke().getOrThrow()
        }
    }

    fun clickButtonCheck() {
        _isDialogVisible.value = true
        for ((index, value) in _isSelected.withIndex()) {
            if (value) {
                if (_test.value.answerOptions[index] == _test.value.correctAnswerOption) {
                    _isResponseCorrect.value = true
                    break
                }
            } else {
                if (index == 3) {
                    _isResponseCorrect.value = false
                }
                continue
            }
        }
    }
    private fun resetAllRadioButton(){
        for (value in _isSelected.indices) {
            _isSelected[value] = false
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
package com.example.englishassistant.presentation.testScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.englishassistant.domain.GetTestUseCase
import com.example.englishassistant.domain.Test
import com.example.englishassistant.domain.WordPairImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class TestScreenViewModel @Inject constructor(val useCase: GetTestUseCase) :
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

    fun onActivateRadioButton(numberRadioButton: Int) {
        resetAllRadioButton()
        _isSelected[numberRadioButton] = true
    }

    fun onClickButtonOk() {
        resetAllRadioButton()
        _isDialogVisible.value = false
        _isResponseCorrect.value = false
        getTest()
    }

    fun getTest() {
        viewModelScope.launch {
            _test.value = useCase.invoke(4).getOrThrow()
        }
    }

    fun onClickButtonCheck() {
        _isDialogVisible.value = true
        _isResponseCorrect.value = _test.value.answerOptions[_isSelected.indexOfFirst { it }] == _test.value.correctAnswerOption
    }

    private fun resetAllRadioButton() {
        _isSelected.fill(false)
    }
}

internal class TestScreenViewModelFactory @Inject constructor(
    private val useCase: GetTestUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return TestScreenViewModel(
            useCase = useCase
        ) as T
    }
}
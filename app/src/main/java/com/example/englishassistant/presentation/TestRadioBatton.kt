package com.example.englishassistant.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun TestRadioButton(isSelected: Boolean, answerOption:String,action:()->Unit){
    Row(){
        RadioButton(
            selected = isSelected,
            onClick =  action,
        )
        Text(
            text =  answerOption,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
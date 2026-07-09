package com.example.englishassistant.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.englishassistant.R

@Composable
fun HomeScreenButton(action:()-> Unit, text: String){
    Button(
        onClick =  action ,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp),
        colors = ButtonColors(
            colorResource(R.color.homeScreenButtonColor),
            Color.Black,
            Color(128, 89, 57),
            Color(0, 0, 0)
        )
    ) {
        Text(text = text)
    }
}
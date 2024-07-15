package com.zabcoding.myheartbeats.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextPlaceholderComponent(
    placeholder: String
) {
    Text(
        text = placeholder,
        fontSize = 14.sp,
        color = Color.DarkGray
    )
}
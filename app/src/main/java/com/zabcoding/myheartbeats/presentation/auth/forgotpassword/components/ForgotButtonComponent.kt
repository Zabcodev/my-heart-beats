package com.zabcoding.myheartbeats.presentation.auth.forgotpassword.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zabcoding.myheartbeats.presentation.components.ButtonComponent

@Composable
fun ForgotButtonComponent(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit
) {
    ButtonComponent(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
        )
    }
}
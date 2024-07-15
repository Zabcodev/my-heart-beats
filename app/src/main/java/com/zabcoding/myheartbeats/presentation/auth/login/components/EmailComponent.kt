package com.zabcoding.myheartbeats.presentation.auth.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zabcoding.myheartbeats.presentation.components.OutlinedTextFieldComponent
import com.zabcoding.myheartbeats.presentation.components.TextLabelComponent

@Composable
fun EmailComponent(
    email: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false
) {
    OutlinedTextFieldComponent(
        value = email,
        onValueChange = onEmailChange,
        modifier = modifier
            .fillMaxWidth(),
        label = {
            TextLabelComponent(label = "Correo electronico")
        },
        placeholder = {
            Text(
                text = "Tu correo electronico",
                fontSize = 14.sp,
                color = Color.DarkGray,
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "ic_email",
                tint = Color.DarkGray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = Color.DarkGray,
            unfocusedLabelColor = Color.DarkGray,
            focusedPlaceholderColor = Color.DarkGray,
            unfocusedPlaceholderColor = Color.DarkGray,
            focusedBorderColor = Color.DarkGray,
            unfocusedBorderColor = Color.DarkGray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        isError = !isError,
        shape = RoundedCornerShape(16.dp)
    )
}
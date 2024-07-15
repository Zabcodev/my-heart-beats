package com.zabcoding.myheartbeats.presentation.auth.signup.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zabcoding.myheartbeats.presentation.components.OutlinedTextFieldComponent
import com.zabcoding.myheartbeats.presentation.components.TextLabelComponent
import com.zabcoding.myheartbeats.presentation.components.TextPlaceholderComponent

@Composable
fun NameComponent(
    name: String,
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false
) {
    OutlinedTextFieldComponent(
        value = name,
        onValueChange = onNameChange,
        modifier = modifier
            .fillMaxWidth(),
        label = {
            TextLabelComponent(label = "Nombre")
        },
        placeholder = {
            TextPlaceholderComponent(placeholder = "Tu nombre completo")
        },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
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
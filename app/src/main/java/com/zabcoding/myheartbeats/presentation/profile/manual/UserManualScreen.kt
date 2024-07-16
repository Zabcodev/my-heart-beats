package com.zabcoding.myheartbeats.presentation.profile.manual

import androidx.compose.runtime.Composable
import com.zabcoding.myheartbeats.presentation.profile.manual.components.WebViewComponent
import com.zabcoding.myheartbeats.utils.Constants.USER_MANUAL_URL

@Composable
fun UserManualScreen() {
    WebViewComponent(baseUrl = USER_MANUAL_URL)
}
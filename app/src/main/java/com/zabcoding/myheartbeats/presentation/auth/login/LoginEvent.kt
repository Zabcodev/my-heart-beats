package com.zabcoding.myheartbeats.presentation.auth.login

sealed class LoginEvent {
    data class EmailChanged(val email: String): LoginEvent()
    data class PasswordChanged(val password: String): LoginEvent()
    data object LoginButtonClicked: LoginEvent()
}
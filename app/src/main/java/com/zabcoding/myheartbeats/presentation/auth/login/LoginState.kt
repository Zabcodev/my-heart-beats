package com.zabcoding.myheartbeats.presentation.auth.login

data class LoginState(
    var email: String = "",
    var password: String = "",
    var emailError: Boolean = false,
    var passwordError: Boolean = false,
    var isLoading: Boolean = false,
    var validationsChecked: Boolean = false,
    var isLoginSuccess: Boolean = false,
    var isLoginError: Boolean = false,
)
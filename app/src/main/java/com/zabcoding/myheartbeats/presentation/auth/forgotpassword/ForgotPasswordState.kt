package com.zabcoding.myheartbeats.presentation.auth.forgotpassword

data class ForgotPasswordState(
    var email: String = "",
    var emailError: Boolean = false,
)

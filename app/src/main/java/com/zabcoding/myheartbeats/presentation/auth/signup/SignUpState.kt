package com.zabcoding.myheartbeats.presentation.auth.signup

data class SignUpState(
    val isLoading: Boolean = false,
    var name: String = "",
    var email: String = "",
    var phoneNumber: String = "",
    var password: String = "",
    var nameError: Boolean = false,
    var emailError: Boolean = false,
    var phoneNumberError: Boolean = false,
    var passwordError: Boolean = false,
    val allValidationsCheck: Boolean = false,
    val isSignUpSuccess: Boolean = false,
    val isSignUpError: Boolean = false,
)

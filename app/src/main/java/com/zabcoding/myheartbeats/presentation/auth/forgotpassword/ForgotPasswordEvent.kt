package com.zabcoding.myheartbeats.presentation.auth.forgotpassword

sealed class ForgotPasswordEvent {

    data class SetEmail(val email: String): ForgotPasswordEvent()

}
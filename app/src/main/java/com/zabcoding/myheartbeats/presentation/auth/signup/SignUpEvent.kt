package com.zabcoding.myheartbeats.presentation.auth.signup

sealed class SignUpEvent {

    data class SetName(val name: String): SignUpEvent()
    data class SetEmail(val email: String): SignUpEvent()
    data class SetPhoneNumber(val phoneNumber: String): SignUpEvent()
    data class SetPassword(val password: String): SignUpEvent()
    data object ButtonClicked: SignUpEvent()

}
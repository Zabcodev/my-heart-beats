package com.zabcoding.myheartbeats.presentation.auth.forgotpassword

import androidx.lifecycle.ViewModel
import com.zabcoding.myheartbeats.data.network.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: FirebaseRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ForgotPasswordState())
    val state: StateFlow<ForgotPasswordState> = _state.asStateFlow()

    fun onEvent(event: ForgotPasswordEvent) {
        when (event) {
            is ForgotPasswordEvent.SetEmail -> {
                _state.update { state ->
                    state.copy(email = event.email)
                }
            }
        }
    }

    fun sendEmail(navigateToLogin: () -> Unit) {
        val response = repository.sendResetPasswordEmail(state.value.email)
        if (response == true) {
            navigateToLogin()
        }
    }

}
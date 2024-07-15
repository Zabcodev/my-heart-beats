package com.zabcoding.myheartbeats.presentation.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zabcoding.myheartbeats.data.network.FirebaseRepository
import com.zabcoding.myheartbeats.data.network.dto.SignUpDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {

    private var _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.asStateFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.SetEmail -> {
                _state.update { state ->
                    state.copy(email = event.email)
                }
            }
            is SignUpEvent.SetName -> {
                _state.update { state ->
                    state.copy(name = event.name)
                }
            }
            is SignUpEvent.SetPassword -> {
                _state.update { state ->
                    state.copy(password = event.password)
                }
            }
            is SignUpEvent.SetPhoneNumber -> {
                _state.update { state ->
                    state.copy(phoneNumber = event.phoneNumber)
                }
            }
            SignUpEvent.ButtonClicked -> {
                signUp()
            }
        }
        validateData()
    }

    private fun signUp() {
        validateData()
        val model = SignUpDto(
            email = state.value.email,
            password = state.value.password
        )
        signUpSuccess(model)
    }

    private fun signUpSuccess(model: SignUpDto) {
        viewModelScope.launch {
            _state.update { state -> state.copy(isLoading = true) }
            val result = withContext(Dispatchers.IO) {
                repository.signUp(model)
            }
            if (result != null) {
                _state.update { state ->
                    state.copy(
                        isSignUpSuccess = true,
                        isLoading = false
                    )
                }
            } else {
                _state.update { state ->
                    state.copy(
                        isSignUpError = true,
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun validateData() {

    }

}
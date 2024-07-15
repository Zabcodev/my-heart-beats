package com.zabcoding.myheartbeats.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zabcoding.myheartbeats.data.network.FirebaseRepository
import com.zabcoding.myheartbeats.data.network.dto.SignInDto
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
class LoginViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {

    private var _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { state ->
                    state.copy(email = event.email)
                }
            }

            is LoginEvent.PasswordChanged -> {
                _state.update { state ->
                    state.copy(password = event.password)
                }
            }

            LoginEvent.LoginButtonClicked -> {

            }
        }
        validationsChecked()
    }


    fun login(navigateToHome: () -> Unit) {
        validationsChecked()
        val login = SignInDto(
            email = state.value.email,
            password = state.value.password
        )
        loginRequest(login, navigateToHome)
    }

    private fun loginRequest(login: SignInDto, navigateToHome: () -> Unit) {
        viewModelScope.launch {
            _state.update { state -> state.copy(isLoading = true) }
            val result = withContext(Dispatchers.IO) {
                repository.signIn(login)
            }
            if (result != null) {
                navigateToHome()
            } else {
                // Error
            }
        }
    }

    private fun validationsChecked() {

    }


}
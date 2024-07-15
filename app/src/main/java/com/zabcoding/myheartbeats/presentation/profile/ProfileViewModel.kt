package com.zabcoding.myheartbeats.presentation.profile

import androidx.lifecycle.ViewModel
import com.zabcoding.myheartbeats.data.network.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: FirebaseRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.asStateFlow()

    fun getCurrentUserEmail() {
        val userResponse = repository.getCurrentUser()
        if (userResponse != null) {
            _state.update { state ->
                state.copy(userEmail = userResponse)
            }
        } else {
            _state.update { state -> state.copy(userEmail = "") }
        }
    }

    fun logout() = repository.logout()
}
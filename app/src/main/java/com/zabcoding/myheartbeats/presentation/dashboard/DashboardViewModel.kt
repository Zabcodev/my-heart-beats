package com.zabcoding.myheartbeats.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zabcoding.myheartbeats.data.network.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {

    init {
        getECGData()
    }

    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state.asStateFlow()

    private fun getECGData() {
        viewModelScope.launch {
            repository.getECGData().collect { ecgData ->
                _state.update { state ->
                    state.copy(data = ecgData)
                }
            }
        }
    }

}
package com.zabcoding.myheartbeats.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.yml.charts.common.extensions.isNotNull
import com.zabcoding.myheartbeats.data.local.RoomService
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
    private val repository: FirebaseRepository,
    private val roomService: RoomService
) : ViewModel() {

    init {
        getECGData()
        getDataForDiagram()
    }

    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state.asStateFlow()

    private fun getECGData() {
        viewModelScope.launch {
            repository.getECGData().collect { ecgData ->
                _state.update { state ->
                    state.copy(data = ecgData)
                }
                roomService.insertData(ecgData.toDatabase())
            }
        }
    }

    fun getDataForDiagram() {
        viewModelScope.launch {
            roomService.getDataForDiagram().collect { ecgData ->
                _state.update { state ->
                    state.copy(dataList = ecgData.map { it.toDomain() })
                }
            }
        }
    }

    fun deleteData() {
        viewModelScope.launch {
            roomService.deleteData()
        }
    }

}
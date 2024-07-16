package com.zabcoding.myheartbeats.presentation.dashboard

import com.zabcoding.myheartbeats.data.network.response.EcgResponse
import com.zabcoding.myheartbeats.presentation.dashboard.model.EcgModel

data class DashboardState(
    val data: EcgResponse? = null,
    val dataList: List<EcgModel> = emptyList()
)

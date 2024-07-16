package com.zabcoding.myheartbeats.presentation.dashboard

import com.zabcoding.myheartbeats.data.network.response.EcgResponse

data class DashboardState(
    val data: EcgResponse? = null
)

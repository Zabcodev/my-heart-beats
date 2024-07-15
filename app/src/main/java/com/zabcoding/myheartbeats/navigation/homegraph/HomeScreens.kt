package com.zabcoding.myheartbeats.navigation.homegraph

import androidx.navigation.NamedNavArgument
import com.zabcoding.myheartbeats.utils.Constants.DASHBOARD
import com.zabcoding.myheartbeats.utils.Constants.PROFILE

sealed class HomeScreens(val route: String, val arguments: List<NamedNavArgument>) {

    data object DashboardScreen: HomeScreens(
        route = DASHBOARD,
        arguments = emptyList()
    )

    data object ProfileScreen: HomeScreens(
        route = PROFILE,
        arguments = emptyList()
    )

}
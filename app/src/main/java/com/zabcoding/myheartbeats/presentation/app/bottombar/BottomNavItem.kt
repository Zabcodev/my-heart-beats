package com.zabcoding.myheartbeats.presentation.app.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.ui.graphics.vector.ImageVector
import com.zabcoding.myheartbeats.navigation.homegraph.HomeScreens

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {

    data object DashboardNavItem: BottomNavItem(
        title = "Inicio",
        icon = Icons.Filled.Dashboard,
        route = HomeScreens.DashboardScreen.route
    )

    data object ProfileNavItem: BottomNavItem(
        title = "Perfil",
        icon = Icons.Filled.AccountCircle,
        route = HomeScreens.ProfileScreen.route
    )

}
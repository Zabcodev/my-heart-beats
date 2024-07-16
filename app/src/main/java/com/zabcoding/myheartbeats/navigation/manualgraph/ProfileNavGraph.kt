package com.zabcoding.myheartbeats.navigation.manualgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.zabcoding.myheartbeats.presentation.profile.manual.UserManualScreen

fun NavGraphBuilder.addManualScreen(navController: NavHostController) {
    composable(
        route = ProfileScreens.ManualScreen.route
    ) {
        UserManualScreen()
    }
}
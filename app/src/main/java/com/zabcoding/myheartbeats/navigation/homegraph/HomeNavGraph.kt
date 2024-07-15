package com.zabcoding.myheartbeats.navigation.homegraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zabcoding.myheartbeats.navigation.Graph
import com.zabcoding.myheartbeats.navigation.Graph.HOME
import com.zabcoding.myheartbeats.navigation.authgraph.AuthScreens
import com.zabcoding.myheartbeats.presentation.profile.ProfileScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = HOME,
        startDestination = HomeScreens.DashboardScreen.route
    ) {
        addDashboard(navController)
        addProfile(navController)
    }
}

fun NavGraphBuilder.addDashboard(navController: NavHostController) {
    composable(
        route = HomeScreens.DashboardScreen.route
    ) {

    }
}

fun NavGraphBuilder.addProfile(navController: NavHostController) {
    composable(
        route = HomeScreens.ProfileScreen.route
    ) {
        ProfileScreen(
            navigateToForgotPassword = { navController.navigate(AuthScreens.ForgotPasswordScreen.route) },
            navigateToHelp = { /*TODO*/ },
            navigateToLogin = { navController.navigate(Graph.AUTH) }
        )
    }
}
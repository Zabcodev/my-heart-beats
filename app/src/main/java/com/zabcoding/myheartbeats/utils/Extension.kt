package com.zabcoding.myheartbeats.utils

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.zabcoding.myheartbeats.navigation.Graph
import com.zabcoding.myheartbeats.navigation.authgraph.AuthScreens
import com.zabcoding.myheartbeats.navigation.homegraph.HomeScreens

fun NavHostController.navigateToSingleTopTo(route: String) =
    this.navigate(route) {
        when (route) {
            Graph.ROOT -> {
                popUpTo(Graph.ROOT) {
                    inclusive = true
                }
            }

            HomeScreens.DashboardScreen.route -> {
                popUpTo(Graph.HOME) {
                    inclusive = true
                }
            }

            AuthScreens.LoginScreen.route -> {
                popUpTo(Graph.HOME) {
                    inclusive = true
                }
            }

            else -> {
                popUpTo(this@navigateToSingleTopTo.graph.findStartDestination().id) {
                    inclusive = (route == Graph.HOME) ||
                            (route == Graph.AUTH)
                }
            }
        }
        launchSingleTop = true
        restoreState = true
    }
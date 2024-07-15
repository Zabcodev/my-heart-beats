package com.zabcoding.myheartbeats.navigation.rootgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zabcoding.myheartbeats.navigation.Graph.ROOT
import com.zabcoding.myheartbeats.navigation.Graph.AUTH
import com.zabcoding.myheartbeats.navigation.authgraph.authNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        route = ROOT,
        navController = navController,
        startDestination = AUTH
    ) {
        authNavGraph(navController)
    }
}
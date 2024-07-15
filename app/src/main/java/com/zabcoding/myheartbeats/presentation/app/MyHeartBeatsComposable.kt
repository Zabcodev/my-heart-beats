package com.zabcoding.myheartbeats.presentation.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.zabcoding.myheartbeats.navigation.rootgraph.RootNavGraph
import com.zabcoding.myheartbeats.presentation.components.BottomBarComponent

@Composable
fun MyHeartBeatsComposable() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBarComponent(navController = navController)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Surface {
                RootNavGraph(navController = navController)
            }
        }
    }

}
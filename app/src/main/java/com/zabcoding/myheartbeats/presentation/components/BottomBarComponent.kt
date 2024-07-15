package com.zabcoding.myheartbeats.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zabcoding.myheartbeats.navigation.authgraph.AuthScreens
import com.zabcoding.myheartbeats.navigation.homegraph.HomeScreens
import com.zabcoding.myheartbeats.utils.Constants
import com.zabcoding.myheartbeats.utils.Constants.navItemList

@Composable
fun BottomBarComponent(
    navController: NavHostController
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    var bottomNavVisibility by remember { mutableStateOf(false) }

    if (bottomNavVisibility) {
        NavigationBar {
            navItemList.forEach { screen ->
                val selected = currentRoute == screen.route
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(route = screen.route) {
                            popUpTo(HomeScreens.DashboardScreen.route) {
                                inclusive = screen.route == HomeScreens.DashboardScreen.route
                            }
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.title
                        )
                    },
                    label = {
                        Text(text = screen.title)
                    }
                )
            }
        }
    }

    when (currentRoute) {
        AuthScreens.LoginScreen.route -> {
            bottomNavVisibility = false
        }
        AuthScreens.SignUpScreen.route -> {
            bottomNavVisibility = false
        }
        AuthScreens.ForgotPasswordScreen.route -> {
            bottomNavVisibility = false
        }
        HomeScreens.DashboardScreen.route -> {
            bottomNavVisibility = true
        }
        HomeScreens.ProfileScreen.route -> {
            bottomNavVisibility = true
        }
    }
}

package com.zabcoding.myheartbeats.navigation.authgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zabcoding.myheartbeats.navigation.Graph
import com.zabcoding.myheartbeats.navigation.Graph.AUTH
import com.zabcoding.myheartbeats.presentation.auth.forgotpassword.ForgotPasswordScreen
import com.zabcoding.myheartbeats.presentation.auth.login.LoginScreen
import com.zabcoding.myheartbeats.presentation.auth.signup.SignUpScreen
import com.zabcoding.myheartbeats.utils.navigateToSingleTopTo

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = AUTH,
        startDestination = AuthScreens.LoginScreen.route
    ) {
        addLogin(navController)
        addSignUp(navController)
        addForgotPassword(navController)
    }
}

fun NavGraphBuilder.addLogin(navController: NavHostController) {
    composable(
        route = AuthScreens.LoginScreen.route
    ) {
        LoginScreen(
            navigateToHome = { navController.navigateToSingleTopTo(Graph.HOME) },
            navigateToForgotPassword = { navController.navigateToSingleTopTo(AuthScreens.ForgotPasswordScreen.route) },
            navigateToRegister = { navController.navigateToSingleTopTo(AuthScreens.SignUpScreen.route) }
        )
    }
}

fun NavGraphBuilder.addSignUp(navController: NavHostController) {
    composable(
        route = AuthScreens.SignUpScreen.route
    ) {
        SignUpScreen(
            popBackStack = {
                navController.popBackStack()
            },
            navigateToHome = {
                navController.navigateToSingleTopTo(Graph.HOME)
            }
        )
    }
}

fun NavGraphBuilder.addForgotPassword(navController: NavHostController) {
    composable(
        route = AuthScreens.ForgotPasswordScreen.route
    ) {
        ForgotPasswordScreen(
            popBackStack = {
                navController.popBackStack()
            }
        )
    }
}
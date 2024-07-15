package com.zabcoding.myheartbeats.navigation.authgraph

import androidx.navigation.NamedNavArgument
import com.zabcoding.myheartbeats.utils.Constants.LOGIN
import com.zabcoding.myheartbeats.utils.Constants.SIGNUP
import com.zabcoding.myheartbeats.utils.Constants.FORGOT_PASSWORD

sealed class AuthScreens(val route: String, val arguments: List<NamedNavArgument>) {

    data object LoginScreen: AuthScreens(
        route = LOGIN,
        arguments = emptyList()
    )

    data object SignUpScreen: AuthScreens(
        route = SIGNUP,
        arguments = emptyList()
    )

    data object ForgotPasswordScreen: AuthScreens(
        route = FORGOT_PASSWORD,
        arguments = emptyList()
    )

}
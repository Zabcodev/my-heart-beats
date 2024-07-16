package com.zabcoding.myheartbeats.navigation.manualgraph

import androidx.navigation.NamedNavArgument
import com.zabcoding.myheartbeats.utils.Constants
import com.zabcoding.myheartbeats.utils.Constants.USER_MANUAL

sealed class ProfileScreens(val route: String, val arguments: List<NamedNavArgument>) {

    data object ManualScreen: ProfileScreens(
        route = USER_MANUAL,
        arguments = emptyList()
    )

}
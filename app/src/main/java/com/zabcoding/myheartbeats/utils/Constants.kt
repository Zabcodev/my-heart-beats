package com.zabcoding.myheartbeats.utils

import com.zabcoding.myheartbeats.presentation.app.bottombar.BottomNavItem

object Constants {

    const val LOGIN = "login_screen"
    const val SIGNUP = "sign_up_screen"
    const val FORGOT_PASSWORD = "forgot_password_screen"
    const val DASHBOARD = "dashboard_screen"
    const val PROFILE = "profile_screen"

    val navItemList = listOf(
        BottomNavItem.DashboardNavItem,
        BottomNavItem.ProfileNavItem
    )

}
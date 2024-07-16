package com.zabcoding.myheartbeats.utils

import com.zabcoding.myheartbeats.presentation.app.bottombar.BottomNavItem

object Constants {

    const val LOGIN = "login_screen"
    const val SIGNUP = "sign_up_screen"
    const val FORGOT_PASSWORD = "forgot_password_screen"
    const val DASHBOARD = "dashboard_screen"
    const val PROFILE = "profile_screen"
    const val USER_MANUAL = "user_manual_screen"
    const val USER_MANUAL_URL = "https://firebasestorage.googleapis.com/v0/b/ecg-backend-5c307.appspot.com/o/Manual%20de%20uso.pdf?alt=media&token=aa033f9b-9a55-4d91-ab8c-a6d51a6b1962"

    val navItemList = listOf(
        BottomNavItem.DashboardNavItem,
        BottomNavItem.ProfileNavItem
    )

}
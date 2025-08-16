package com.cmt.pasajeroapp.core.routes

sealed class Routes(val route: String) {
    object HomeScreen : Routes("homeScreen")
    object LoginScreen : Routes("loginScreen")
    object SettingScreen : Routes("settingScreen")
    object InfoScreen : Routes("infoScreen")
    object MapScreen : Routes("mapScreen")
    object ForumScreen : Routes("forumScreen")
    object ProfileScreen : Routes("ProfileScreen")
}
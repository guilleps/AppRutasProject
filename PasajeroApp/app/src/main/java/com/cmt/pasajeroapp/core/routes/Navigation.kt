package com.cmt.pasajeroapp.core.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmt.pasajeroapp.screen.ForumScreen
import com.cmt.pasajeroapp.screen.HomeScreen
import com.cmt.pasajeroapp.screen.InfoScreen
import com.cmt.pasajeroapp.screen.LoginScreen
import com.cmt.pasajeroapp.screen.MapScreen
import com.cmt.pasajeroapp.screen.ProfileScreen
import com.cmt.pasajeroapp.screen.SettingScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Routes.HomeScreen.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        addHomeRoute(modifier, navController)
        addLoginRoute(modifier, navController)
        addForumRoute(modifier, navController)
        addInfoRoute(modifier, navController)
        addMapRoute(modifier, navController)
        addProfileRoute(modifier, navController)
        addSettingRoute(modifier, navController)
    }
}

fun NavGraphBuilder.addHomeRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.HomeScreen.route) {
        HomeScreen(modifier = modifier, navHostController = navController)
    }
}

fun NavGraphBuilder.addLoginRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.LoginScreen.route) {
        LoginScreen(modifier = modifier, navHostController = navController)
    }
}

fun NavGraphBuilder.addForumRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.ForumScreen.route) {
        ForumScreen(modifier = modifier, navHostController = navController)
    }
}

fun NavGraphBuilder.addInfoRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.InfoScreen.route) {
        InfoScreen(modifier = modifier, navHostController = navController)
    }
}

fun NavGraphBuilder.addMapRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.MapScreen.route) {
        MapScreen(modifier = modifier, navHostController = navController)
    }
}

fun NavGraphBuilder.addSettingRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.SettingScreen.route) {
        SettingScreen(modifier = modifier, navHostController = navController)
    }
}

fun NavGraphBuilder.addProfileRoute(modifier: Modifier, navController: NavHostController) {
    composable(Routes.ProfileScreen.route) {
        ProfileScreen(modifier = modifier, navHostController = navController)
    }
}
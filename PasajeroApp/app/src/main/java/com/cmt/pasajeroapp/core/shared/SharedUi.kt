package com.cmt.pasajeroapp.core.shared

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.ModeComment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.core.data.bottomnavitem.BottomNavItem
import com.cmt.pasajeroapp.core.routes.Routes
import com.cmt.pasajeroapp.ui.theme.CustomTypography
import com.cmt.pasajeroapp.ui.theme.buttonColor
import com.cmt.pasajeroapp.ui.theme.onPrimaryColor
import com.cmt.pasajeroapp.ui.theme.textColorBlack
import com.cmt.pasajeroapp.ui.theme.textColorWhite

@Composable
fun ButtonCustomizable(text: String, modifier: Modifier = Modifier, navigate: () -> Unit) {
    Button(
        onClick = { navigate() },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            disabledContainerColor = buttonColor
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = modifier,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp)
    ) {
        Text(
            text = text,
            style = CustomTypography.bodyLarge,
            color = textColorWhite
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(Routes.SettingScreen.route, Icons.Default.Settings),
        BottomNavItem(Routes.InfoScreen.route, Icons.Default.Info),
        BottomNavItem(Routes.MapScreen.route, Icons.Default.Map),
        BottomNavItem(Routes.ForumScreen.route, Icons.Default.Forum),
        BottomNavItem(Routes.ProfileScreen.route, Icons.Default.Person),
    )

    NavigationBar(containerColor = onPrimaryColor, tonalElevation = 6.dp) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = null
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = textColorBlack,
                    unselectedIconColor = textColorWhite,
                    indicatorColor = Color.Transparent,
                    disabledIconColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun FAB(modifier: Modifier = Modifier) {
    var showOptions by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                showOptions = !showOptions
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .height(50.dp),
            containerColor = buttonColor
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "new_comment",
                    tint = textColorWhite
                )
                Text(
                    text = stringResource(id = R.string.comment_placeholder),
                    style = CustomTypography.bodyMedium,
                    color = textColorWhite
                )
            }
        }
    }
}
package com.cmt.pasajeroapp.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.core.routes.Routes
import com.cmt.pasajeroapp.core.shared.BottomNavigationBar
import com.cmt.pasajeroapp.ui.theme.CustomTypography
import com.cmt.pasajeroapp.ui.theme.buttonColor
import com.cmt.pasajeroapp.ui.theme.onPrimaryColor
import com.cmt.pasajeroapp.ui.theme.textColorBlack

@Composable
fun SettingScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navHostController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "",
                        tint = textColorBlack,
                        modifier = Modifier.size(70.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.configuration_title),
                        style = CustomTypography.displayLarge,
                        color = textColorBlack
                    )
                }

                GroupOneOptions(modifier = Modifier.fillMaxWidth(.8f))

                GroupTwoOptions(
                    modifier = Modifier.fillMaxWidth(.8f)
                ) { navHostController.navigate(Routes.LoginScreen.route) }
            }
        }
    }
}

@Composable
fun GroupTwoOptions(modifier: Modifier, navigate: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray.copy(alpha = .4f))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OptionItemTwo(
            {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "logout",
                    tint = textColorBlack
                )
            },
            text = stringResource(
                id = R.string.logout
            ),
            navigate
        )
    }
}

@Composable
fun GroupOneOptions(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray.copy(alpha = .4f))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var isDarkModeEnabled by remember { mutableStateOf(false) }
        var areNotificationsEnabled by remember { mutableStateOf(false) }

        OptionItemOne(
            {
                Icon(
                    imageVector = Icons.Default.DarkMode,
                    contentDescription = "dark_mode",
                    tint = textColorBlack
                )
            },
            text = stringResource(
                id = R.string.dark_mode
            ),
            false,
            trailing = {
                Switch(
                    checked = isDarkModeEnabled,
                    onCheckedChange = { isDarkModeEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedBorderColor = Color.Transparent,
                        uncheckedBorderColor = Color.Transparent,
                        checkedIconColor = onPrimaryColor,
                        uncheckedIconColor = onPrimaryColor,
                        checkedTrackColor = onPrimaryColor,
                        uncheckedTrackColor = buttonColor,
                        checkedThumbColor = Color.Black,
                        uncheckedThumbColor = Color.Black,
                    )
                )
            }
        )

        // notification
        OptionItemOne(
            {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "notification", tint = textColorBlack
                )
            },
            text = stringResource(
                id = R.string.notifications
            ),
            false,
            trailing = {
                Switch(
                    checked = areNotificationsEnabled,
                    onCheckedChange = { areNotificationsEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedBorderColor = Color.Transparent,
                        uncheckedBorderColor = Color.Transparent,
                        checkedIconColor = onPrimaryColor,
                        uncheckedIconColor = onPrimaryColor,
                        checkedTrackColor = onPrimaryColor,
                        uncheckedTrackColor = buttonColor,
                        checkedThumbColor = Color.Black,
                        uncheckedThumbColor = Color.Black,
                    )
                )
            }
        )

        // idioma
        OptionItemOne(
            {
                Icon(
                    imageVector = Icons.Default.Translate,
                    contentDescription = "language",
                    tint = textColorBlack
                )
            },
            section = true,
            text = stringResource(
                id = R.string.languaje
            )
        )

        // support
        OptionItemOne(
            {
                Icon(
                    imageVector = Icons.Default.SupportAgent,
                    contentDescription = "support",
                    tint = textColorBlack
                )
            },
            section = true,
            text = stringResource(
                id = R.string.support
            )
        )
    }
}

@Composable
fun OptionItemOne(
    icon: @Composable () -> Unit,
    text: String,
    section: Boolean,
    trailing: @Composable (() -> Unit)? = null,
) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(buttonColor),
                    contentAlignment = Alignment.Center
                ) {
                    icon()
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = text, style = CustomTypography.bodyMedium, color = textColorBlack)
            }
        }
        if (section) Icon(
            Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = textColorBlack
        )
        trailing?.invoke()
    }
}

@Composable
fun OptionItemTwo(icon: @Composable () -> Unit, text: String, navigate: () -> Unit) {
    val context = LocalContext.current
    val logoutMessage = stringResource(id = R.string.logout_message)

    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                Toast.makeText(context,logoutMessage, Toast.LENGTH_SHORT).show()
                navigate()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(buttonColor),
            contentAlignment = Alignment.Center
        ) {
            icon()
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = CustomTypography.bodyMedium, color = textColorBlack)
    }
}


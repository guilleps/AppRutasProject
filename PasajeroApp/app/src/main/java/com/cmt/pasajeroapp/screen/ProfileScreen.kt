package com.cmt.pasajeroapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material.icons.filled.Face5
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.core.shared.BottomNavigationBar
import com.cmt.pasajeroapp.core.shared.ButtonCustomizable
import com.cmt.pasajeroapp.ui.theme.CustomTypography
import com.cmt.pasajeroapp.ui.theme.buttonColor
import com.cmt.pasajeroapp.ui.theme.onPrimaryColor
import com.cmt.pasajeroapp.ui.theme.textColorBlack

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
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
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.title_profile),
                    style = CustomTypography.labelMedium,
                    color = textColorBlack
                )

                Spacer(modifier = Modifier.height(30.dp))

                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "avatar"
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.username),
                    style = CustomTypography.displayMedium,
                    color = textColorBlack
                )

                Text(
                    text = stringResource(id = R.string.email_use),
                    style = CustomTypography.bodySmall,
                    color = textColorBlack
                )

                Spacer(modifier = Modifier.height(20.dp))

                ButtonCustomizable(text = stringResource(id = R.string.edit_profile)) {}

                Spacer(modifier = Modifier.height(30.dp))

                ProfileOptions(modifier = Modifier.fillMaxWidth(.8f))
            }
        }
    }
}

@Composable
fun ProfileOptions(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray.copy(alpha = .4f))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Option(
            {
                Icon(
                    imageVector = Icons.Default.Face5,
                    contentDescription = "username",
                    tint = textColorBlack
                )
            },
            text = stringResource(
                id = R.string.username
            ),
            false,
            trailing = {}
        )

        // notification
        Option(
            {
                Icon(
                    imageVector = Icons.Default.ContactPhone,
                    contentDescription = "phone_number", tint = textColorBlack
                )
            },
            text = stringResource(
                id = R.string.phone_number
            ),
            false,
            trailing = {}
        )

        // idioma
        Option(
            {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = "email",
                    tint = textColorBlack
                )
            },
            section = false,
            text = stringResource(
                id = R.string.email_use
            )
        )

        // support
        Option(
            {
                Icon(
                    imageVector = Icons.Default.Password,
                    contentDescription = "password",
                    tint = textColorBlack
                )
            },
            section = false,
            text = stringResource(
                id = R.string.placeholder_password
            )
        )
    }
}

@Composable
fun Option(
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
                        .background(onPrimaryColor),
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
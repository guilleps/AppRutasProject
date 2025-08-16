package com.cmt.pasajeroapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.core.routes.Routes
import com.cmt.pasajeroapp.core.shared.ButtonCustomizable

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
    ) {
        val (logo, button) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(290.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(button.top)
                }
        )

        ButtonCustomizable(
            text = stringResource(id = R.string.button_init),
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
                .constrainAs(button) {
                    top.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            navHostController.navigate(Routes.LoginScreen.route)
        }
    }
}

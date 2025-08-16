package com.cmt.pasajeroapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.core.routes.Routes
import com.cmt.pasajeroapp.core.shared.ButtonCustomizable
import com.cmt.pasajeroapp.ui.theme.CustomTypography
import com.cmt.pasajeroapp.ui.theme.onPrimaryColor
import com.cmt.pasajeroapp.ui.theme.textColorBlack
import com.cmt.pasajeroapp.ui.theme.unfocusedTextColorWhite
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = .4f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.login_text),
                textAlign = TextAlign.Center,
                style = CustomTypography.titleLarge,
                color = onPrimaryColor,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = stringResource(id = R.string.advice_login),
                textAlign = TextAlign.Center,
                style = CustomTypography.bodySmall,
                color = textColorBlack,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            LoginFields(
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it }
            )

            Spacer(modifier = Modifier.height(50.dp))

            // me lleva al bottom bar
            ButtonCustomizable(
                text = stringResource(id = R.string.login_text_button), modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) { navHostController.navigate(Routes.MapScreen.route) }

            Spacer(modifier = Modifier.height(15.dp))

            HorizontalDivider(modifier = Modifier.padding(20.dp), thickness = 1.dp)

            Spacer(modifier = Modifier.height(15.dp))

            ButtonCustomizable(
                text = stringResource(id = R.string.signup_text_button), modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
            ) {}
        }
    }
}

@Composable
fun LoginFields(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EmailField(email, onEmailChange)
        PasswordField(password, onPasswordChange)
    }
}

@Composable
fun EmailField(value: String, onEmailChange: (String) -> Unit) {
    TextField(
        value = value, onValueChange = onEmailChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.placeholder_email),
                style = CustomTypography.bodyMedium
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = textFieldColors(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "",
                tint = unfocusedTextColorWhite
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordField(value: String, onPasswordChange: (String) -> Unit) {
    var passwordVisible by remember { mutableStateOf(false) }
    var lastInputVisible by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    TextField(
        value = value, onValueChange = {
            onPasswordChange(it)
            if (it.isNotEmpty()) {
                lastInputVisible = true
                coroutineScope.launch {
                    delay(1000) // Mostrar la última letra durante 1.5 segundos
                    lastInputVisible = false
                }
            }
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.placeholder_password),
                style = CustomTypography.bodyMedium
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = textFieldColors(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = null,
                    tint = unfocusedTextColorWhite
                )
            }
        },
        visualTransformation = when {
            passwordVisible -> VisualTransformation.None
            lastInputVisible -> LastCharacterTransformation(value)
            else -> PasswordVisualTransformation('*')
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LastCharacterTransformation(password: String): VisualTransformation {
    return VisualTransformation { text ->
        val transformedText = text.text.mapIndexed { index, char ->
            if (index == text.text.length - 1) char.toString() else "*"
        }.joinToString("")

        TransformedText(
            text = AnnotatedString(transformedText),
            offsetMapping = OffsetMapping.Identity
        )
    }
}

@Composable
fun textFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    focusedTextColor = textColorBlack,
    unfocusedTextColor = unfocusedTextColorWhite,
    focusedPlaceholderColor = textColorBlack,
    unfocusedPlaceholderColor = unfocusedTextColorWhite,
    focusedIndicatorColor = onPrimaryColor,
    unfocusedIndicatorColor = onPrimaryColor,
)
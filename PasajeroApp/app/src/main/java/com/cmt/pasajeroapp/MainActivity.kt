package com.cmt.pasajeroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.cmt.pasajeroapp.core.routes.AppNavGraph
import com.cmt.pasajeroapp.core.routes.Routes
import com.cmt.pasajeroapp.ui.theme.PasajeroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasajeroAppTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    AppNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Routes.InfoScreen.route // alterar cada que pruebo una screen
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasajeroPreview() {
    PasajeroAppTheme {
    }
}
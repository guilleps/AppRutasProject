package com.cmt.pasajeroapp.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.core.shared.BottomNavigationBar
import com.cmt.pasajeroapp.ui.theme.CustomTypography
import com.cmt.pasajeroapp.ui.theme.textColorBlack

@Composable
fun InfoScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var expandedCardId by remember { mutableStateOf<String?>(null) }

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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ExpandableCardGroup(
                    id = "horario",
                    isExpanded = expandedCardId == "horario",
                    onExpand = {
                        expandedCardId = if (expandedCardId == "horario") null else "horario"
                    },
                    {
                        Image(
                            painter = painterResource(id = R.drawable.horario),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }, stringResource(id = R.string.horario),
                    expandedContent = {
                        ContentHorario(Modifier.fillMaxWidth())
                    }
                )
                ExpandableCardGroup(
                    id = "routes",
                    isExpanded = expandedCardId == "routes",
                    onExpand = {
                        expandedCardId = if (expandedCardId == "routes") null else "routes"
                    },
                    {
                        Image(
                            painter = painterResource(id = R.drawable.routes),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }, stringResource(id = R.string.route),
                    expandedContent = {
                        ContentRates(Modifier.fillMaxWidth())
                    }
                )
                ExpandableCardGroup(
                    id = "rates",
                    isExpanded = expandedCardId == "rates",
                    onExpand = {
                        expandedCardId = if (expandedCardId == "rates") null else "rates"
                    },
                    {
                        Image(
                            painter = painterResource(id = R.drawable.rates),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }, stringResource(id = R.string.rates),
                    expandedContent = {
                        ContentRates(Modifier.fillMaxWidth())
                    }
                )
            }
        }
    }
}

@Composable
fun ExpandableCardGroup(
    id: String,
    isExpanded: Boolean,
    onExpand: () -> Unit,
    image: @Composable () -> Unit,
    title: String,
    expandedContent: @Composable () -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        onClick = { onExpand() },
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = textColorBlack
        ),
        modifier = Modifier.clickable { showDialog = true }
    ) {
        Column(Modifier.fillMaxWidth()) {
            // Imagen superior
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(20 / 9f)
                    .animateContentSize()
            ) {
                image()
            }

            // Título
            Text(
                text = title,
                style = CustomTypography.labelMedium,
                modifier = Modifier.padding(16.dp)
            )

            // Contenido expandible con animación de visibilidad
            AnimatedVisibility(visible = isExpanded) {
                expandedContent()
            }
        }
    }
}
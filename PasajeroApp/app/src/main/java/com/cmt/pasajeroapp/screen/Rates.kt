package com.cmt.pasajeroapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cmt.pasajeroapp.R
import com.cmt.pasajeroapp.ui.theme.CustomTypography
import com.cmt.pasajeroapp.ui.theme.textColorBlack


@Composable
fun ContentRates(modifier: Modifier = Modifier) {
    val scheduleData = listOf(
        stringResource(id = R.string.directo) to "3.00",
        stringResource(id = R.string.urbano) to "2.00",
        stringResource(id = R.string.universitario) to "2.00",
        stringResource(id = R.string.escolar) to "0.50",
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        scheduleData.forEach { (name, price) ->
            Rate(name, price)
        }
    }
}

@Composable
fun Rate(name: String, price: String) {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = name, style = CustomTypography.labelMedium)
                Text(text = "S/$price", style = CustomTypography.bodyMedium)
            }
            HorizontalDivider()
        }
    }
}
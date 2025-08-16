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
fun ContentHorario(modifier: Modifier = Modifier) {
    val scheduleData = listOf(
        stringResource(id = R.string.letter_A) to ("5:00" to "9:54"),
        stringResource(id = R.string.letter_C) to ("5:00" to "9:54"),
        stringResource(id = R.string.letter_LV) to ("5:00" to "9:54"),
        stringResource(id = R.string.letter_V) to ("5:00" to "9:54"),
        stringResource(id = R.string.letter_BC) to ("5:00" to "9:54")
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        scheduleData.forEach { (letter, times) ->
            Micro(letter, times.first, times.second)
        }
    }
}

@Composable
fun Micro(letter: String, timeInit: String, timeFinal: String) {
    Row(
        Modifier.fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(40.dp), contentAlignment = Alignment.Center) {
            Text(
                text = letter,
                style = CustomTypography.labelLarge,
                color = textColorBlack
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Salida Primer Bus: $timeInit AM", style = CustomTypography.bodySmall)
                Text(text = "Salida Último Bus: $timeFinal  PM", style = CustomTypography.bodySmall)
            }
            HorizontalDivider()
            Text(text = "Frecuencia: 10 minutos", style = CustomTypography.bodySmall)
        }
    }
}
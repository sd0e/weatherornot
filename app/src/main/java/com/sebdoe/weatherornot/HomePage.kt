package com.sebdoe.weatherornot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebdoe.weatherornot.ui.theme.Primary
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun HomePage(dataManager: DataManager) {
    Column(
        Modifier.verticalScroll(rememberScrollState()).padding(24.dp)
    ) {
        Text(text = dataManager.location.uppercase(), modifier = Modifier.alpha(0.8f).padding(bottom = 8.dp), letterSpacing = 4.sp, fontWeight = FontWeight.Bold)
        Text(text = dataManager.findLocationObject(dataManager.location).region.uppercase(), modifier = Modifier.alpha(0.4f).padding(bottom = 16.dp), letterSpacing = 4.sp, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text(text = "${dataManager.weather?.current_weather?.temperature}${dataManager.weather?.hourly_units?.temperature_2m}", color = Primary, fontSize = 32.sp, fontWeight = FontWeight.Bold)
    }
}
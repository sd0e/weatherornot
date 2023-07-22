package com.sebdoe.weatherornot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebdoe.weatherornot.ui.theme.Primary
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun HomePage(dataManager: DataManager) {
    var readableDate = dataManager.weather?.current_weather?.time;
    if (readableDate !== null) {
        readableDate = LocalDateTime.parse(readableDate).format(DateTimeFormatter.ofPattern("HH:mm:ss"))
    }

    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Text(text = "Last updated at $readableDate", modifier= Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp), color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        Column(
            Modifier
                .padding(24.dp)
        ) {
            Text(text = dataManager.location.uppercase(), modifier = Modifier
                .alpha(0.8f)
                .padding(bottom = 8.dp), letterSpacing = 4.sp, fontWeight = FontWeight.Bold)
            Text(text = dataManager.findLocationObject(dataManager.location).region.uppercase(), modifier = Modifier
                .alpha(0.4f)
                .padding(bottom = 16.dp), letterSpacing = 4.sp, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Text(text = "${dataManager.weather?.current_weather?.temperature}${dataManager.weather?.hourly_units?.temperature_2m}", color = Primary, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
    }
}
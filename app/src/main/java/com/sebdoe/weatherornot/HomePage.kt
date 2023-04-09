package com.sebdoe.weatherornot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomePage(currentLocation: String) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Text(text = "This is the weather!")
        Text(text = "Current Location: $currentLocation")
        Text(text = "Region: ${findLocationObject(currentLocation).region}")
    }
}
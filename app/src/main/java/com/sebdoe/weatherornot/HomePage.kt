package com.sebdoe.weatherornot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun HomePage(dataManager: DataManager) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Text(text = "This is the weather!")
        Text(text = "Current Location: ${dataManager.location}")
        Text(text = "Region: ${findLocationObject(dataManager.location).region}")
        Text(text = "Some more text")
    }
}
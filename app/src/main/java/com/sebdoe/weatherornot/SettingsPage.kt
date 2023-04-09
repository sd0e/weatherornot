package com.sebdoe.weatherornot

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsPage(currentLocation: String, newLocation: (String) -> Unit) {
    Dropdown(options = locations, selectedText = currentLocation, onSelectedChange = { loc -> newLocation(loc) })
}
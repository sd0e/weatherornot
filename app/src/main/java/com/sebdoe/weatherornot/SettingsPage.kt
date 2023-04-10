package com.sebdoe.weatherornot

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsPage(dataManager: DataManager) {
    Dropdown(options = locationIDs, selectedText = dataManager.location, onSelectedChange = { loc -> dataManager.location = loc })
}
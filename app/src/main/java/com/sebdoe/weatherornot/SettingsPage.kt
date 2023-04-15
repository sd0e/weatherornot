package com.sebdoe.weatherornot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(dataManager: DataManager) {
    Column() {
        Dropdown(options = dataManager.locationIDs, selectedText = dataManager.location, onSelectedChange = { loc -> dataManager.location = loc; dataManager.refresh() })
        AssistChip(
            onClick = { dataManager.refresh() },
            label = { androidx.compose.material3.Text(text = "Refresh") },
            leadingIcon = {
                Icon(Icons.Filled.Refresh, contentDescription = "Refresh the weather", modifier = Modifier.size(AssistChipDefaults.IconSize))
            }
        )
    }
}
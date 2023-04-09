package com.sebdoe.weatherornot

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Dropdown(selectedText: String, onSelectedChange: (String) -> Unit, options: Array<String> = arrayOf("1", "2", "3")) {
    val context = LocalContext.current

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            TextField(value = selectedText, onValueChange = {}, readOnly = true, trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(
                expanded = expanded
            ) })

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option -> DropdownMenuItem(onClick = { onSelectedChange(option); expanded = false; Toast.makeText(context, option, Toast.LENGTH_SHORT).show() }, content = { Text(text = option) }) }
            }
        }
    }
}
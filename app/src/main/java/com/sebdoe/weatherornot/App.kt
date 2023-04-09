package com.sebdoe.weatherornot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val locations = arrayOf(
    "London", "Manchester", "Plymouth", "Sheffield", "Norwich", "Southampton"
)

@Preview
@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf(Routes.HomePage.route)
    }

    var currentLocation by remember {
        mutableStateOf(locations[0])
    }

    Scaffold(
        topBar = {
            TopAppBar() {
                AppTitle()
            }
        },
        content = {
            when (selectedRoute.value) {
                Routes.HomePage.route -> HomePage()
                Routes.SettingsPage.route -> SettingsPage(currentLocation) { newLocation ->
                    currentLocation = newLocation
                }
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = { newRoute ->
                    selectedRoute.value = newRoute
                })
        }
    )
}

@Preview
@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = "Weather or Not",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
package com.sebdoe.weatherornot

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object Locations {
    val London = Location(id = "London", region = "Greater London", latitude = 51.50, longitude = -0.13)
    val Manchester = Location(id = "Manchester", region = "Greater Manchester", latitude = 53.48, longitude = -2.24)
    val Plymouth = Location(id = "Plymouth", region = "Devon", latitude = 50.38, longitude = -4.14)
    val Sheffield = Location(id = "Sheffield", region = "South Yorkshire", latitude = 53.38, -1.47)
    val Norwich = Location(id = "Norwich", region = "Norfolk", latitude = 52.63, 1.30)
    val Southampton = Location(id = "Southampton", region = "Hampshire", latitude = 50.91, longitude = -1.40)

    val locationsArray = arrayOf(London, Manchester, Plymouth, Sheffield, Norwich, Southampton)
}

val locationIDs = arrayOf(
    "London", "Manchester", "Plymouth", "Sheffield", "Norwich", "Southampton"
)

fun findLocationObject(id: String = "London"): Location {
    val foundValue: Location? = Locations.locationsArray.find { it.id == id }
    return foundValue ?: Locations.London
}

@Preview
@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf(Routes.HomePage.route)
    }

    var currentLocation by remember {
        mutableStateOf(locationIDs[0])
    }

    Scaffold(
        topBar = {
            TopAppBar() {
                AppTitle()
            }
        },
        content = {
            when (selectedRoute.value) {
                Routes.HomePage.route -> HomePage(currentLocation)
                Routes.SettingsPage.route -> SettingsPage(currentLocation) { newLocation ->
                    currentLocation = newLocation;
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
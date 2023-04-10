package com.sebdoe.weatherornot

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.http.Query
import java.lang.Exception

class DataManager(app: Application) : AndroidViewModel(app) {
    var weather: WeatherResponse? by mutableStateOf(null)
    var location: String by mutableStateOf("London")

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

    private fun fetchData(latitude: Double, longitude: Double, currentWeather: String, hourly: String) {
        try {
            viewModelScope.launch {
                weather = API.weatherService.getWeather(latitude, longitude, currentWeather, hourly).body()
            }
        } catch (ex: Exception) {
            weather = null
        }
    }

    init {
        val locationInfo = findLocationObject(location)
        fetchData(latitude = locationInfo.latitude, longitude = locationInfo.longitude, currentWeather = "true", hourly = "temperature_2m,relativehumidity_2m,windspeed_10m")
    }
}
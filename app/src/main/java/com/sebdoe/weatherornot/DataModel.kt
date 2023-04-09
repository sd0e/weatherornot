package com.sebdoe.weatherornot

class Location(var id: String, var region: String, var latitude: Double, var longitude: Double) {
    val weatherUrl get() = "https://api.open-meteo.com/v1/forecast?latitude=$latitude&longitude=$longitude&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m"
}
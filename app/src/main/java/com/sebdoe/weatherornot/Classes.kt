package com.sebdoe.weatherornot

data class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val generationtime_ms: Double,
    val utc_offset_seconds: Int,
    val timezone: String,
    val timezone_abbreviation: String,
    val elevation: Double,
    val current_weather: CurrentWeather,
    val hourly_units: HourlyUnits,
    val hourly: Hourly
)

data class CurrentWeather(
    val temperature: Double,
    val windspeed: Double,
    val winddirection: Double,
    val weathercode: Int,
    val is_day: Int,
    val time: String
)

data class HourlyUnits(
    val time: String,
    val temperature_2m: String,
    val relativehumidity_2m: String,
    val windspeed_10m: String
)

data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val relativehumidity_2m: List<Int>,
    val windspeed_10m: List<Double>
)
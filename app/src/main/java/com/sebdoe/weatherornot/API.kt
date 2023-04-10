package com.sebdoe.weatherornot

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherOrNotApiService {
    @GET("forecast?")
    suspend fun getWeather(@Query("latitude") latitude: Double, @Query("longitude") longitude: Double, @Query("current_weather") currentWeather: String): Response<WeatherResponse>
}

object API {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/v1/latitude=52.52&longitude=13.41&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherOrNotApiService by lazy {
        retrofit.create(WeatherOrNotApiService::class.java)
    }
}
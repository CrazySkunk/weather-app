package com.jamie.code.weatherapp.network

import com.jamie.code.weatherapp.domain.WeatherResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("/{city}?unitGroup=metric&key=9HPWDHSXWHR52PT4ZHECBWYWD&contentType=json")
    fun getWeather(@Path("city") city:String):Response<WeatherResult>
}
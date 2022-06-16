package com.jamie.code.weatherapp.viewmodels

import androidx.lifecycle.ViewModel
import com.jamie.code.weatherapp.domain.WeatherResultDomain
import com.jamie.code.weatherapp.room.WeatherDao
import com.jamie.code.weatherapp.room.WeatherRepo
import kotlinx.coroutines.flow.Flow

class RoomWeatherRequest(private val repository: WeatherRepo) : ViewModel() {

    suspend fun addWeather(weatherResultDomain: WeatherResultDomain) =
        repository.insert(weatherResultDomain)

    fun getWeather(city: String): Flow<List<WeatherResultDomain>> = repository.getWeather
    fun getAllWeather(): Flow<List<WeatherResultDomain>> = repository.allWeather
    suspend fun updateWeather(weatherResultDomain: WeatherResultDomain) =
        repository.update(weatherResultDomain)

    suspend fun deleteWeather(weatherResultDomain: WeatherResultDomain) =
        repository.deleteWeather(weatherResultDomain)

    suspend fun deleteAll() = repository.deleteAll()
}
package com.jamie.code.weatherapp.room

import androidx.annotation.WorkerThread
import com.jamie.code.weatherapp.domain.WeatherResultDomain

class WeatherRepo(private val weatherDao: WeatherDao) {
    public val allWeather = weatherDao.getWeather()
    val getWeather = weatherDao.getWeather()

    @WorkerThread
    suspend fun insert(weatherResultDomain: WeatherResultDomain) =
        weatherDao.addWeather(weatherResultDomain)

    @WorkerThread
    suspend fun update(weatherResultDomain: WeatherResultDomain) =
        weatherDao.updateWeather(weatherResultDomain)

    @WorkerThread
    suspend fun deleteWeather(weatherResultDomain: WeatherResultDomain) =
        weatherDao.deleteWeather(weatherResultDomain)

    @WorkerThread
    suspend fun deleteAll() = weatherDao.deleteAll()
}
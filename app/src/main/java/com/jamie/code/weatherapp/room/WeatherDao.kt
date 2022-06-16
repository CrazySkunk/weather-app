package com.jamie.code.weatherapp.room

import androidx.room.*
import com.jamie.code.weatherapp.domain.WeatherResultDomain
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWeather(weatherResultDomain: WeatherResultDomain)

    @Query("select * from weather;")
    fun getWeather(): Flow<List<WeatherResultDomain>>

    @Update
    suspend fun updateWeather(weatherResultDomain: WeatherResultDomain)

    @Delete
    suspend fun deleteWeather(weatherResultDomain: WeatherResultDomain)

    @Query("delete from weather;")
    suspend fun deleteAll()
}
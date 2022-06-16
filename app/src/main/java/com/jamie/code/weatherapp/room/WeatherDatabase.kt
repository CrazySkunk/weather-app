package com.jamie.code.weatherapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(String::class), version = 1, exportSchema = false)
public abstract class WeatherDatabase:RoomDatabase() {
    abstract fun weatherDao():WeatherDao
    companion object{
        @Volatile
        private var INSTANCE:WeatherDatabase?=null
        fun getDataBase(context:Context):WeatherDatabase{
            return INSTANCE?: synchronized(this){
                val  instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "Weather_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
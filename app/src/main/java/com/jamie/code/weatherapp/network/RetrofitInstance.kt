package com.jamie.code.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"

class RetrofitInstance {
    companion object {
        private val instance by lazy {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy { instance.create(APIService::class.java) }
    }
}

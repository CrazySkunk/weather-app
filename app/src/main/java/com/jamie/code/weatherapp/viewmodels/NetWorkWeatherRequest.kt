package com.jamie.code.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamie.code.weatherapp.domain.WeatherResult
import com.jamie.code.weatherapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class NetWorkWeatherRequest:ViewModel() {

    fun getWeather(city:String):LiveData<WeatherResult?>{
        val data = MutableLiveData<WeatherResult?>()
        viewModelScope.launch {
            val call = RetrofitInstance.api.getWeather(city)
            if (call.isSuccessful){
                data.postValue(call.body())
            }else{
                data.postValue(null)
            }
        }
        return data
    }
}
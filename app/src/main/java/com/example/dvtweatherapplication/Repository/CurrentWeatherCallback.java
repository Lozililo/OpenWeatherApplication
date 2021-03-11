package com.example.dvtweatherapplication.Repository;

import com.example.dvtweatherapplication.Model.CurrentWeather;


public interface CurrentWeatherCallback {
    void onSuccess(CurrentWeather currentWeather);
    void onFailure(Throwable throwable);;
}

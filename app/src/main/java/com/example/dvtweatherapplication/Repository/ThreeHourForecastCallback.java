package com.example.dvtweatherapplication.Repository;


import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecast;

public interface ThreeHourForecastCallback {
    void onSuccess(ThreeHourForecast threeHourForecast);
    void onFailure(Throwable throwable);
}


package com.example.dvtweatherapplication.Repository;


import com.example.dvtweatherapplication.Model.ThreeHourForecast;

public interface ThreeHourForecastCallback {
    void onSuccess(ThreeHourForecast threeHourForecast);
    void onFailure(Throwable throwable);
}
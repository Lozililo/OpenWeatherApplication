package com.example.dvtweatherapplication.Services;

import com.example.dvtweatherapplication.Model.Current;
import com.example.dvtweatherapplication.Model.CurrentWeather;
import com.example.dvtweatherapplication.Model.ForecastData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WeatherServices {

//
//    @GET("https://api.openweathermap.org/data/2.5/weather?")
//    Call<CurrentWeatherResponse> getcurrentWeather(
//            @Query("q") String cityName,
//            @Query("appid") String API_KEY
//    );

   // api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
//    @GET("forecast5?")
//    Call getForecastByGPS(@Query("lat")  String latitude, @Query("lon")  String longitude, @Query("units")  String units);


    String CURRENT = "/data/2.5/weather";
    String FORECAST = "/data/2.5/forecast";


    @GET(CURRENT)
    Call<CurrentWeather> getCurrentWeatherByCityName(@QueryMap Map<String, String> options);

    @GET(FORECAST)
    Call<ForecastData> getWeatherForecastByCityName(@QueryMap Map<String, String> options);

}

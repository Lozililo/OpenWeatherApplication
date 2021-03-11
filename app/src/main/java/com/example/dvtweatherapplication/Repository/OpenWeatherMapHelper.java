package com.example.dvtweatherapplication.Repository;

import androidx.annotation.NonNull;

import com.example.dvtweatherapplication.Model.CurrentWeather;
import com.example.dvtweatherapplication.Services.ApiService;
import com.example.dvtweatherapplication.Services.WeatherServices;
import com.kwabenaberko.openweathermaplib.implementation.callback.ThreeHourForecastCallback;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OpenWeatherMapHelper {

    private static final String APPID = "appId";
    private static final String UNITS = "units";
    private static final String LANGUAGE = "lang";
    private static final String QUERY = "q";
    private static final String CITY_ID = "id";
    private static final String LATITUDE = "lat";
    private static final String LONGITUDE = "lon";
    private static final String ZIP_CODE = "zip";

    private final WeatherServices weatherServices;
    private final Map<String, String> options;


    public OpenWeatherMapHelper(String apiKey){
        weatherServices = ApiService.getClient().create(WeatherServices.class);
        options = new HashMap<>();
        options.put(APPID, apiKey == null ? "" : apiKey);
    }



    private Throwable NoAppIdErrMessage() {
        return new Throwable("UnAuthorized. Please set a valid OpenWeatherMap API KEY.");
    }


    private Throwable NotFoundErrMsg(String str) {
        Throwable throwable = null;
        try {
            JSONObject obj = new JSONObject(str);
            throwable = new Throwable(obj.getString("message"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (throwable == null){
            throwable = new Throwable("An unexpected error occurred.");
        }
        return throwable;
    }


    //GET CURRENT WEATHER BY CITY NAME
    public void getCurrentWeatherByCityName(String city, final CurrentWeatherCallback callback){
        options.put(QUERY, city);

        weatherServices.getCurrentWeatherByCityName(options).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                handleCurrentWeatherResponse(response, callback);

                if (response.code()==200){

                }

            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable throwable) {
                callback.onFailure(throwable);
            }
        });
    }


    private void handleCurrentWeatherResponse(Response<CurrentWeather> response, CurrentWeatherCallback callback){
        if (response.code() == HttpURLConnection.HTTP_OK){
            callback.onSuccess(response.body());
        }
        else if (response.code() == HttpURLConnection.HTTP_FORBIDDEN || response.code() == HttpURLConnection.HTTP_UNAUTHORIZED){
            callback.onFailure(NoAppIdErrMessage());
        }
        else{
            try {
                callback.onFailure(NotFoundErrMsg(response.errorBody().string()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Get Forecast By City name
    public void getThreeHourForecastByCityName(String city, final ThreeHourForecastCallback callback){
        options.put(QUERY, city);
        weatherServices.getWeatherForecastByCityName(options)
                .enqueue(new Callback<ThreeHourForecast>() {
                    @Override
                    public void onResponse(@NonNull Call<ThreeHourForecast> call, @NonNull Response<ThreeHourForecast> response) {
                        handleThreeHourForecastResponse(response, callback);
                    }

                    @Override
                    public void onFailure(@NonNull Call<ThreeHourForecast> call, @NonNull Throwable throwable) {
                        callback.onFailure(throwable);
                    }
                });

    }

    private void handleThreeHourForecastResponse(Response<ThreeHourForecast> response, ThreeHourForecastCallback callback){
        if (response.code() == HttpURLConnection.HTTP_OK){
            callback.onSuccess(response.body());
        }
        else if (response.code() == HttpURLConnection.HTTP_FORBIDDEN || response.code() == HttpURLConnection.HTTP_UNAUTHORIZED){
            callback.onFailure(NoAppIdErrMessage());
        }
        else{
            try {
                callback.onFailure(NotFoundErrMsg(response.errorBody().string()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

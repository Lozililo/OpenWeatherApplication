package com.example.dvtweatherapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dvtweatherapplication.Adapter.ForecastAdapter;
import com.example.dvtweatherapplication.Model.Current;
import com.example.dvtweatherapplication.Model.CurrentWeather;
import com.example.dvtweatherapplication.Model.CurrentWeatherResponse;
import com.example.dvtweatherapplication.Model.ForecastData;
import com.example.dvtweatherapplication.Model.ThreeHourForecast;
import com.example.dvtweatherapplication.Repository.CurrentWeatherCallback;

import com.example.dvtweatherapplication.Repository.ThreeHourForecastCallback;
import com.example.dvtweatherapplication.Services.Constant;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView temps, weatherState, cityName,maxTemp,minTemp,currentTemp;
    ImageView weatherIcon;
  //  WeatherForecastViewModel weatherForecastViewModel;
    Current currentWeather;
    CurrentWeatherResponse currentWeatherResponse;
    ForecastAdapter forecastAdapter;
    RecyclerView forecastRecycler;
    OpenWeatherMapHelper helper = new OpenWeatherMapHelper(Constant.API_KEY);
    CardView cardView;
    ArrayList<ForecastData> forecastDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView=findViewById(R.id.weatherCard);
        weatherState = findViewById(R.id.weatherCondition);
        temps = findViewById(R.id.current_temperature);
        weatherIcon = findViewById(R.id.weatherPicture);
        maxTemp=findViewById(R.id.max_degrees_values);
        minTemp=findViewById(R.id.min_degrees_value);
        currentTemp=findViewById(R.id.current_degrees_value);
        forecastRecycler=findViewById(R.id.forecast_recycler);


        fiveDaysForeCast();


        helper.getCurrentWeatherByCityName("Johannesburg", new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                Log.v("TAG", "Coordinates: " + currentWeather.getCoord() + ", " + currentWeather.getCoord() + "\n"
                        + "Weather Description: " + currentWeather.getWeather().get(0).main + "\n"
                        + "Temperature: " + currentWeather.getMain().getTemp() + "\n"
                        + "Min Temperature: "+ currentWeather.getMain().feels_like
                        +"Max Temperature: "+currentWeather.getMain().temp_max
                        + "Wind Speed: " + currentWeather.getWind().deg + "\n"
                        + "City, Country: " + currentWeather.getName() + ", " + currentWeather.getSys());

//get values from the api and convert them to degree celsius from kelvin
               String WeatherDescription= currentWeather.getWeather().get(0).main;
               float  Temp= (float) (currentWeather.getMain().getTemp()-273.15);
               float MinTemp= (float) (currentWeather.getMain().temp_min-273.15);
               float MaxTemp= (float) (currentWeather.getMain().temp_max-273.15);


               if(WeatherDescription=="Clear"){



               }else if(WeatherDescription=="Clouds"){

                }else if(WeatherDescription==""){

               }
                String weatherTemp=Float.toString(Temp);
                String MinTemperature=Float.toString(MinTemp);
                String maxTemperature=Float.toString(MaxTemp);


                weatherState.setText(WeatherDescription);
              temps.setText(weatherTemp);
             minTemp.setText(weatherTemp+" °C");
             maxTemp.setText( MinTemperature+" °C");
             currentTemp.setText(maxTemperature+" °C");


            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v("TAG", throwable.getMessage());
            }


        });
    }
    public void fiveDaysForeCast(){

        helper.getThreeHourForecastByCityName("Johannesburg", new ThreeHourForecastCallback() {
            @Override
            public void onSuccess(ThreeHourForecast threeHourForecast) {
                Log.v("TAGS", "City/Country: "+ threeHourForecast.getCity().getName() + "/" + threeHourForecast.getCity().getCountry() +"\n"
                        +"Forecast Array Count: " + threeHourForecast.getCnt() +"\n"
                        //For this example, we are logging details of only the first forecast object in the forecasts array
                        +"First Forecast Date Timestamp: " + threeHourForecast.getList().get(0).getDt() +"\n"
                        +"First Forecast Weather Description: " + threeHourForecast.getList().get(0).getWeather().get(0).getDescription()+ "\n"
                        +"First Forecast Max Temperature: " + threeHourForecast.getList().get(0).getMain().getTempMax()+"\n"
                        +"First Forecast Wind Speed: " + threeHourForecast.getList().get(0).getWind().getSpeed() + "\n");
            };

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        forecastDataArrayList=new ArrayList<>();

        forecastRecycler=findViewById(R.id.forecast_recycler);
        forecastAdapter=new ForecastAdapter(forecastDataArrayList);

        forecastRecycler.setAdapter(forecastAdapter);
        forecastRecycler.setLayoutManager(new LinearLayoutManager(this));


}
}
package com.example.dvtweatherapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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
import com.example.dvtweatherapplication.Repository.CurrentWeatherCallback;

import com.example.dvtweatherapplication.Repository.OpenWeatherMapHelper;
import com.example.dvtweatherapplication.Services.Constant;
import com.kwabenaberko.openweathermaplib.implementation.callback.ThreeHourForecastCallback;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecast;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecastWeather;


import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView temps, weatherState,maxTemp,minTemp,currentTemp;
    ImageView weatherIcon;
    Current currentWeather;
    CurrentWeatherResponse currentWeatherResponse;
    ForecastAdapter forecastAdapter;
    RecyclerView forecastRecycler;
    OpenWeatherMapHelper helper = new OpenWeatherMapHelper(Constant.API_KEY);
    CardView cardView;
    List<ThreeHourForecastWeather> forecastDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView=findViewById(R.id.weatherCard);
        weatherState = findViewById(R.id.weatherCondition);
        temps = findViewById(R.id.current_temp);
        weatherIcon = findViewById(R.id.weatherPicture);
        maxTemp=findViewById(R.id.max_degrees_values);
        minTemp=findViewById(R.id.min_degrees_value);
        currentTemp=findViewById(R.id.current_degrees_value);
        forecastRecycler=findViewById(R.id.forecast_recycler);

        //get values for current weather APi by calling helper class
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

                String weatherTemp=Float.toString(Temp);
                String MinTemperature=Float.toString(MinTemp);
                String maxTemperature=Float.toString(MaxTemp);


            //set current weather values to views
             temps.setText(weatherTemp);
             minTemp.setText(weatherTemp+" °C");
             maxTemp.setText( MinTemperature+" °C");
             currentTemp.setText(maxTemperature+" °C");

             //change weather background according to weather description
                for (int x = 0; x < currentWeather.getWeather().size(); x++) {
                    String tokenWeather = "" + currentWeather.getWeather().get(0).main;
                    if (tokenWeather.contains("clear sky")) {
                        weatherState.setText(WeatherDescription);
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_sunny));

                    }else if (tokenWeather.contains("broken clouds")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_cloudy));
                    }else if (tokenWeather.contains("few clouds")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_cloudy));
                    }else if (tokenWeather.contains("overcast")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_cloudy));
                    }else if (tokenWeather.contains(" scattered clouds")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_cloudy));
                    }else if (tokenWeather.contains("light rain")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_rainy));
                    }else if (tokenWeather.contains("light rain")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_rainy));
                    }else if (tokenWeather.contains("sunny")) {
                        cardView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.forest_sunny
                        ));
                    }

                }
            }
            @Override
            public void onFailure(Throwable throwable) {
                Log.v("TAG", throwable.getMessage());
            }


        });

        //get Forecast 5 data and attach to recyclerview

        helper.getThreeHourForecastByCityName("Johannesburg", new ThreeHourForecastCallback() {
            @Override
            public void onSuccess(ThreeHourForecast threeHourForecast) {

                List<ThreeHourForecastWeather> threeHourForecastWeatherList=threeHourForecast.getList();
                threeHourForecastWeatherList.get(0).getDt();
                threeHourForecastWeatherList.get(0).getMain().getTemp();

                forecastAdapter=new ForecastAdapter(threeHourForecastWeatherList);
                RecyclerView recyclerView=findViewById(R.id.forecast_recycler);
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(forecastAdapter);

            }

            @Override
            public void onFailure(Throwable throwable) {

                System.out.println("Error "+ throwable.getMessage());
            }
        });

    }
 //
}
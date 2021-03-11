package com.example.dvtweatherapplication.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final String BASE_URL = "https://api.openweathermap.org";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}


//   // public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
//    public  WeatherServices getWeatherData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.openweathermap.org/data/2.5/weather/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        return retrofit.create(WeatherServices.class);
//    }
//}

//api.openweathermap.org/data/2.5/weather?q=Johannesburg&appid=ecd983f2e8fbee42bbb5ba9029f4e585
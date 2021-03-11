//package com.example.dvtweatherapplication.ViewModel;
//
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//
//import com.example.dvtweatherapplication.Model.CurrentWeatherResponse;
//import com.example.dvtweatherapplication.Repository.WeatherForecastRepository;
//import com.example.dvtweatherapplication.Services.Constant;
//
//
//public class WeatherForecastViewModel extends ViewModel {
//
//
//    WeatherForecastRepository weatherForecastRepository = new WeatherForecastRepository();
//    private MutableLiveData<CurrentWeatherResponse> currentWeatherLiveData;
////    private CurrentWeather currentWeather;
////    CurrentWeatherResponse currentWeatherResponse=new CurrentWeatherResponse();
//
//
//    public LiveData<CurrentWeatherResponse> getCurrentWeatherLiveData(String cityName) {
//
//      return   weatherForecastRepository.getWeatherResponse("Johannesburg", Constant.API_KEY) ;
//
//    }
//
//    public LiveData<CurrentWeatherResponse> getWeatherLiveData(){
//        return currentWeatherLiveData;
//    }
//
//}
//
//
////add callback
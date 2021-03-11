//package com.example.dvtweatherapplication.Repository;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.dvtweatherapplication.Model.CurrentWeatherResponse;
//import com.example.dvtweatherapplication.Services.Constant;
//import com.example.dvtweatherapplication.Services.WeatherServices;
//import com.example.dvtweatherapplication.Services.ApiService;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//
//public class WeatherForecastRepository {
//
//     ApiService apiService = new ApiService();
//    public MutableLiveData<CurrentWeatherResponse> currentWeatherResponseMutableLiveData;
//    public CurrentWeatherResponse currentWeatherResponseList;
//
//
//
//
//    public LiveData<CurrentWeatherResponse> getWeatherResponse(String cityName, String API_KEY){
//
//        Call<CurrentWeatherResponse> currentWeatherCall=apiService.getWeatherData().getcurrentWeather(cityName,Constant.API_KEY);
//        currentWeatherCall.enqueue(new Callback<CurrentWeatherResponse>() {
//            @Override
//            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
//                if (response.code()==200){
//                    currentWeatherResponseList=response.body();
//                    currentWeatherResponseMutableLiveData.postValue(currentWeatherResponseList);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
//                System.out.println("failed");
//            }
//        });
//        return currentWeatherResponseMutableLiveData;
//    }
//
//
//
//
//    public LiveData<CurrentWeatherResponse> WeatherForecastRepository() {
//       return currentWeatherResponseMutableLiveData ;
//    }
//}
package com.example.dvtweatherapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {

    @SerializedName("temp")
    @Expose
    public String currentTemperature;
    @SerializedName("temp_min")
    @Expose
    public String minTemperature;
    @SerializedName("temp_max")
    @Expose
    public String maxTemperature;
    @SerializedName("main")
    @Expose
    private String currentWeather;

    public Current() {

    }
    public Current(String currentTemperature, String minTemperature, String maxTemperature, String currentWeather) {

        this.currentTemperature = currentTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentWeather = currentWeather;

    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

}

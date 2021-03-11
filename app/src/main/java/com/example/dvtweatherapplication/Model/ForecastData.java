package com.example.dvtweatherapplication.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class ForecastData {

    private String teemperature,weekday;
    public String getTeemperature() {
        return teemperature;
    }

    public void setTeemperature(String teemperature) {
        this.teemperature = teemperature;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
}

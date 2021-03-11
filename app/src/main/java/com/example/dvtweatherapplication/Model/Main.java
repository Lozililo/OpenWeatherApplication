package com.example.dvtweatherapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

   @SerializedName("temp")
   @Expose
   public float temp;
   @SerializedName("feels_like")
   @Expose
   public float feels_like;
   @SerializedName("temp_min")
   @Expose
   public float temp_min;
   @SerializedName("temp_max")
   @Expose
   public float temp_max;
   @SerializedName("pressure")
   @Expose
   public float pressure;
   @SerializedName("sea_level")
   public float sea_level;
   @SerializedName("grnd_leve")
   public float grnd_leve;
   @SerializedName("humidity")
   public float humidity;
   @SerializedName("temp_kf")
   public float temp_kf;
    public String getTemp;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSea_level() {
        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public float getGrnd_leve() {
        return grnd_leve;
    }

    public void setGrnd_leve(float grnd_leve) {
        this.grnd_leve = grnd_leve;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(float temp_kf) {
        this.temp_kf = temp_kf;
    }
}

package com.example.dvtweatherapplication.Model;

import com.google.gson.annotations.SerializedName;

class Coord {
    @SerializedName("lon")
    public float lon;
    @SerializedName("lat")
    public float lat;

    public void getLat() {
    }
}

package com.example.dvtweatherapplication.Model;

import com.google.gson.annotations.SerializedName;

class Sys {
    @SerializedName("country")
    public String country;
    @SerializedName("sunrise")
    public long sunrise;
    @SerializedName("sunset")
    public long sunset;
    @SerializedName("pod")
    public long pod;
}

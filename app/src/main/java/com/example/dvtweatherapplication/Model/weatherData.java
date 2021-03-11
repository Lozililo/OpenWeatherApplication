package com.example.dvtweatherapplication.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature,micon,mcity,mWeatherType;
    private int mCondition;

    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<=300)
        {
            return "sea_rainy";
        }
        else if(condition>=300 && condition<=500)
        {
            return "forest_rainy";
        }
        else if(condition>=500 && condition<=600)
        {
            return "forest_rainy";
        }
       else  if(condition>=600 && condition<=700)
        {
            return "forest_rainy";
        }
        else if(condition>=701 && condition<=771)
        {
            return "sea_rainy";
        }

        else if(condition>=772 && condition<=800)
        {
            return "sea_rainy";
        }

        else if(condition>=800 || condition<=804)
        {
            return "forest_cloudy";
        }
       else  if(condition>=900 && condition<=902)
        {
            return "clear2x";
        }
        if(condition==903)
        {
            return "forest_sunny";
        }
        if(condition==904)
        {
            return "forest_sunny";
        }
        if(condition>=905 && condition<=1000)
        {
            return "rain";
        }

        return "dunno";


    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}

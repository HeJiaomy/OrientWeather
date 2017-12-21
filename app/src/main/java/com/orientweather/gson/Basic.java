package com.orientweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hejiao on 2017/12/20.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}

package com.orientweather.gson;

/**
 * Created by hejiao on 2017/12/20.
 */

public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}

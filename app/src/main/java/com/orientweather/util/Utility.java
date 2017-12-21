package com.orientweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.orientweather.db.City;
import com.orientweather.db.County;
import com.orientweather.db.Province;
import com.orientweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 12191 on 2017/12/20.
 */

public class Utility {
    /*
    解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray provinces= new JSONArray(response);
                for (int i=0; i<provinces.length(); i++){
                    JSONObject provinceObject= provinces.getJSONObject(i);
                    Province province= new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /*
    解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray cities= new JSONArray(response);
                for (int i=0; i<cities.length(); i++){
                    JSONObject cityObject= cities.getJSONObject(i);
                    City city= new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
    解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray counties= new JSONArray(response);
                for (int i=0; i<counties.length(); i++){
                    JSONObject countyObject= counties.getJSONObject(i);
                    County county= new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 把Json数据解析成Weather对象
     *
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject= new JSONObject(response);
            JSONArray jsonArray= jsonObject.getJSONArray("HeWeather");
            String weatherContent= jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

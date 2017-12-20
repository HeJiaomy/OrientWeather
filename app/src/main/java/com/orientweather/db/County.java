package com.orientweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 12191 on 2017/12/20.
 */

public class County extends DataSupport {
    private int id;
    private String countyName;
    private int weatherId;  //县对应的天气id
    private int cityId; //当前县所属的市的id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

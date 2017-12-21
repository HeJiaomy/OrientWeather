package com.orientweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hejiao on 2017/12/20.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}

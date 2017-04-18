package com.jinfukeji.healthapp;

import android.app.Application;

/**
 * Created by "于志渊"
 * 时间:"10:13"
 * 包名:com.jinfukeji.healthapp
 * 描述:用于存放全局变量的类
 */

public class HealthActivity extends Application{
    private static HealthActivity intance;
    private static final String URL_MAIN="http://114.55.142.212:8080/yahe/";
    @Override
    public void onCreate() {
        super.onCreate();
        intance=this;
    }

    public static HealthActivity getIntance() {
        return intance;
    }

    public static void setIntance(HealthActivity intance) {
        HealthActivity.intance = intance;
    }

    public static String getUrlMain() {
        return URL_MAIN;
    }
}

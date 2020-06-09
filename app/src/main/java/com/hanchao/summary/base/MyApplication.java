package com.hanchao.summary.base;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.lljjcoder.style.citylist.utils.CityListLoader;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        CityListLoader.getInstance().loadCityData(this);
    }
}

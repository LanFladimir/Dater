package com.dev_lan.dater;

import android.app.Application;

import org.litepal.LitePal;

public class DaterApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}

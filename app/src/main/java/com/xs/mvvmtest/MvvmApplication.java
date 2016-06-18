package com.xs.mvvmtest;

import android.app.Application;
import android.content.Context;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-18 11:00
 * @email Xs.lin@foxmail.com
 */
public class MvvmApplication extends Application {

    public static MvvmApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }

}

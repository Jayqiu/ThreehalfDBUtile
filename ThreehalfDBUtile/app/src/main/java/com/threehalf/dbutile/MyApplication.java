package com.threehalf.dbutile;

import android.app.Application;

import com.threehalf.dbutile.observable.Observable;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/23 11:34
 */
public class MyApplication extends Application {
    private Observable notificationCenter = null;


    @Override
    public void onCreate() {
        super.onCreate();
        getNotificationCenter();
    }
    public Observable getNotificationCenter() {
        if (notificationCenter == null)
            notificationCenter = new Observable();
        return notificationCenter;

    }
}

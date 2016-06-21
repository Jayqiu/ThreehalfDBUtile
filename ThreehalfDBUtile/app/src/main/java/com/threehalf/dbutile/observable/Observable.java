package com.threehalf.dbutile.observable;


import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/20 18:18
 */
public class Observable {

    private Map<Object, Map<Integer, Observer>> obseverList = new HashMap<Object, Map<Integer, Observer>>();

    public void sendNotification(Class<?> cls,int notificationCode,Object obj) {
        Map<Integer, Observer> observersMap = obseverList.get(cls);// 类
        if(observersMap!=null){
            for (Integer weakObserver : observersMap.keySet()) {

                    if (weakObserver == notificationCode) {
                        Observer observer=    observersMap.get(weakObserver);
                        if(observer!=null){
                            observer.onUpdate(obj,notificationCode);
                        }else {
                            continue;
                        }

                    }

            }
        }else {
            Log.e("","");
        }


    }
    public void removeObserver(Class<?> cls,int notificationCode) {
        Map<Integer, Observer> currentObserversMap = obseverList.get(cls);// 类
        if (currentObserversMap != null) {
            for (Integer weakObserver : currentObserversMap
                    .keySet()) {
                if (weakObserver ==notificationCode) {
                    currentObserversMap.remove(weakObserver);
                }
            }
        }
    }
    public void removeObserver(Class<?> cls) {
        Map<Integer, Observer> currentObserversMap = obseverList.get(cls);// 类
        if (currentObserversMap != null) {
            obseverList.remove(cls);
        }
    }
    public void addObserver(Class<?> cls, int notificationCode, Observer myObserver) {

        Log.i("=========", cls.getCanonicalName()+"===");
        Map<Integer, Observer> currentObserversMap = obseverList.get(cls);// 类


        if (currentObserversMap != null) {// 存在
            boolean hasObserver = false;
            for (Integer weakObserver : currentObserversMap.keySet()) {
                if (weakObserver != null) {
                    if (weakObserver == notificationCode) {
                        currentObserversMap.remove(weakObserver);
                        currentObserversMap.put(weakObserver, myObserver);
                        hasObserver = true;
                    }
                }
            }
            if (!hasObserver) {
                currentObserversMap.put(notificationCode,
                        myObserver);
            }
        } else {// 不存在
            Map<Integer, Observer> newObserversMap = new HashMap<Integer, Observer>();
            newObserversMap.put(notificationCode,
                    myObserver);
            obseverList.put(cls, newObserversMap);
        }

    }
}

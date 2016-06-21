package com.threehalf.dbutile.observable;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/20 18:20
 */
public interface  Observer<T> {
    void onUpdate(T data,int code);
}

package com.threehalf.dbutile;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.threehalf.dbutile.observable.Observable;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/23 10:08
 */
public class ActNext extends AppCompatActivity {
    private Button mBtn;
    private Button mBtnTwo;
    private  Observable observable;
    private MyApplication myApplication;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn);
        mBtnTwo = (Button) findViewById(R.id.btn_two);
         myApplication = (MyApplication) getApplication();
         observable = myApplication.getNotificationCenter();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                observable.sendNotification(MainActivity.class, 100, "100的");
            }
        });

        mBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyApplication myApplication = (MyApplication) getApplication();
//                Observable observable = myApplication.getNotificationCenter();
//                observable.sendNotification(MainActivity.class, 101, "101的");
                observable.removeObserver(MainActivity.class);
            }
        });
    }
}

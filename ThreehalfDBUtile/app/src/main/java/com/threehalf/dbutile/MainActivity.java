package com.threehalf.dbutile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.threehalf.dbutile.entity.UserEntity;
import com.threehalf.dbutile.observable.Observable;
import com.threehalf.dbutile.observable.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    private Button mBtn;
    private  Observable observable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn=(Button) findViewById(R.id.btn);
        MyApplication myApplication = (MyApplication) getApplication();
         observable = myApplication.getNotificationCenter();


        observable.addObserver(MainActivity.class,101,this);
//        Observable<UserEntity> observable=new Observable<UserEntity>();
//        Observable<UserEntity> observabl1e=new Observable<UserEntity>();
//        //
//        Observer<UserEntity> observer1=new Observer<UserEntity>() {
//            @Override
//            public void onUpdate(Observable<UserEntity> observable, UserEntity data) {
//                System.out.println("观察者1："+data.toString());
//            }
//        };
//
//        observable.register(observer1);
//        UserEntity userEntity= new UserEntity();
//        userEntity.setNickName("000");
//        observable.notifyObservers(userEntity);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.addObserver(MainActivity.class,100,MainActivity.this);
                Intent intent= new Intent(MainActivity.this,ActNext.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    @Override
    public void onUpdate( Object data ,int code) {
        if(100==code){
            Toast.makeText(this,data.toString()+"",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,data.toString()+"",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        observable.removeObserver(MainActivity.class);
    }
}

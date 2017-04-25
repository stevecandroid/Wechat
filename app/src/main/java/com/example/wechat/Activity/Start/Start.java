package com.example.wechat.Activity.Start;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;

import com.example.wechat.Activity.BaseActvity.BaseActivity;
import com.example.wechat.R;
import com.example.wechat.Uitls.ActivityHelper;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.WeChatApplication;


import static android.Manifest.permission.*;
import static android.content.pm.PackageManager.*;

public class Start extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkPermission();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initBmob();


        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checkCurrentUser();
                finish();
            }
        }).start();

    }

    @Override
    protected void onStart() {
        LogHelper.e("Start start");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        LogHelper.e("Start destorey");
        super.onDestroy();
    }

    private void checkPermission(){
        if(ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this,READ_CONTACTS) != PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{READ_CONTACTS,WRITE_EXTERNAL_STORAGE},1);
        }

        while(ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this,READ_CONTACTS) != PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        LogHelper.e(grantResults.length);
        if(grantResults.length == 2 && grantResults[0] == PERMISSION_GRANTED && grantResults[1] == PERMISSION_GRANTED){
            initBmob();
            checkCurrentUser();
            //TODO 申请到了权限做点事情
        }
        else{
            finish();
        }

    }




}

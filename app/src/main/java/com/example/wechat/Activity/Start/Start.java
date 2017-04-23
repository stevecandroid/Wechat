package com.example.wechat.Activity.Start;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wechat.Activity.Login_Register.Register;
import com.example.wechat.Chat.Message;
import com.example.wechat.R;
import com.example.wechat.Uitls.ActivityHelper;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.Uitls.ToastHelper;
import com.google.gson.Gson;


import org.json.JSONObject;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobRealTimeData;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.ValueEventListener;

import static android.Manifest.permission.*;
import static android.content.pm.PackageManager.*;

public class Start extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkPermission();
        super.onCreate(savedInstanceState);
        ActivityHelper.addActivity(this);
        setContentView(R.layout.activity_start);
        initBmob();
        checkCurrentUser();
//        BmobUser bu = new BmobUser();
//        bu.setUsername("fucker");
//        bu.setPassword("sucker");
//        bu.setEmail("213@123.com");
//        bu.login(this, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                ToastHelper.Toast("successs");
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                ToastHelper.Toast(s);
//            }
//        });

        final BmobRealTimeData rtd = new BmobRealTimeData();
        rtd.start(this, new ValueEventListener() {
            @Override
            public void onConnectCompleted() {
                ToastHelper.Toast("ConnectCompleted");
                rtd.subTableUpdate("Chat");
            }

            @Override
            public void onDataChange(JSONObject jsonObject) {
                Message message ;
                Gson gson = new Gson();
                message = gson.fromJson(jsonObject.optString("data"), Message.class);
                ToastHelper.Toast(message.getMessage() );
            }
        });



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
            //TODO 申请到了权限做点事情
        }
        else{
            finish();
        }

    }

    /**
     *  初始化BmobSDK
     */
    private void initBmob(){
        BmobConfig config = new BmobConfig.Builder(this)
                .setApplicationId("0dea943894622b23eafeb624070fa149")
                .setConnectTimeout(15)//默认时间
//                .setUploadBlockSize()//分片上传时每片大小
//                .setFileExpiration(1800) 文件过期时间
                .build();
        Bmob.initialize(config);
    }

    /**
     * 检查最近登录是否有效
     */
    private void checkCurrentUser(){
        BmobUser bmobUser = BmobUser.getCurrentUser(this);
        if(bmobUser != null){
            //TODO 有效则让用户通过
            IntentHelper.startActivity(this, Register.class);
        }else{
            //TODO 无效则去注册界面
            IntentHelper.startActivity(this, Register.class);
        }
    }
}

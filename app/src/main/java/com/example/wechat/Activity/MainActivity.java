package com.example.wechat.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.wechat.GlobalVariable.Global;
import com.example.wechat.R;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.Uitls.ToastHelper;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Global.setmCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogHelper.Log(1);


    }
}

package com.example.wechat.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.wechat.GlobalVariable.Global;
import com.example.wechat.R;
import com.example.wechat.Uitls.ToastHelper;

public class MainActivity extends AppCompatActivity {

    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastHelper.Toast(1);
        

    }
}

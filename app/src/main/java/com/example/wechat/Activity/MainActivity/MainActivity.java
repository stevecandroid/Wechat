package com.example.wechat.Activity.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.wechat.Activity.BaseActvity.BaseActivity;
import com.example.wechat.Activity.ChatActivity.ChatActivity;
import com.example.wechat.Activity.Fragment.PersonalPageFrag;
import com.example.wechat.R;
import com.example.wechat.Service.DataChangeService;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.Uitls.ToastHelper;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public static FragmentManager fm;

    @Override
    protected void onDestroy() {
        LogHelper.e("Main destory" +
                "");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        LogHelper.e("Main Start" +
                "");
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, DataChangeService.class);
        startService(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();


        Button button = (Button) findViewById(R.id.bt);
        RadioButton rb_my = (RadioButton) findViewById(R.id.rb_my);
        button.setOnClickListener(this);
        rb_my.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_my:
                ToastHelper.Toast("fsd");
                startPersonalPageFrag();
                break;

            case R.id.bt:
                IntentHelper.startActivity(MainActivity.this, ChatActivity.class);
                break;

        }
    }

    
    long start = 0 ;
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - start > 2000 && fm.getBackStackEntryCount() == 0){
            start = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        }else {                                                                 //设置按两次退出程序
            super.onBackPressed();
        }
    }

    public static void startPersonalPageFrag(){
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.container,new PersonalPageFrag());
        ft.commit();
    }



}


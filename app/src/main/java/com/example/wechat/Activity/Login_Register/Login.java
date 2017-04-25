package com.example.wechat.Activity.Login_Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wechat.Activity.MainActivity.MainActivity;
import com.example.wechat.R;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.Uitls.ToastHelper;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ImageView earth = (ImageView) findViewById(R.id.im_earth);
        final EditText et_account_login = (EditText) findViewById(R.id.et_account_login);
        final EditText et_password_login = (EditText)findViewById(R.id.et_password_login);
        Button bt_switch_register = (Button) findViewById(R.id.bt_switch_register);
        Button login = (Button)findViewById(R.id.bt_login);

        final Animation spinSlow = new AnimationUtils().loadAnimation(this,R.anim.spinforeverslow);
        final Animation spinQuick = new AnimationUtils().loadAnimation(this,R.anim.spinforeverquick);
        spinSlow.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return input;
            }
        });
        earth.startAnimation(spinSlow);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser bu = new BmobUser();
                if(et_account_login.getText().toString().contains("@")){
                    bu.setEmail(et_account_login.getText().toString());
                }else {
                    bu.setUsername(et_account_login.getText().toString());
                }
                bu.setPassword(et_password_login.getText().toString());

                bu.login(Login.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        IntentHelper.startActivity(Login.this, MainActivity.class);
                        finish();
                    }
                    @Override
                    public void onFailure(int i, String s) {
                        ToastHelper.Toast(s);
                    }
                });
            }
        });

        bt_switch_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentHelper.startActivity(Login.this,Register.class);
            }
        });


    }
}

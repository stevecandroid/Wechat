package com.example.wechat.Activity.Login_Register;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.wechat.R;
import com.example.wechat.Table.Chat;
import com.example.wechat.Uitls.ToastHelper;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText email;
    EditText password;
    EditText account;
    Button register;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setStatusBarColor(0xff1e1e1e);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       email = (EditText) findViewById(R.id.et_email);
       password = (EditText) findViewById(R.id.et_password);
       account = (EditText) findViewById(R.id.et_account);
       register = (Button) findViewById(R.id.Register);

       register.setOnClickListener(this);




   }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Register :
                BmobUser bu = new BmobUser();
//                bu.setUsername(account.getText().toString());
//                bu.setPassword(password.getText().toString());
//                bu.setEmail(email.getText().toString());
//                bu.signUp(this,new SaveListener(){
//                    @Override
//                    public void onSuccess() {
//                        LogHelper.Log("注册成功");
//                    }
//                    @Override
//                    public void onFailure(int i, String s) {
//                        LogHelper.Log(s);
//                    }
//                });
//                break;
                Chat chat = new Chat();
                chat.setMessage(account.getText().toString());
                chat.save(this, new SaveListener() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFailure(int i, String s) {
                        ToastHelper.Toast("failure");
                    }
                });

        }
    }

    /**
     * @param color
     */
    private void setStatusBarColor(int color){

        Window mWindow = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWindow.setStatusBarColor(color);
        }
    }
}

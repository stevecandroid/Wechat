package com.example.wechat.Activity.Login_Register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.wechat.Activity.BaseActivity;
import com.example.wechat.Activity.MainActivity.MainActivity;
import com.example.wechat.R;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.ToastHelper;

import static com.example.wechat.Model.UserManagerModel.*;

public class Register extends BaseActivity implements View.OnClickListener{

    EditText email;
    EditText password;
    EditText account;
    Button register;
    CheckBox checkBox;
    RegisterReceiver registerReceiver ;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       registerReceiver = new RegisterReceiver();
       IntentFilter intentFilter = new IntentFilter();
       intentFilter.addAction("register_done");
       registerReceiver(registerReceiver,intentFilter);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setStatusBarColor(0xff1e1e1e);
//       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);
//       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       email = (EditText) findViewById(R.id.et_email);
       password = (EditText) findViewById(R.id.et_password);
       account = (EditText) findViewById(R.id.et_account);
       register = (Button) findViewById(R.id.bt_register);
       checkBox = (CheckBox)findViewById(R.id.checkBox) ;
       register.setOnClickListener(this);
       register.setClickable(false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    register.setClickable(true);
                } else {
                    register.setClickable(false);
                }
            }
        });

   }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_register:
               int status = mPresenter.register(account.getText().toString(),email.getText().toString(),password.getText().toString());
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
    class RegisterReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra("status",202);
            if(status == SUCCESS){
                IntentHelper.startActivity(Register.this, MainActivity.class);
            } else if(status == ACCOUNT_ERROR){
                ToastHelper.Toast("ACCOUNT_ERROR");
            } else if(status == EMAIL_ERROR){
                ToastHelper.Toast("EMAIL_ERROR");
            } else if(status == P_A_NULL){
                ToastHelper.Toast("P_A_NULL");
            }


        }
    }

    @Override
    protected void onStop() {
        unregisterReceiver(registerReceiver);
        super.onStop();
    }
}

package com.example.wechat.Activity.Login_Register;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.wechat.Activity.BaseActivity;
import com.example.wechat.Activity.MainActivity.MainActivity;
import com.example.wechat.Model.UserManagerModel;
import com.example.wechat.R;
import com.example.wechat.Table.Chat;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.ToastHelper;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import static com.example.wechat.Model.UserManagerModel.*;

public class Register extends BaseActivity implements View.OnClickListener{

    EditText email;
    EditText password;
    EditText account;
    Button register;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setStatusBarColor(0xff1e1e1e);
//       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);
//       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
               int status = mPresenter.register(account.getText().toString(),email.getText().toString(),password.getText().toString());
                if(status == SUCCESS){
                    IntentHelper.startActivity(this, MainActivity.class);
                } else if(status == ACCOUNT_ERROR){
                    ToastHelper.Toast("ACCOUNT_ERROR");
                } else if(status == EMAIL_ERROR){
                    ToastHelper.Toast("EMAIL_ERROR");
                } else if(status == P_A_NULL){
                    ToastHelper.Toast("P_A_NULL");
                }

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

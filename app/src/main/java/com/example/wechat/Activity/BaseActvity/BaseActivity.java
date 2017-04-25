package com.example.wechat.Activity.BaseActvity;

import android.support.v7.app.AppCompatActivity;

import com.example.wechat.Activity.ChatActivity.ChatActivity;
import com.example.wechat.Activity.Login_Register.Login;
import com.example.wechat.Activity.Login_Register.Register;
import com.example.wechat.Activity.MainActivity.MainActivity;
import com.example.wechat.Presenter.Presenter;
import com.example.wechat.Uitls.IntentHelper;

/**
 * Created by 铖哥 on 2017/4/24.
 */

public class BaseActivity extends AppCompatActivity {
    protected Presenter mPresenter = new Presenter();

    /**
     * 初始化BmobSDK
     */
    protected void initBmob() {
        mPresenter.initBmob(this);
    }

    /**
     * 检查最近登录是否有效
     */
    protected void checkCurrentUser() {
        if (mPresenter.checkCurrentUser(this)) {
            //TODO 有效则让用户通过
            IntentHelper.startActivity(this, MainActivity.class);
        } else {
            //TODO 无效则去注册或登录界面
            IntentHelper.startActivity(this,Login.class);
        }
    }



}

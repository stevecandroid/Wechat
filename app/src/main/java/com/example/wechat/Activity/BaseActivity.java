package com.example.wechat.Activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.wechat.Activity.Login_Register.Register;
import com.example.wechat.Presenter.Presenter;
import com.example.wechat.Uitls.IntentHelper;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobUser;

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
            IntentHelper.startActivity(this, Register.class);
        } else {
            //TODO 无效则去注册或登录界面
            IntentHelper.startActivity(this, Register.class);
        }
    }



}

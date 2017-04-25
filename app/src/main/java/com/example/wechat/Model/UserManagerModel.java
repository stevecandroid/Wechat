package com.example.wechat.Model;

import android.content.Intent;

import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.WeChatApplication;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 铖哥 on 2017/4/24.
 */

public class UserManagerModel extends Model {

    public static final int SUCCESS = 001;
    public static final int ACCOUNT_ERROR = 202;
    public static final int EMAIL_ERROR = 203;
    public static final int P_A_NULL = 304;
    private int mStatus = SUCCESS;
    Intent intent;
    public int register(String account,String email,String password){

        BmobUser bu = new BmobUser();
        bu.setUsername(account);
        bu.setPassword(password);
        bu.setEmail(email);

        bu.signUp(WeChatApplication.getContext(),new SaveListener(){
            @Override
            public void onSuccess() {
                intent = new Intent("register_done");
                intent.putExtra("status",SUCCESS);
                WeChatApplication.getContext().sendBroadcast(intent);
                LogHelper.e("success");
              mStatus = SUCCESS;
            }
            @Override
            public void onFailure(int i, String s) {
                intent = new Intent("register_done");
                intent.putExtra("status",i);
                WeChatApplication.getContext().sendBroadcast(intent);
                LogHelper.e(i);
                LogHelper.e(s);
                mStatus = i;
            }
        });
            return mStatus;

    }

}

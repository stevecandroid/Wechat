package com.example.wechat.Presenter;

import android.content.Context;

import com.example.wechat.Model.Model;
import com.example.wechat.Model.UserManagerModel;

/**
 * Created by 铖哥 on 2017/4/24.
 */

public class Presenter {

    Model mModel = new Model();
    UserManagerModel mUserManagerModel = new UserManagerModel();

    public void initBmob(Context context){
        mModel.initBmob(context);
    }

    public boolean checkCurrentUser(Context context){
        return mModel.checkCurrentUser(context);
    }

    public int register(String account,String email,String password){
        return mUserManagerModel.register(account,email,password);
    }

}

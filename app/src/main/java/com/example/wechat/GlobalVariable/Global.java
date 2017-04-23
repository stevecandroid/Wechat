package com.example.wechat.GlobalVariable;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class Global extends Application {

    private static Context mContext;

    public static Context getContext(){
        return mContext;
    }










    @Override
    public void onCreate() {
        Log.d("sad","asdasdas");
        mContext = getApplicationContext();
        super.onCreate();
    }


}

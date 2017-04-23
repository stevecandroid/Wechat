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
    private static Activity mCurrentActivity;

    public static Activity getmCurrentActivity() {
        //TODO 加入得到栈顶活动的逻辑
        return mCurrentActivity;
    }

    public static void setmCurrentActivity(Activity mCurrentActivity) {
        //TODO 加入得到栈顶活动的逻辑
        Global.mCurrentActivity = mCurrentActivity;
    }

    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        super.onCreate();
    }


}

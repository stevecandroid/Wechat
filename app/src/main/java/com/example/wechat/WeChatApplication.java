package com.example.wechat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.wechat.Uitls.ActivityHelper;
import com.example.wechat.Uitls.LogHelper;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class WeChatApplication extends Application {

    private static Context mContext;


    public static Activity getmCurrentActivity() {
        //TODO 加入得到栈顶活动的逻辑

        return  ActivityHelper.getTopActivity();
    }
//
//    public static void setmCurrentActivity(Activity mCurrentActivity) {
//        //TODO 加入得到栈顶活动的逻辑
//        WeChatApplication.mCurrentActivity = mCurrentActivity;
//    }

    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        super.onCreate();

        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityHelper.addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityHelper.removeActivity(activity);
            }
        });

    }


}

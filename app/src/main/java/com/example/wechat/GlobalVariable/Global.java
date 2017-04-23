package com.example.wechat.GlobalVariable;

import android.app.Application;
import android.content.Context;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class Global extends Application {

    private static Context context;

    private static Context getContext(){
        return context;
    }











    @Override
    public void onCreate() {
        context = getApplicationContext();
        super.onCreate();
    }


}

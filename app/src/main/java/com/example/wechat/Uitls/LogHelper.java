package com.example.wechat.Uitls;

import android.util.Log;

/**
 * 项目名： Wechat
 * 创建人： 小吉哥哥
 * 创建人： 2017/4/23.
 */

public class LogHelper {
    /**
     * Default Logger(wechat)
     * @param o Object that you want to log
     */
    public static void Log(Object o){
        Log.e("wechat",o.toString());
    }

    /**
     * Custom Logger
     * @param what The key
     * @param o Object that you want to log
     */
    public static void Log(String what,Object o){
        Log.e(what,o.toString());
    }
}

package com.example.wechat.Uitls;

import android.content.Context;
import android.content.Intent;

/**
 * 项目名： Wechat
 * 创建人： 小吉哥哥
 * 创建人： 2017/4/23.
 */

public class IntentHelper {

    /**
     * @param context
     * @param cls
     */
    public static void startActivity(Context context,Class<?> cls) {
        Intent mIntent = new Intent(context,cls);
        context.startActivity(mIntent);
    }
}

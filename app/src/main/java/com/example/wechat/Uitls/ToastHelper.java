package com.example.wechat.Uitls;

import android.app.Activity;
import android.widget.Toast;

import com.example.wechat.GlobalVariable.Global;

/**
 * 项目名： Wechat
 * 创建人： 小吉哥哥
 * 创建人： 2017/4/23.
 */

public class ToastHelper {

    private static Toast mToast;
    private static Object mObject;

    /**
     * ObjectToastHelper
     * @param o Object that you want to toast;
     */
    public static void Toast(Object o){
        if(null == mToast || !o.toString().equals(mObject.toString())){
            if(null == mToast){
                mToast = Toast.makeText(Global.getContext(),o.toString(),Toast.LENGTH_SHORT);
            } else {
                mToast.setText(o.toString());
            }
        }
        mToast.show();

    }
}

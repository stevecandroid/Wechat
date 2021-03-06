package com.example.wechat.Uitls;

import android.widget.Toast;

import com.example.wechat.WeChatApplication;

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
    public static void Toast(final Object o){

        ActivityHelper.getTopActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(null == mToast || !o.toString().equals(mObject.toString())){
                    if(null == mToast){
                        mToast = Toast.makeText(WeChatApplication.getContext(),o.toString(),Toast.LENGTH_SHORT);
                    } else {
                        mToast.setText(o.toString());
                    }
                    mObject = o;
                }
                mToast.show();
            }
        });

    }
}

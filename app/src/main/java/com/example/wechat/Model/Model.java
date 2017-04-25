package com.example.wechat.Model;

import android.content.Context;

import com.example.wechat.Activity.Login_Register.Register;
import com.example.wechat.Uitls.IntentHelper;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobUser;

/**
 * Created by 铖哥 on 2017/4/24.
 */

public class Model {

    public void initBmob(Context context){
        BmobConfig config = new BmobConfig.Builder(context)
                .setApplicationId("0dea943894622b23eafeb624070fa149")
                .setConnectTimeout(15)//默认时间
//                .setUploadBlockSize()//分片上传时每片大小
//                .setFileExpiration(1800) 文件过期时间
                .build();
        Bmob.initialize(config);

    }
    /**
     * 检查最近登录是否有效
     */
    public boolean checkCurrentUser(Context context){
        BmobUser bmobUser = BmobUser.getCurrentUser(context);
        if(bmobUser != null){
            return true;
        }else{
            return false;
        }
    }
}

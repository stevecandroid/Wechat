package com.example.wechat.Table;

import cn.bmob.v3.BmobObject;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class Chat extends BmobObject {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

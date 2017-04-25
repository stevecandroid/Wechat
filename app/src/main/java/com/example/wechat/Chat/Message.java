package com.example.wechat.Chat;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class Message {

    String message;
    String createAt;
    String objectld;
    String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getObjectld() {
        return objectld;
    }

    public void setObjectld(String objectld) {
        this.objectld = objectld;
    }
}

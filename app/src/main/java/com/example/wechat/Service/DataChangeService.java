package com.example.wechat.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;

import com.example.wechat.Chat.Message;
import com.example.wechat.R;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.Uitls.ToastHelper;
import com.example.wechat.WeChatApplication;
import com.google.gson.Gson;

import org.json.JSONObject;

import cn.bmob.v3.BmobRealTimeData;
import cn.bmob.v3.helper.NotificationCompat;
import cn.bmob.v3.listener.ValueEventListener;


/**
 * 项目名： Wechat
 * 创建人： 小吉哥哥
 * 创建人： 2017/4/26.
 *
 * 该服务用于监听Chat变化
 */

public class DataChangeService extends Service{

    private BmobRealTimeData rtd = new BmobRealTimeData();

    @Override
    public void onCreate() {

        //创建Chat表数据变化监听对象
        rtd.start(this, new ValueEventListener() {
            @Override
            public void onConnectCompleted() {
                ToastHelper.Toast("ConnectCompleted");
                rtd.subTableUpdate("Chat");
            }

            @Override
            public void onDataChange(JSONObject jsonObject) {
                Message message ;
                Gson gson = new Gson();
                LogHelper.e(jsonObject.optString("data"));
                message = gson.fromJson(jsonObject.optString("data"), Message.class);
                //广播发message
                sendData(message);
                //通知
                showNotification(message);
            }
        });
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 当Chat表数据变化时调用，将把变化数据用广播发送到需要用到数据的地方
     * @param message
     */
    public void sendData(Message message){
        LogHelper.e(message.getMessage());
        Intent intent = new Intent("dataChange");
        Bundle bundle = new Bundle();
        bundle.putSerializable("message",message);
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }
    public void showNotification(Message message){
        NotificationManager mNotificationManager = (NotificationManager) WeChatApplication
                .getContext().getSystemService(Context.NOTIFICATION_SERVICE);

        Notification mBuilder = new NotificationCompat
                .Builder(WeChatApplication.getContext())
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("from : " +message.getFrom())
                .setContentText(message.getMessage())
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_momo))
                .build();
        mNotificationManager.notify(0,mBuilder);
    }
}

package com.example.wechat.Activity.ChatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wechat.Activity.BaseActvity.BaseActivity;
import com.example.wechat.Activity.Login_Register.Login;
import com.example.wechat.Activity.Login_Register.Register;
import com.example.wechat.Activity.MainActivity.MainActivity;
import com.example.wechat.Chat.Message;
import com.example.wechat.R;
import com.example.wechat.Table.Chat;
import com.example.wechat.Uitls.ActivityHelper;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.LogHelper;
import com.example.wechat.Uitls.ToastHelper;
import com.example.wechat.WeChatApplication;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobRealTimeData;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.ValueEventListener;

/**
 * Created by 铖哥 on 2017/4/24.
 */

public class ChatActivity extends BaseActivity{
    //List<Message> messageList;
    Toolbar toolbar;
    RecyclerView rv_message;
    ChatAdapter chatAdapter;
    DataChangeReceiver dataChangeReceiver = new DataChangeReceiver();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //注册广播接收器
        register();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_box);
        //设置toolbar属性
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentHelper.startActivity(ChatActivity.this, MainActivity.class);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xff212121);
        }

        //messageList = new ArrayList<>();
        rv_message = (RecyclerView) findViewById(R.id.rv_message);

        chatAdapter = new ChatAdapter(WeChatApplication.messageList);
        rv_message.setAdapter(chatAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_message.setLayoutManager(llm);


        final EditText et_message = (EditText) findViewById(R.id.et_message);
        Button bt_send = (Button) findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_message.getText().toString().equals("")){
                    ToastHelper.Toast("不能发送空白内容");
                } else {
                    Chat chat = new Chat();
                    BmobUser bmobUser = BmobUser.getCurrentUser(ChatActivity.this);
                    chat.setMessage(et_message.getText().toString());
                    chat.setFrom(bmobUser.getUsername());
                    chat.save(ChatActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onFailure(int i, String s) {
                            ToastHelper.Toast("failure");
                        }
                    });
                    et_message.setText("");
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(dataChangeReceiver);
        LogHelper.e("destory");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.unregister){
            BmobUser.logOut(this);
            IntentHelper.startActivity(this, Login.class);
            finish();
        }
        return true;

    }

    /**
     * 广播注册
     */
    public void register(){
        //TODO 将其他需要注册的广播写在这里
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("dataChange");
        registerReceiver(dataChangeReceiver,intentFilter);
    }

    class DataChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Message mMessage = (Message) intent.getSerializableExtra("message");
            WeChatApplication.messageList.add(mMessage);
            chatAdapter.notifyItemInserted(WeChatApplication.messageList.size()-1);
            rv_message.scrollToPosition(WeChatApplication.messageList.size()-1);
        }
    }
}

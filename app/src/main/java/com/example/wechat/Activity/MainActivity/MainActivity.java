package com.example.wechat.Activity.MainActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wechat.Activity.BaseActvity.BaseActivity;
import com.example.wechat.Activity.ChatActivity.ChatActivity;
import com.example.wechat.R;
import com.example.wechat.Uitls.IntentHelper;
import com.example.wechat.Uitls.LogHelper;

public class MainActivity extends BaseActivity {

    @Override
    protected void onDestroy() {
        LogHelper.e("Main destory" +
                "");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        LogHelper.e("Main Start" +
                "");
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById( R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentHelper.startActivity(MainActivity.this, ChatActivity.class);
            }
        });
    }
}

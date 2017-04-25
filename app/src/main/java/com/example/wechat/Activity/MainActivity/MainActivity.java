package com.example.wechat.Activity.MainActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wechat.Activity.BaseActivity;
import com.example.wechat.Activity.ChatActivity.ChatActivity;
import com.example.wechat.R;
import com.example.wechat.Uitls.IntentHelper;

public class MainActivity extends BaseActivity {

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

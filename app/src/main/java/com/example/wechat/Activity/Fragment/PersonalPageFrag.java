package com.example.wechat.Activity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wechat.R;
import com.example.wechat.Uitls.ToastHelper;

/**
 * Created by 铖哥 on 2017/4/26.
 */

public class PersonalPageFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_personalpage,container,false);
        LinearLayout  ll_head = (LinearLayout) view.findViewById(R.id.ll_head);
        LinearLayout  ll_nickname = (LinearLayout) view.findViewById(R.id.ll_nickname);
        LinearLayout  ll_sex = (LinearLayout) view.findViewById(R.id.ll_sex);
        LinearLayout  ll_region = (LinearLayout) view.findViewById(R.id.ll_region);
        LinearLayout  ll_signature = (LinearLayout) view.findViewById(R.id.ll_signature);


        ll_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.Toast("llhead");
                //TODO
            }
        });

        ll_nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.Toast("llnick");
                //TODO
            }
        });

        ll_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.Toast("llsex");
                //TODO
            }
        });

        ll_region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.Toast("llregion");
                //TODO
            }
        });

        ll_signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastHelper.Toast("llsign");
                //TODO
            }
        });

        return view;
    }
}

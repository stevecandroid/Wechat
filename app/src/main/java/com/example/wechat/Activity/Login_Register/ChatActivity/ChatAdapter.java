package com.example.wechat.Activity.Login_Register.ChatActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wechat.Chat.Message;
import com.example.wechat.R;
import com.example.wechat.Uitls.ActivityHelper;
import com.example.wechat.WeChatApplication;

import java.util.List;
import java.util.zip.Inflater;

import cn.bmob.v3.BmobUser;

/**
 * Created by 铖哥 on 2017/4/24.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    List<Message> resource;

    public ChatAdapter(List<Message> resource){
        this.resource  = resource;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(resource.get(position).getFrom().equals(BmobUser.getCurrentUser(WeChatApplication.getContext()).getUsername())){
            holder.ll_left.setVisibility(View.GONE);
            holder.ll_right.setVisibility(View.VISIBLE);
            holder.mMessage_send.setText(resource.get(position).getMessage());
        } else {
            holder.ll_left.setVisibility(View.VISIBLE);
            holder.ll_right.setVisibility(View.GONE);
            holder.mMessage_receiver.setText(resource.get(position).getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return resource.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        TextView mMessage_receiver;
        LinearLayout ll_left;
        LinearLayout ll_right;
        TextView mMessage_send;

        public ViewHolder(View itemView) {
            super(itemView);
            mMessage_receiver = (TextView) itemView.findViewById(R.id.tv_message_receiver);
            mMessage_send = (TextView) itemView.findViewById(R.id.tv_send);
            ll_left= (LinearLayout) itemView.findViewById(R.id.ll_left);
            ll_right = (LinearLayout) itemView.findViewById(R.id.ll_right);
        }
    }
}

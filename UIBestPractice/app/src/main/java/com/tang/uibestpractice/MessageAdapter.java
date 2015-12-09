package com.tang.uibestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by tangxin on 15/9/7.
 */
public class MessageAdapter extends ArrayAdapter<Message> {
    private int resourceId;
    public MessageAdapter(Context context, int textviewResourceId, List<Message> objects){
        super(context, textviewResourceId, objects);
        this.resourceId = textviewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        ViewHolder holder;
        Message msg = getItem(position);
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);
            holder.receivedLayout = (LinearLayout)convertView.findViewById(R.id.received_layout);
            holder.sendLayout = (LinearLayout)convertView.findViewById(R.id.send_layout);
            holder.receivedMessage = (TextView)convertView.findViewById(R.id.received_msg);
            holder.sendMessage = (TextView)convertView.findViewById(R.id.send_msg);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        if(msg.getType() == Message.TYPE_RECEIVED){
            holder.sendLayout.setVisibility(View.GONE);
            holder.receivedLayout.setVisibility(View.VISIBLE);
            holder.receivedMessage.setText(msg.getContent());

        }else{
            holder.receivedLayout.setVisibility(View.GONE);
            holder.sendLayout.setVisibility(View.VISIBLE);
            holder.sendMessage.setText(msg.getContent());
        }

        return convertView;
    }
    public class ViewHolder{
        LinearLayout receivedLayout;
        LinearLayout sendLayout;
        TextView receivedMessage;
        TextView sendMessage;
    }
}

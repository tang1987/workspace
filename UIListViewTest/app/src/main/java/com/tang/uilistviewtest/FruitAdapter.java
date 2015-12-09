package com.tang.uilistviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tangxin on 15/9/5.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> fruits){
        super(context, textViewResourceId, fruits);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
       Fruit fruit = getItem(position);
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);
            holder = new ViewHolder();
            holder.fruitImage = (ImageView)convertView.findViewById(R.id.fruitImage);
            holder.fruitText = (TextView)convertView.findViewById(R.id.fruitName);
            convertView.setTag(holder);
            Log.d("getView", convertView.toString());
            Log.d("getView", String.valueOf(position));

        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitText.setText(fruit.getName());
        return convertView;
    }
    public class ViewHolder{
        ImageView fruitImage;
        TextView fruitText;
    }
}

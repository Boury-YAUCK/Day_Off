package com.example.day_off;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String listConge[];
    String desc[];
    int imagesConge[];
    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx, String [] techList,String [] des, int [] techImages){
        this.context = ctx;
        this.listConge = techList;
        this.desc = des;
        this.imagesConge = techImages;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listConge.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textView);
        TextView txtView1 = (TextView) convertView.findViewById(R.id.textView1);
        ImageView techImg = (ImageView) convertView.findViewById(R.id.imageIcon);
        txtView.setText(listConge[position]);
        txtView1.setText(desc[position]);
        techImg.setImageResource(imagesConge[position]);

        return convertView;

    }
}

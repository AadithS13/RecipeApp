package com.aadithsuresh10.recipeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Recipes extends BaseAdapter{

    Context context;
    String[] reci;
    int[] image;

    LayoutInflater inflator;

    public Recipes(Context context, String[] reci, int[] image) {
        this.context = context;
        this.reci = reci;
        this.image = image;
    }

    @Override
    public int getCount() {
        return reci.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       if(inflator == null)
       {
           inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       }

       if(view == null)
       {
           view = inflator.inflate(R.layout.grid_item,null);

       }

        ImageView imageview = view.findViewById(R.id.i1);
        TextView textView = view.findViewById(R.id.t1);

        imageview.setImageResource(image[i]);
        textView.setText(reci[i]);
        return view;
    }



}

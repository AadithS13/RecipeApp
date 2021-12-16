package com.aadithsuresh10.recipeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyadapterP2 extends PagerAdapter {

    Context c;
    MyadapterP2(Context c)
    {
        this.c=c;
    }
    private int[] images3={R.drawable.pp3,R.drawable.pp4};
    @Override
    public int getCount() {
        return images3.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return(view==object);
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(images3[position]);
        container.addView(view);
        return view;
    }
}

package com.aadithsuresh10.recipeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyadapterP3 extends PagerAdapter {
    Context c;
    MyadapterP3(Context c)
    {
        this.c=c;
    }
    private int[] images4={R.drawable.pp5,R.drawable.pp6};
    @Override
    public int getCount() {
        return images4.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(images4[position]);
        container.addView(view);
        return view;
    }
}

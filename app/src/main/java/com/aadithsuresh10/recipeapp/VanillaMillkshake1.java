package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

public class VanillaMillkshake1 extends AppCompatActivity {

    ViewFlipper v_flipper;
    ViewPager vp,vp2,vp3;
    MyadapterM1 myadapter;
    MyadapterM2 myadapter2;
    MyadapterM3 myadapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vanilla_millkshake1);

        int images[]={R.drawable.pb8,R.drawable.pb7};

        v_flipper=findViewById(R.id.flipper);
        myadapter=new MyadapterM1(this);
        myadapter2=new MyadapterM2(this);
        myadapter3=new MyadapterM3(this);
        for(int image:images) {
            flipperImages(image);
        }

        vp=findViewById(R.id.mypager);
        vp.setAdapter(myadapter);

        vp2=findViewById(R.id.mypager2);
        vp2.setAdapter(myadapter2);

        vp3=findViewById(R.id.mypager3);
        vp3.setAdapter(myadapter3);

    }

    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000);//time
        v_flipper.setAutoStart(true);

        //animation

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }


}

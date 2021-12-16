package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.aadithsuresh10.recipeapp.databinding.ActivityMain2Binding;
import com.aadithsuresh10.recipeapp.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] reci = {"Veg","Chicken","Egg","Milkshakes","Sweets"};
        int[] image = {R.drawable.veg,R.drawable.nveg,R.drawable.egg,R.drawable.ms,R.drawable.sweets};

        Recipes gradeadapter = new Recipes(MainActivity2.this,reci,image);
        binding.gv1.setAdapter(gradeadapter);

        binding.gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity2.this,"You Clicked on " + reci[i],Toast.LENGTH_SHORT).show();
                Intent intent = null;
                if(i==0)
                {
                    intent = new Intent(getApplicationContext(), VegDishes.class);
                    startActivity(intent);
                }
                else if(i==1)
                {
                    intent = new Intent(getApplicationContext(), Nveg.class);
                    startActivity(intent);
                }
                else if(i==2)
                {
                    intent = new Intent(getApplicationContext(), EggDishes.class);
                    startActivity(intent);
                }
                else if(i==3)
                {
                    intent = new Intent(getApplicationContext(), Milkshakes.class);
                    startActivity(intent);
                }
                else if(i==4)
                {
                    intent = new Intent(getApplicationContext(), Sweets.class);
                    startActivity(intent);
                }



            }
        });
    }
}
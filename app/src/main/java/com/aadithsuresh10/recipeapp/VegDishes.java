package com.aadithsuresh10.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import com.aadithsuresh10.recipeapp.databinding.ActivityMainBinding;
import com.aadithsuresh10.recipeapp.databinding.ActivityVegDishesBinding;

public class VegDishes extends AppCompatActivity {

    ActivityVegDishesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_dishes);



        binding = ActivityVegDishesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] reci = {"Paneer Biriyani","Dal Makhani","Gobhi Manchurian",
                "Kadai Paneer","Paneer Butter Masala","Aloo Kulcha","Matar Paneer","Paneer Tikka","Fried Rice","Vegetable Noodles"};
        int[] image = {R.drawable.pb,R.drawable.dm,R.drawable.gm,R.drawable.kp,
                R.drawable.pbm,R.drawable.aloo_kulcha,R.drawable.matar_paneer,R.drawable.paneer_tikka,R.drawable.vfr,R.drawable.veg_noodles};

        Recipes gradeadapter = new Recipes(VegDishes.this,reci,image);
        binding.gv2.setAdapter(gradeadapter);



        binding.gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(VegDishes.this,"You Clicked on " + reci[i],Toast.LENGTH_SHORT).show();
                Intent intent = null;
                if(i==0)
                {
                    intent = new Intent(getApplicationContext(), PaneerBiriyani1.class);
                    startActivity(intent);
                }
                if(i==1)
                {
                    intent = new Intent(getApplicationContext(), DalMakhani.class);
                    startActivity(intent);
                }
                if(i==2)
                {
                    intent = new Intent(getApplicationContext(), GobiManchurian.class);
                    startActivity(intent);
                }
                if(i==4)
                {
                    intent = new Intent(getApplicationContext(), PaneerButterMasala.class);
                    startActivity(intent);
                }



            }
        });







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {  int item_id = item.getItemId();
        if(item_id == R.id.contactUs)
        {

            Intent intent1 = new Intent(getApplicationContext(),ContactUS.class);
            startActivity(intent1);
        }

        else if(item_id == R.id.logout)
        {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(VegDishes.this);
            alertDialog.setTitle("Confirm Delete"); // Setting Dialog Title
            alertDialog.setMessage("Are you sure you want delete this?");// Setting Dialog Message
            alertDialog.setIcon(R.drawable.ic_baseline_delete_24);// Setting Icon to Dialog
            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on YES : " , Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent1);
                }
            });
            alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getApplicationContext(), "Good choice..." , Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on Cancel : " , Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();
        }
        else if(item_id == R.id.home)
        {

            Intent intent1 = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(intent1);
        }
        else if(item_id == R.id.aboutUs)
        {

            Intent intent1 = new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent1);
        }

        else if(item_id == R.id.settings)
        {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
        else if(item_id == R.id.changeTheme)
        {
            String cur = "n";

            if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
            {
                cur = "y";
            }
            else
            {
                cur = "n";
            }

            if(cur == "y")
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                restartApp();
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                restartApp();
            }
        }
        return super.onOptionsItemSelected(item);

    }

    public void restartApp()
    {
        Intent i = new Intent(getApplicationContext(),VegDishes.class);
        startActivity(i);
        finish();
    }


}
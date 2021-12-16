package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.aadithsuresh10.recipeapp.databinding.ActivityEggDishesBinding;
import com.aadithsuresh10.recipeapp.databinding.ActivityNvegBinding;

public class EggDishes extends AppCompatActivity {
    ActivityEggDishesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_dishes);

        binding = ActivityEggDishesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] reci = {"Egg Curry","Egg Roast","Omlette","Fried Rice","Egg Burji","Egg Roll"};
        int[] image = {R.drawable.ec,R.drawable.er,R.drawable.omelette,R.drawable.egg_fried_rice,R.drawable.egg_burji,R.drawable.eggroll};

        Recipes gradeadapter = new Recipes(EggDishes.this,reci,image);
        binding.gv3.setAdapter(gradeadapter);

        binding.gv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(EggDishes.this,"You Clicked on " + reci[i],Toast.LENGTH_SHORT).show();
                Intent intent = null;
                if(i==0)
                {
                    intent = new Intent(getApplicationContext(), Eggcurry1.class);
                    startActivity(intent);
                }
                if(i==1)
                {
                    intent = new Intent(getApplicationContext(), EggRoast.class);
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

        else if(item_id == R.id.logout)
        {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(EggDishes.this);
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
            else if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
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
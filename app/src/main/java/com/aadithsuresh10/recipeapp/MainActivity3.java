package com.aadithsuresh10.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<FoodData> myFoodList;
    FoodData mFoodData;
    String user,pass;
    Toolbar toolbar;
    String globuser = "Aadith";
    String globpass = "1313";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity3.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myFoodList = new ArrayList<>();
        mFoodData = new FoodData("Sweets","For sweet tooth.","",R.drawable.sweets);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Veg","Highly Nutritious","",R.drawable.veg);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Egg","High in Calcium","",R.drawable.egg);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Non Veg","High Protein","",R.drawable.nveg);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Milkshakes","Take a break","",R.drawable.ms);

        myFoodList.add(mFoodData);

        MyAdapter myAdapter = new MyAdapter(MainActivity3.this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        if(item_id == R.id.account)
        {

                Bundle bundle = getIntent().getExtras();
                if(bundle != null)
                {
                    String usernow = bundle.getString("key");
                    String passnow = bundle.getString("key1");
                    globuser = usernow;
                    globpass = passnow;
                    Intent intent = new Intent(getApplicationContext(),UserAccount.class);
                    intent.putExtra("key",usernow);
                    intent.putExtra("key1",passnow);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),UserAccount.class);
                    intent.putExtra("key",globuser);
                    intent.putExtra("key1",globpass);
                    startActivity(intent);
                }

        }

        else if(item_id == R.id.contactUs)
        {

            Intent intent1 = new Intent(getApplicationContext(),ContactUS.class);
            startActivity(intent1);
        }

        else if(item_id == R.id.logout)
        {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity3.this);
            alertDialog.setTitle("Confirm Log Out"); // Setting Dialog Title
            alertDialog.setMessage("Are you sure you want to log out ?");// Setting Dialog Message
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
        else if(item_id == R.id.aboutUs)
        {

            Intent intent1 = new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent1);
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
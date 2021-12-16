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
import android.widget.RatingBar;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {
    RatingBar rat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        rat = (RatingBar)findViewById(R.id.ratingBar) ;

        rat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v == 5)
                {
                    Toast.makeText(AboutUs.this,"Thank You !! Good to hear that you loved our app",Toast.LENGTH_SHORT).show();
                }
                if(v == 4)
                {
                    Toast.makeText(AboutUs.this,"Thank You !! Good to hear that you like our app",Toast.LENGTH_SHORT).show();
                }
                if(v == 3){
                    Toast.makeText(AboutUs.this, "Thank you for rating our app ! We will surely try our best to improve", Toast.LENGTH_LONG).show();
                }
                if(v == 2)
                {
                    Toast.makeText(AboutUs.this, "Thank you for rating our app ! We are sorry to see that you did not like our app , please email us regarding any issues . We will definitely rectify it", Toast.LENGTH_LONG).show();
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

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(AboutUs.this);
            alertDialog.setTitle("Confirm Log Out"); // Setting Dialog Title
            alertDialog.setMessage("Are you sure you want to Log Out?");// Setting Dialog Message
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
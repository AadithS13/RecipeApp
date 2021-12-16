package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUS extends AppCompatActivity {

    TextView tv123,tv2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        tv123=findViewById(R.id.tv_call);
        tv2=findViewById(R.id.tv2);

        tv123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876343429"));
                startActivity(intent);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email= new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:your.email@gmail.com"));
                email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                email.putExtra(Intent.EXTRA_TEXT, "My Email message");
                startActivity(email);
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

            Intent intent1 = new Intent(getApplicationContext(),Login.class);
            startActivity(intent1);
        }
        else if(item_id == R.id.home)
        {

            Intent intent1 = new Intent(getApplicationContext(),MainActivity3.class);
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
package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EggRoast extends AppCompatActivity {
    Button btn,btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_roast);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btn = (Button) findViewById(R.id.button);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.btnsend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876343429"));
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed1 = (EditText) findViewById(R.id.etdoubt);
                if(ed1.getText().toString().length() == 0)
                {
                    ed1.setError("Please fill the message box");
                }
                else {
                    Toast.makeText(EggRoast.this, "We have receive your query , our chef will get back to you ASAP !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
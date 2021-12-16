package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btn,btn3,btn4;
    DBHelper DB;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText e1 = (EditText) findViewById(R.id.inputEmail1);
        EditText e2 = (EditText) findViewById(R.id.inputPassword1);
        DB = new DBHelper(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        TextView btn1=findViewById(R.id.textViewSignUp);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,MainActivity1.class));
            }
        });

        TextView btn2=findViewById(R.id.forgotPassword);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this,ForgotPassword.class));
            }
        });



        btn = findViewById(R.id.btnlogin);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {

                                       String user = e1.getText().toString();
                                       String pass = e2.getText().toString();
                                       if (e1.getText().toString().length() == 0) {
                                           e1.setError("Email is required!");
                                       } else if (e2.getText().toString().length() == 0) {
                                           e2.setError("Password is required!");
                                       } else {
                                           Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                                           if (checkuserpass == true) {
                                               Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                                               intent.putExtra("key",user);
                                               intent.putExtra("key1",pass);
                                               Toast.makeText(Login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                                               startActivity(intent);
                                           } else {
                                               e2.setError("Invalid Credentials");
                                           }


                                       }
                                   }
                               });

        btn2 = findViewById(R.id.btnGoogle);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this,"Sorry our website is under maintanence!",Toast.LENGTH_SHORT).show();
            }
        });
        btn3 = findViewById(R.id.btnFacebook);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this,"We are creating our facebook page,we will notify you as soon as it is ready.",Toast.LENGTH_SHORT).show();
            }
        });

       

    }
}
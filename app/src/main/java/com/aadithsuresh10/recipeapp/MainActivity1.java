package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
    Button btn;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btn = findViewById(R.id.btnRegister);
        DB = new DBHelper(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        TextView btn1=findViewById(R.id.alreadyHaveAccount);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity1.this,Login.class));
            }
        });



        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                EditText ed1 = (EditText)findViewById(R.id.inputEmail);
                EditText ed2 = (EditText)findViewById(R.id.inputPassword);
                EditText ed3 = (EditText)findViewById(R.id.inputUsername);
                EditText ed4 = (EditText)findViewById(R.id.inputConformPassword);
                EditText ed5 = (EditText)findViewById(R.id.inputMobile) ;
                String pass_name = ed2.getText().toString();
                String c_pass = ed4.getText().toString();
                String user = ed3.getText().toString();
                String email = ed1.getText().toString();
                String mobile = ed5.getText().toString();
                if( ed3.getText().toString().length() == 0   ) {
                    ed3.setError("Username is required!");
                }
                else if( ed1.getText().toString().length() == 0   ) {
                    ed1.setError("Email is required!");
                }
                else if( ed5.getText().toString().length() == 0   ) {
                    ed1.setError("Mobile Number is required!");
                }
                else if(ed2.getText().toString().length() == 0)
                {
                    ed2.setError("Password is required!");
                }
                else if(ed4.getText().toString().length() == 0)
                {
                    ed4.setError("Confirm Password is required!");
                }
                else if (!pass_name.equals(c_pass))
                {
                    ed4.setError("Confirm Password not same as password!");
                }
                else
                    {
                    Toast.makeText(MainActivity1.this, "You have succesfully registered ! \n Welcome to Food Recipe App", Toast.LENGTH_SHORT).show();

                        if(pass_name.equals(c_pass)){
                            Boolean checkuser = DB.checkusername(user);
                            if(checkuser==false){
                                Boolean insert = DB.insertData(user, pass_name, email,mobile);
                                if(insert==true){
                                    Toast.makeText(MainActivity1.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MainActivity1.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity1.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity1.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                        }
                    } }
                });




            }
        }


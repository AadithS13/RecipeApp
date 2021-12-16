package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        e1 = findViewById(R.id.inputEmail12);
        e2 = findViewById(R.id.inputPassword12);
        e3 = findViewById(R.id.inputConfirmPassword);
        b1 = findViewById(R.id.btnChange);
        DB = new DBHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mob = getIntent().getStringExtra("key");
                String user = e1.getText().toString();
                String pass = e2.getText().toString();
                String conpass = e3.getText().toString();
                if (e1.getText().toString().length() == 0)
                {
                    e1.setError("Email is required!");
                }
                else if (e2.getText().toString().length() == 0)
                {
                    e2.setError("Password is required!");
                }
                else if (e3.getText().toString().length() == 0)
                {
                    e3.setError("Password is required!");
                }

                else
                    {
                    Boolean changepass = DB.changePassword(user, pass,mob);

                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        Toast.makeText(ChangePassword.this, "Username/Password changed successfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);



                }
            }
        });

    }
}
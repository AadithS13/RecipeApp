package com.aadithsuresh10.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    Button btnotp1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        DB = new DBHelper(this);
        btnotp1 = findViewById(R.id.btnotp);

        btnotp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e1 = (EditText)findViewById(R.id.inputmobile234);
                if (e1.getText().toString().length() == 0)
                {
                    e1.setError("Mobile number is required!");
                }
                else
                {
                    String mob = e1.getText().toString();
                    Boolean send = DB.sendOTP(mob);
                    if (send == true)
                    {
                        Toast.makeText(ForgotPassword.this, "OTP Sent", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ReadOTP.class);
                        intent.putExtra("phoneNo",mob);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(ForgotPassword.this, "This mobile number is not registered. Please register first.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity1.class);
                        startActivity(intent);
                    }
                }

            }
        });

    }
}
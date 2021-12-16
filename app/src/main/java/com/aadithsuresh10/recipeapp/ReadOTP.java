package com.aadithsuresh10.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class ReadOTP extends AppCompatActivity {
    String verificationCodeBySystem;
    Button verify;
    EditText readOTP;
    ProgressBar pb;
    String Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_otp);
        verify = findViewById(R.id.btnverifyotp);
        readOTP = findViewById(R.id.inputOTP);
        pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.GONE);

        String phoneNo = getIntent().getStringExtra("phoneNo");
        Phone = phoneNo;

        sendVerificationCodeToUser(phoneNo);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = readOTP.getText().toString();

                if(code.isEmpty() || code.length() < 6)
                {
                    readOTP.setError("Wrong OTP ...");
                    readOTP.requestFocus();
                    return;
                }
                pb.setVisibility(View.VISIBLE);
                verifyCode(code);
            }
        });

    }

    private void sendVerificationCodeToUser(String phoneNo) {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                        .setPhoneNumber("+91" + phoneNo)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationCodeBySystem = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {



            String code = phoneAuthCredential.getSmsCode();
            if(code != null)
            {
                pb.setVisibility(View.VISIBLE);
                verifyCode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(ReadOTP.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };

    private void verifyCode(String verificationCode)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCodeBySystem,verificationCode);
        signInTheUserByCredentials(credential);
    }

    private void signInTheUserByCredentials(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(ReadOTP.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(ReadOTP.this,"OTP read successfully",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),ChangePassword.class);
                    intent.putExtra("key",Phone);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ReadOTP.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
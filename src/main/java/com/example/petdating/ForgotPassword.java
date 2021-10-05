package com.example.petdating;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    EditText send_email;
    Button btn_reset;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Password Reset");
        progressDialog.setMessage("Resetting your password Please Wait");

        send_email = findViewById(R.id.send_email);
        btn_reset = findViewById(R.id.btn_reset);

        btn_reset.setOnClickListener(view -> {
            final String email = send_email.getText().toString();
            if (email.equals("")) {
                Toast.makeText(ForgotPassword.this, "Please enter email address", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.show();
                new Handler().postDelayed(() -> {
                    progressDialog.dismiss();
                    Intent i = new Intent(ForgotPassword.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }, 3000);
            }
        });


    }
}

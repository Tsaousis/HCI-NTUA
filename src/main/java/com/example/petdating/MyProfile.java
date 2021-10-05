package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

public class MyProfile extends AppCompatActivity {

    Button update;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        update = findViewById(R.id.update);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        update.setOnClickListener(view -> {
            Toast.makeText(MyProfile.this, "Profile Updated Sucessfully", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(this::finish, 2000);
        });
    }
}
package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    CardView cvAdopt, cvMate;
    ImageView chat, profile;
    ImageView notfication;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        notfication = findViewById(R.id.notification);
        notfication.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Notifications.class)));

        cvAdopt = findViewById(R.id.cvAdopt);
        cvMate = findViewById(R.id.cvmate);
        chat = findViewById(R.id.chat);
        profile = findViewById(R.id.friend);

        profile.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MyProfile.class)));

        chat.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ActivityChatHome.class)));

        cvMate.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MateHomePage.class)));

        cvAdopt.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AdoptionHome.class));
        });

    }
}
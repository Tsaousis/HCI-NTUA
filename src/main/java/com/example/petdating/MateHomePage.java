package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MateHomePage extends AppCompatActivity {
    TextView add, filter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mate_home_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Mate Home");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        add = findViewById(R.id.add);
        filter = findViewById(R.id.filter);

        add.setOnClickListener(view -> startActivity(new Intent(MateHomePage.this, MyPets.class)));
        filter.setOnClickListener(view -> startActivity(new Intent(MateHomePage.this, AdoptionFilter.class)));
    }
}
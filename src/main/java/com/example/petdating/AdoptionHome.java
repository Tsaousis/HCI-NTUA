package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdoptionHome extends AppCompatActivity {
    TextView tvAdd, tvFilter;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Adoption Home");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvAdd = findViewById(R.id.add);
        tvFilter = findViewById(R.id.filter);

        tvAdd.setOnClickListener(view -> startActivity(new Intent(AdoptionHome.this, AdoptionAdd.class)));
        tvFilter.setOnClickListener(view -> startActivity(new Intent(AdoptionHome.this, AdoptionFilter.class)));
    }
}
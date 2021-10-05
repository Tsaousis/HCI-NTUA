package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

public class AdoptionAdd extends AppCompatActivity {

    Button btnAdd, btnContact;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Adoption Add");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        btnAdd = findViewById(R.id.btnadd);
        btnContact = findViewById(R.id.btncontact);
        btnAdd.setOnClickListener(view -> {
            Toast.makeText(AdoptionAdd.this, "Friend Request Sent", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(this::finish, 2000);
        });

        btnContact.setOnClickListener(view -> {
            startActivity(new Intent(AdoptionAdd.this, ActivityContact.class));
        });

    }
}
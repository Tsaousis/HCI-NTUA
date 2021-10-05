package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyPets extends AppCompatActivity {

    CardView cv1, cv2, cv3;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Pets");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);

        cv1.setOnClickListener(view -> {
            Intent intent = new Intent(MyPets.this, EditPets.class);
            intent.putExtra("img", "dog1");
            startActivity(intent);
        });

        cv2.setOnClickListener(view -> {
            Intent intent = new Intent(MyPets.this, EditPets.class);
            intent.putExtra("img", "dog2");
            startActivity(intent);
        });

        cv3.setOnClickListener(view -> {
            Intent intent = new Intent(MyPets.this, EditPets.class);
            intent.putExtra("img", "dog3");
            startActivity(intent);
        });

    }
}
package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditPets extends AppCompatActivity {
    String type;
    ImageView image;
    Button btnSave;
    TextView heading;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pets);

        type = getIntent().getStringExtra("img");
        heading = findViewById(R.id.heading);

        btnSave = findViewById(R.id.btnSave);
        image = findViewById(R.id.imgage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Pets Edit");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (type.equalsIgnoreCase("dog1")) {
            image.setImageResource(R.drawable.dog1);
            heading.setText("Dog 1");

        } else if (type.equalsIgnoreCase("dog2")) {
            image.setImageResource(R.drawable.dog2);
            heading.setText("Dog 2");
        } else if (type.equalsIgnoreCase("dog3")) {
            image.setImageResource(R.drawable.dog3);
            heading.setText("Dog 3");
        }

        btnSave.setOnClickListener(view -> {
            Toast.makeText(EditPets.this, "Changes Saved", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(this::finish, 2000);
        });

    }
}
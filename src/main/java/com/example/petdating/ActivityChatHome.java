package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class ActivityChatHome extends AppCompatActivity {

    RelativeLayout r1, r2, r3, r4, r5;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Chat ");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        r1 = findViewById(R.id.chat1);
        r2 = findViewById(R.id.chat2);
        r3 = findViewById(R.id.chat3);
        r4 = findViewById(R.id.chat4);
        r5 = findViewById(R.id.chat5);

        r1.setOnClickListener(view -> startActivity(new Intent(ActivityChatHome.this, ActivityChat.class)));
        r2.setOnClickListener(view -> startActivity(new Intent(ActivityChatHome.this, ActivityChat.class)));
        r3.setOnClickListener(view -> startActivity(new Intent(ActivityChatHome.this, ActivityChat.class)));
        r4.setOnClickListener(view -> startActivity(new Intent(ActivityChatHome.this, ActivityChat.class)));
        r5.setOnClickListener(view -> startActivity(new Intent(ActivityChatHome.this, ActivityChat.class)));
    }
}
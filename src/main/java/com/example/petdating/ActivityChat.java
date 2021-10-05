package com.example.petdating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class ActivityChat extends AppCompatActivity {

    EmojiconEditText txtSend;
    ImageButton btnSend;
    ImageView emojiButton;
    View rootView;
    EmojIconActions emojiIcon;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dog 1");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        rootView = findViewById(R.id.rootView);
        txtSend = findViewById(R.id.txt_send);
        btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(view -> txtSend.setText(""));
        emojiButton = findViewById(R.id.emoji_btn);

        emojiIcon = new EmojIconActions(ActivityChat.this, rootView, txtSend, emojiButton);
        emojiIcon.ShowEmojIcon();
        emojiIcon.setIconsIds(R.drawable.keyboard, R.drawable.smileeey);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.phonecall:
                Toast.makeText(ActivityChat.this, "Person Not Reachable", Toast.LENGTH_LONG).show();
                break;
            case R.id.video_call:
                Toast.makeText(ActivityChat.this, "Person Not Reachable", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
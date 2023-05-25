package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;

public class Extra extends AppCompatActivity {
    Bonsai tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        getSupportActionBar().setTitle(getIntent().getStringExtra("size"));

        TextView size = findViewById(R.id.height);
        size.setText("150 cm");

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
           tree = (Bonsai) getIntent().getSerializableExtra("size");
           size.setText(tree.getHeight());
        }
    }
}


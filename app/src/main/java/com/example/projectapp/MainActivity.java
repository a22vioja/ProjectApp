package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonExplore= findViewById(R.id.buttonExplore);

        buttonExplore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // makes the button in MainActivity page open About page screen
                Intent intent = new Intent(MainActivity.this, BonsaiPage.class);
                startActivity(intent);

            }
        });
        Button buttonAbout= findViewById(R.id.buttonAbout);
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // makes the button in MainActivity page open About page screen
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }
}
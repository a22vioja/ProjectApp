package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.gson.Gson;

public class Extra extends AppCompatActivity {
    Bonsai tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        TextView size = findViewById(R.id.height);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           // Log.d("violeta", "height"+String.valueOf(tree.getHeight()));
            String jsonString = extras.getString("json");
            if (jsonString != null) {
                Gson gson = new Gson();
                tree = gson.fromJson(jsonString, Bonsai.class);
                size.setText(String.valueOf(tree.getHeight()));
              //  Log.d("violeta", "size"+String.valueOf(size.getText()));

            }
        }
    }
}


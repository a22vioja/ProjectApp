package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import com.example.projectapp.Bonsai;

public class BonsaiPage extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22vioja";
    ArrayList<Bonsai> listOfBonsai;
   // private RecyclerView.ViewHolder holder;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonsai_page);

        listOfBonsai = new ArrayList<Bonsai>();

        adapter=new MyAdapter(this, listOfBonsai, new MyAdapter.OnClickListener() {
            @Override
            public void onClick(Bonsai item) {
                Toast.makeText(BonsaiPage.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        new JsonTask(this).execute(JSON_URL);

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Bonsai>>() {}.getType();

        adapter.addData(listOfBonsai);

        ArrayList<Bonsai> listOfBonsai = gson.fromJson(json, type);
        if (listOfBonsai != null) {
            adapter.addData(listOfBonsai);
            adapter.notifyDataSetChanged();
        } else {
            Log.d("BonsaiPage", "Error: Empty list of Bonsai"); // Provide a relevant error message
        }

        adapter.notifyDataSetChanged();

    }
}
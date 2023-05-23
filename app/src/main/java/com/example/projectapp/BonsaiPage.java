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
import java.util.Arrays;

import com.example.projectapp.Bonsai;

public class BonsaiPage extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22vioja";

    ArrayList<Bonsai> listOfBonsai;
    private RecyclerView.ViewHolder holder;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonsai_page);

        listOfBonsai = new ArrayList<Bonsai>();

       /* ArrayList<Bonsai> items = new ArrayList<>(Arrays.asList(
                new Bonsai("Norvegian","Bonsai1", "20", 2000,"a22vioja", "s", "img_1882" )
        ));*/

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
        //listOfBonsai = gson.fromJson(json, type);
        adapter.addData(listOfBonsai);

        String jsonlOG = gson.toJson(listOfBonsai);
        /*ArrayList<Bonsai>*/ listOfBonsai = gson.fromJson(json, type);
        Log.d("BonsaiPage", "jsonLOG: " + jsonlOG);
        if (listOfBonsai != null) {
            adapter.addData(listOfBonsai);
         //   adapter.notifyDataSetChanged();
            Log.d("BonsaiPage", "listOfBonsai" + listOfBonsai.size());
        } else {
            Log.d("BonsaiPage", "Error: Empty list of Bonsai"); // Provide a relevant error message
        }

        adapter.notifyDataSetChanged();

    }
}
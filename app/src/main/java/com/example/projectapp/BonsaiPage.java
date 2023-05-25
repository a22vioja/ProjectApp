package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.projectapp.Bonsai;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        adapter = new MyAdapter(this, listOfBonsai, new MyAdapter.OnClickListener() {
            @Override
            public void onClick(Bonsai item) {
                Toast.makeText(BonsaiPage.this, item.getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BonsaiPage.this, Extra.class);
                startActivity(intent);
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
        ArrayList<Bonsai> listOfBonsai = gson.fromJson(json, type);
        Log.d("BonsaiPage", "jsonLOG: " + jsonlOG);
        if (listOfBonsai != null) {
            adapter.addData(listOfBonsai);
         //   adapter.notifyDataSetChanged();
            Log.d("BonsaiPage", "listOfBonsai" + listOfBonsai.size());
        } else {
            Log.d("BonsaiPage", "Error: Empty list of Bonsai"); // Provide a relevant error message
        }

        adapter.notifyDataSetChanged();


        // När vi har ett JSONObjekt kan vi hämta ut dess beståndsdelar
      /* try {
            JSONArray a = new JSONArray(json);

            for(int i=0; i<a.length(); i++ ){
                // Ditt JSON-objekt som Java
                JSONObject bonsaiJson = a.getJSONObject(i);
                String name = bonsaiJson.getString("name");
                int price = bonsaiJson.getInt("cost");
                String size = bonsaiJson.getString("name");
                String name = bonsaiJson.getString("name");
                String name = bonsaiJson.getString("name");
                String name = bonsaiJson.getString("name");
                Bonsai b = new Bonsai(name, price);
                listOfBonsai.add(b);
                Log.d("violeta", "c" + b.getName());
            }

            adapter.addData(listOfBonsai);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }*/


    }
}
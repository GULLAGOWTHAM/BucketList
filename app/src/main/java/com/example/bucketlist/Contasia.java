package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Contasia extends AppCompatActivity {

    int[] asia={R.drawable.asiamussorie,R.drawable.asiamaldives,R.drawable.asiaferrari,R.drawable.asiahalong,R.drawable.asiaranthambore,R.drawable.asiakunchikal,R.drawable.asiatandem,R.drawable.asiabungee,R.drawable.asiajewel,R.drawable.asiaryuzu,R.drawable.asiauniversal};//animal images array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contasia);

        continentsadapter Owncontinentsadapter = new continentsadapter(asia);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewAsia);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Owncontinentsadapter);

    }
}
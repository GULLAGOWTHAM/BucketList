package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ContEurope extends AppCompatActivity {
    int[] europe={R.drawable.europeairtime,R.drawable.europegrawa,R.drawable.europeseven,R.drawable.europesnow,R.drawable.europetromso,R.drawable.europeeuropa,R.drawable.europemykonos};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_europe);

        continentsadapter Owncontinentsadapter = new continentsadapter(europe);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewEurope);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Owncontinentsadapter);

    }
}
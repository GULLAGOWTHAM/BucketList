package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ContNorth extends AppCompatActivity {
    int[] north={R.drawable.northcanmore,R.drawable.northniagara,R.drawable.celebritysafariwest,R.drawable.northbluehole,R.drawable.northzipline,R.drawable.northdisney,R.drawable.northgrace};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_north);

        continentsadapter Owncontinentsadapter = new continentsadapter(north);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewNorth);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Owncontinentsadapter);

    }
}
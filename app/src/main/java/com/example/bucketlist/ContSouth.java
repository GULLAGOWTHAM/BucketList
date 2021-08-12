package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ContSouth extends AppCompatActivity {
    int[] south={R.drawable.southmachu,R.drawable.southdevils,R.drawable.southcarrero};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_south);

        continentsadapter Owncontinentsadapter = new continentsadapter(south);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewSouth);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Owncontinentsadapter);

    }
}
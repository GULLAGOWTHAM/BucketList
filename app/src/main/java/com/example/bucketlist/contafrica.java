package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class contafrica extends AppCompatActivity {
int africa[]={R.drawable.africadevils,R.drawable.africaserengeti,R.drawable.africavictoria,R.drawable.africagoldreef,R.drawable.africamaasai};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contafrica);

        continentsadapter Owncontinentsadapter = new continentsadapter(africa);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewAfrica);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Owncontinentsadapter);

    }
}
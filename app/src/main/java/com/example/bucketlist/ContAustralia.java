package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ContAustralia extends AppCompatActivity {
    int[] australia={R.drawable.austhrebdo,R.drawable.auswallaman,R.drawable.auswarnerbros,R.drawable.aushotair,R.drawable.auskangaroo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_australia);

        continentsadapter Owncontinentsadapter = new continentsadapter(australia);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewAustralia);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(Owncontinentsadapter);

    }
}
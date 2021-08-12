package com.example.bucketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Safari  extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safari);
        Button button = (Button) findViewById(R.id.arrows);
        button.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        super.onBackPressed();
    }
}
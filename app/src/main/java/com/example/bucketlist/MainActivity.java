package com.example.bucketlist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager2 imageContainer;
    sliderAdaptor adapter;
    int[] list;
    TextView[] dots;
    LinearLayout layout;
    Class fragmentClass;
    public static Fragment fragment;
    private DrawerLayout drawerLayout;
    private String[] from = {"image"};
    private int[] to = {R.id.singleimg};

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//////

        //CATEGORIES//

///////

        RecyclerView recyclerView= findViewById(R.id.categoriesRecyclerView);
        int[] imgs={R.drawable.hillstations,R.drawable.waterfalls,R.drawable.parks,R.drawable.relaxation,R.drawable.safari,R.drawable.adventures};
        categoriesadapter categoriesAdapters = new categoriesadapter(imgs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(categoriesAdapters);
        categoriesAdapters.setOnItemClickListerner(new categoriesadapter.onItemCLickListener() {
            @Override
            public void onitemclick(int position) {
                switch(position){
                    case 0 : startActivity(new Intent(MainActivity.this, Hillstations.class));
                         break;
                    case 1 : startActivity(new Intent(MainActivity.this, waterfalls.class));
                         break;
                    case 2 : startActivity(new Intent(MainActivity.this, Parks.class));
                         break;
                    case 3 : startActivity(new Intent(MainActivity.this, Relaxation.class));
                         break;
                    case 4 : startActivity(new Intent(MainActivity.this, Safari.class));
                        break;
                    case 5 : startActivity(new Intent(MainActivity.this, Adventure.class));
                        break;
                }

            }
        });

        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        toggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menubar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout.addDrawerListener(toggle);


//////

        //PLACES//

///////
        RecyclerView recyclerView2= findViewById(R.id.placesrecyclerview);
        int[] img={R.drawable.asia,R.drawable.africa,R.drawable.northamerica,R.drawable.southamerica,R.drawable.europe,R.drawable.australia};
        Placesadapter placessAdapter = new Placesadapter(img);
        LinearLayoutManager linearLayoutManage = new LinearLayoutManager(this);
        linearLayoutManage.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayoutManage);
        recyclerView2.setAdapter(placessAdapter);
        placessAdapter.setOnItemClickListener(new Placesadapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position){
                    case 0: startActivity(new Intent(MainActivity.this, Contasia.class));
                     break;
                    case 1: startActivity(new Intent(MainActivity.this,contafrica.class));
                    break;
                    case 2: startActivity(new Intent(MainActivity.this, ContNorth.class));
                        break;
                    case 3: startActivity(new Intent(MainActivity.this,ContSouth.class));
                        break;
                    case 4: startActivity(new Intent(MainActivity.this, ContEurope.class));
                        break;
                    case 5: startActivity(new Intent(MainActivity.this,ContAustralia.class));
                        break;
                }
            }
        });


        imageContainer = findViewById(R.id.trendingplacesimages);
        layout = findViewById(R.id.dotscontainer);

        dots = new TextView[7];

        list = new int[7];
        list[0] = R.drawable.skydive;
        list[1] = R.drawable.kenyasafari;
        list[2] = R.drawable.cruise;
        list[3] = R.drawable.aurora;
        list[4] = R.drawable.maldivesmain;
        list[5] = R.drawable.bluehole;
        list[6] = R.drawable.disneyland;

        adapter = new sliderAdaptor(list);
        imageContainer.setAdapter(adapter);
        setIndicators();

        imageContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectedDots(position);
                super.onPageSelected(position);
            }
        });


    }


    private void selectedDots(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[i].setTextColor(getResources().getColor(R.color.white));
            } else {
                dots[i].setTextColor(getResources().getColor(R.color.dots));
            }
        }
    }

    private void setIndicators() {
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"+" "));
            dots[i].setTextSize(9);
            layout.addView(dots[i]);
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home: onBackPressed();
                break;
            case R.id.nav_about: Intent intent2 = new Intent(this,about.class);
                startActivity(intent2);
                break;
            case R.id.nav_contact: Intent mailintent = new Intent(android.content.Intent.ACTION_SEND);
                mailintent.setType("text/plain");
                mailintent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]
                        {"gullagoutham2603@gmail.com"});
                mailintent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Give your Feedback");
                startActivity(mailintent);
                break;

            case  R.id.nav_share: Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Liked our app!. Share it with your Friends";
                sharingIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {"gullagoutham2603@gmail.com"});
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


}
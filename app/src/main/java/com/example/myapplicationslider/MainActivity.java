package com.example.myapplicationslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout linearMusic,linearAlbum;
    Button music,album;
    private List<SongLists> songLists;
    SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearAlbum=(LinearLayout)findViewById(R.id.linear_album);
        linearMusic=(LinearLayout)findViewById(R.id.linear_music);
        music=(Button)findViewById(R.id.button_music);
        album=(Button)findViewById(R.id.button_album);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_songs);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview_songs2);
        RecyclerView recyclerViewAlbum = findViewById(R.id.recyclerview_album);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearMusic.setVisibility(View.VISIBLE);
                album.setTextColor(Color.WHITE);
                music.setTextColor(Color.GREEN);
                linearAlbum.setVisibility(View.GONE);
            }
        });
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearAlbum.setVisibility(View.VISIBLE);
                music.setTextColor(Color.WHITE);
                album.setTextColor(Color.GREEN);
                linearMusic.setVisibility(View.GONE);
            }
        });

        viewPager = findViewById(R.id.view_pager);
        ViewPagerAdaper viewPagerAdapter = new ViewPagerAdaper(this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 3000);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        songLists = new ArrayList<>();
        songLists.add(new SongLists(R.drawable.songfive, "Faded"));
        songLists.add(new SongLists(R.drawable.songsix, "Beleiver"));
        songLists.add(new SongLists(R.drawable.songseven, "Alone"));
        songLists.add(new SongLists(R.drawable.song, "Perfect"));
        songLists.add(new SongLists(R.drawable.songnine, "Shape of you"));

        SongAdapter myAdapter = new SongAdapter(this, songLists);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,songLists.size()));
        recyclerView.setAdapter(myAdapter);
        recyclerView2.setLayoutManager(new GridLayoutManager(MainActivity.this,songLists.size()));
        recyclerView2.setAdapter(myAdapter);
        recyclerViewAlbum.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        recyclerViewAlbum.setAdapter(myAdapter);

    }
    public class MyTimerTask extends TimerTask
    {

        public void run()
        {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem()== 1){

                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem()== 2){

                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem()== 3){

                        viewPager.setCurrentItem(4);
                    }
                    else {

                        viewPager.setCurrentItem(0);
                    }

                }
            });
        }

    }


}
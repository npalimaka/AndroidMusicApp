package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<MusicGenre> genres = new ArrayList<>();
        genres.add(new MusicGenre(R.string.pop, R.drawable.pop));
        genres.add(new MusicGenre(R.string.rock, R.drawable.rock));
        genres.add(new MusicGenre(R.string.classic, R.drawable.classic));
        genres.add(new MusicGenre(R.string.rap, R.drawable.rap));

        GridView gridView = findViewById(R.id.gridview);
        final MusicGenreAdapter musicGenreAdapter = new MusicGenreAdapter(this, genres);
        gridView.setAdapter(musicGenreAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent popIntent = new Intent(MainActivity.this, PopMusicActivity.class);
                    startActivity(popIntent);
                }
                if (position == 1) {
                    Intent rockIntent = new Intent(MainActivity.this, RockMusicActivity.class);
                    startActivity(rockIntent);
                }
                if (position == 2) {
                    Intent classicIntent = new Intent(MainActivity.this, ClassicMusicActivity.class);
                    startActivity(classicIntent);
                }
                if (position == 3) {
                    Intent rapIntent = new Intent(MainActivity.this, RapMusicActivity.class);
                    startActivity(rapIntent);
                }
            }
        });
    }
}

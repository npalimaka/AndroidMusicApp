package com.example.android.musicapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.gridview)
    GridView gridview;

    private static final int POP_GENRE = 0;
    private static final int ROCK_GENRE = 1;
    private static final int CLASSIC_GENRE = 2;
    private static final int RAP_GENRE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final ArrayList<MusicGenre> genres = new ArrayList<>();
        genres.add(new MusicGenre(R.string.pop, R.drawable.pop));
        genres.add(new MusicGenre(R.string.rock, R.drawable.rock));
        genres.add(new MusicGenre(R.string.classic, R.drawable.classic));
        genres.add(new MusicGenre(R.string.rap, R.drawable.rap));

        final MusicGenreAdapter musicGenreAdapter = new MusicGenreAdapter(this, genres);
        gridview.setAdapter(musicGenreAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == POP_GENRE) {
                    Intent popIntent = new Intent(MainActivity.this, PopMusicActivity.class);
                    popIntent.putExtra("pop", genres.get(0).getImage());
                    startActivity(popIntent);
                }
                if (position == ROCK_GENRE) {
                    Intent rockIntent = new Intent(MainActivity.this, RockMusicActivity.class);
                    rockIntent.putExtra("rock", genres.get(1).getImage());
                    startActivity(rockIntent);
                }
                if (position == CLASSIC_GENRE) {
                    Intent classicIntent = new Intent(MainActivity.this, ClassicMusicActivity.class);
                    classicIntent.putExtra("classic", genres.get(2).getImage());
                    startActivity(classicIntent);
                }
                if (position == RAP_GENRE) {
                    Intent rapIntent = new Intent(MainActivity.this, RapMusicActivity.class);
                    rapIntent.putExtra("rap", genres.get(3).getImage());
                    startActivity(rapIntent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

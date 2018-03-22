package com.example.android.musicapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Natalia on 21-Mar-18.
 */

public class PopMusicActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        ArrayList<Song>songs = new ArrayList<>();
        songs.add(new Song(R.string.beatles, R.string.beatles_song));

        SongAdapter songAdapter = new SongAdapter(PopMusicActivity.this, songs);
        ListView songList = findViewById(R.id.songs_list);
        songList.setAdapter(songAdapter);
    }
}

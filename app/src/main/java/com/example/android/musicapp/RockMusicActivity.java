package com.example.android.musicapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Natalia on 21-Mar-18.
 */

public class RockMusicActivity extends AppCompatActivity {
    @BindView(R.id.songs_list)
    ListView songView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        ButterKnife.bind(this);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.string.pearljam, R.string.pj_song));

        SongAdapter songAdapter = new SongAdapter(RockMusicActivity.this, songs);
        songView.setAdapter(songAdapter);
    }
}

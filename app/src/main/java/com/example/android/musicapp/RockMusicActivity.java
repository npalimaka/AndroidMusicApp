package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.string.pearljam, R.string.pj_song));
        songs.add(new Song(R.string.purple, R.string.purple_song));
        songs.add(new Song(R.string.lp, R.string.lp_song));
        songs.add(new Song(R.string.ledzep, R.string.ledzep_song));
        songs.add(new Song(R.string.porcupine, R.string.porcupine_song));
        songs.add(new Song(R.string.foo, R.string.foo_song));
        songs.add(new Song(R.string.queen, R.string.queen_song));
        songs.add(new Song(R.string.muse, R.string.muse_song));
        songs.add(new Song(R.string.thirty, R.string.thirty_song));
        songs.add(new Song(R.string.radiohead, R.string.radiohead_song));
        songs.add(new Song(R.string.rem, R.string.rem_song));

        SongAdapter songAdapter = new SongAdapter(RockMusicActivity.this, songs);
        songView.setAdapter(songAdapter);

        songView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RockMusicActivity.this, CurrentSongActivity.class);
                intent.putExtra("artist", songs.get(i).getArtistName());
                intent.putExtra("song", songs.get(i).getSongName());
                intent.putExtra("genre", getIntent().getIntExtra("rock", 0));
                startActivity(intent);
            }
        });
    }
}

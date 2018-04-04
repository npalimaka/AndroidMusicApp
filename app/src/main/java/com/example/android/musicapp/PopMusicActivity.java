package com.example.android.musicapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Natalia on 21-Mar-18.
 */

public class PopMusicActivity extends AppCompatActivity {
    @BindView(R.id.songs_list)
    ListView songView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        ButterKnife.bind(this);
      //  getActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.string.beatles, R.string.beatles_song));
        songs.add(new Song(R.string.madonna, R.string.madonna_song));
        songs.add(new Song(R.string.cher, R.string.cher_song));
        songs.add(new Song(R.string.dido, R.string.dido_song));
        songs.add(new Song(R.string.robbie, R.string.robbie_song));
        songs.add(new Song(R.string.jackson, R.string.jackson_song));
        songs.add(new Song(R.string.abba, R.string.abba_song));
        songs.add(new Song(R.string.blunt, R.string.blunt_song));

        SongAdapter songAdapter = new SongAdapter(PopMusicActivity.this, songs);
        songView.setAdapter(songAdapter);

        songView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PopMusicActivity.this, CurrentSongActivity.class);
                intent.putExtra("artist", songs.get(i).getArtistName());
                intent.putExtra("song", songs.get(i).getSongName());
                intent.putExtra("genre", getIntent().getIntExtra("pop", 0));
                startActivity(intent);
            }
        });
    }
}

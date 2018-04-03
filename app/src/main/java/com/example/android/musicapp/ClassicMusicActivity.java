package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Natalia on 21-Mar-18.
 */

public class ClassicMusicActivity extends AppCompatActivity {
    @BindView(R.id.songs_list)
    ListView songView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        ButterKnife.bind(this);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.string.mozart, R.string.mozart_song));
        songs.add(new Song(R.string.chopin, R.string.chopin_song));
        songs.add(new Song(R.string.bach, R.string.bach_song));
        songs.add(new Song(R.string.beethoven, R.string.beethoven_song));
        songs.add(new Song(R.string.cataldo, R.string.cataldo_song));
        songs.add(new Song(R.string.debussy, R.string.debussy_song));
        songs.add(new Song(R.string.elgar, R.string.elgar_song));
        songs.add(new Song(R.string.schubert, R.string.schubert_song));
        songs.add(new Song(R.string.vivaldi, R.string.vivaldi_song));
        songs.add(new Song(R.string.wagner, R.string.wagner_song));

        SongAdapter songAdapter = new SongAdapter(ClassicMusicActivity.this, songs);
        songView.setAdapter(songAdapter);

        songView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ClassicMusicActivity.this, CurrentSongActivity.class);
                intent.putExtra("artist", songs.get(i).getArtistName());
                intent.putExtra("song", songs.get(i).getSongName());
                intent.putExtra("genre", getIntent().getIntExtra("classic", 0));
                startActivity(intent);
            }
        });
    }
}

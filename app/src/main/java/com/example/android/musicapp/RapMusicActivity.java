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

public class RapMusicActivity extends AppCompatActivity {
    @BindView(R.id.songs_list)
    ListView songView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        ButterKnife.bind(this);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.string.twopac, R.string.twopac_song));
        songs.add(new Song(R.string.eminem, R.string.eminem_song));
        songs.add(new Song(R.string.beastie, R.string.beastie_song));
        songs.add(new Song(R.string.cent, R.string.cent_song));
        songs.add(new Song(R.string.dre, R.string.dre_song));
        songs.add(new Song(R.string.kanye, R.string.kanye_song));
        songs.add(new Song(R.string.outkast, R.string.outkast_song));
        songs.add(new Song(R.string.cypress, R.string.cypress_song));

        SongAdapter songAdapter = new SongAdapter(RapMusicActivity.this, songs);
        songView.setAdapter(songAdapter);

        songView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RapMusicActivity.this, CurrentSongActivity.class);
                intent.putExtra("artist", songs.get(i).getArtistName());
                intent.putExtra("song", songs.get(i).getSongName());
                intent.putExtra("genre", getIntent().getIntExtra("rap", 0));
                startActivity(intent);
            }
        });
    }
}

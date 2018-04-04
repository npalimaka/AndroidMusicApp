package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Natalia on 23-Mar-18.
 */

public class CurrentSongActivity extends AppCompatActivity {
    @BindView(R.id.artist_name)
    TextView artist_name;
    @BindView(R.id.song_name)
    TextView song_name;
    @BindView(R.id.song_image)
    ImageView song_image;
    @BindView(R.id.play_arrow)
    ImageView play_to_pause;

    boolean paused;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_song_view);
        ButterKnife.bind(this);

        song_image.setImageResource(getIntent().getIntExtra("genre", 0));
        artist_name.setText(getIntent().getIntExtra("artist", 0));
        song_name.setText(getIntent().getIntExtra("song", 0));

        play_to_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!paused) {
                    play_to_pause.setImageResource(R.mipmap.ic_pause_black_18dp);
                    paused = true;
                } else {
                    play_to_pause.setImageResource(R.mipmap.ic_play_arrow_black_18dp);
                    paused = false;
                }
            }
        });
    }
}

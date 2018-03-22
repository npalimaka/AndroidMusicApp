package com.example.android.musicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Natalia on 22-Mar-18.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View songItemView = convertView;
        if(songItemView == null){
            songItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }
        Song currentSong = getItem(position);
        TextView currentArtistView = songItemView.findViewById(R.id.artist_text_view);
        currentArtistView.setText(currentSong.getArtistName());
        TextView currentSongNameView = songItemView.findViewById(R.id.song_text_view);
        currentSongNameView.setText(currentSong.getSongName());

        return songItemView;
    }
}

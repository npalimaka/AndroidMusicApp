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

import butterknife.BindView;
import butterknife.ButterKnife;

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
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        Song currentSong = getItem(position);
        holder.currentArtistView.setText(currentSong.getArtistName());
        holder.currentSongView.setText(currentSong.getSongName());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.artist_text_view)
        TextView currentArtistView;
        @BindView(R.id.song_text_view)
        TextView currentSongView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

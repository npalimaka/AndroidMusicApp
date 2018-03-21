package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Natalia on 20-Mar-18.
 */

public class MusicGenreAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<MusicGenre> genres;

    public MusicGenreAdapter(Context context, ArrayList<MusicGenre> genres){
        this.mContext = context;
        this.genres = genres;
    }

    @Override
    public int getCount() {
        return genres.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
       final MusicGenre musicGenre = genres.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.genre_view, null);
        }

        final ImageView musicGenreImage = convertView.findViewById(R.id.specified_genre_image);
        final TextView musicGenreName = convertView.findViewById(R.id.specified_genre_name);

        musicGenreImage.setImageResource(musicGenre.getImage());
        musicGenreName.setText(mContext.getString(musicGenre.getName()));

        return convertView;

    }
}

package com.example.android.musicapp;

import android.media.Image;

/**
 * Created by Natalia on 20-Mar-18.
 */

public class MusicGenre {

    private int name;
    private int imageResource;

    public MusicGenre(int name, int image){
        this.name = name;
        this.imageResource = image;
    }

    public int getName() {
        return name;
    }

    public int getImage() {
        return imageResource;
    }
}

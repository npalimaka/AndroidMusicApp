package com.example.android.musicapp;

/**
 * Created by Natalia on 22-Mar-18.
 */

public class Song {

    private int artistName;
    private int songName;

    public Song(int artistName, int songName){
        this.artistName = artistName;
        this.songName = songName;
    }

    public int getArtistName() {
        return artistName;
    }

    public int getSongName() {
        return songName;
    }
}

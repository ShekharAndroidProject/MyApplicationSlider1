package com.example.myapplicationslider;

public class SongLists {
    int songImage;
    String songName;

    public SongLists(int songImage, String songName) {
        this.songImage = songImage;
        this.songName = songName;
    }

    public int getSongImage() {
        return songImage;
    }

    public void setSongImage(int songImage) {
        this.songImage = songImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}

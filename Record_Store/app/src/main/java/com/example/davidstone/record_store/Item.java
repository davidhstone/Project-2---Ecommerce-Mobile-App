package com.example.davidstone.record_store;

/**
 * Created by davidstone on 7/28/16.
 */
public class Item {
    private String bandName;
    private String albumTitle;
    private String genre;

    public Item (String bandName, String albumTitle, String genre) {
        this.bandName = bandName;
        this.albumTitle = albumTitle;
        this.genre = genre;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

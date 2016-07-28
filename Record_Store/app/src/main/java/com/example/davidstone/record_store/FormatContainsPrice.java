package com.example.davidstone.record_store;

/**
 * Created by davidstone on 7/28/16.
 */
public class FormatContainsPrice {
    private String bandName;
    private String albumTitle;
    private String format;
    private int price;

    public FormatContainsPrice (String bandName, String albumTitle, String format, int price) {
        this.bandName = bandName;
        this.albumTitle = albumTitle;
        this.format = format;
        this.price = price;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

package com.example.davidstone.record_store;

/**
 * Created by davidstone on 7/28/16.
 */
public class Item {

    //EVEN THOUGH I'M NOT USING THIS RIGHT NOW, I"M KEEPING IT IN HERE TO POSSIBLY USE LATER

    private int mIcon;
    private String mBandName;
    private String mAlbumTitle;
    private String mGenre;
    private String mFormat;
    private Double mPrice;

    public Item (int icon, String bandName, String albumTitle, String genre, String format, Double price) {
        mIcon = 999;
        mBandName = bandName;
        mAlbumTitle = albumTitle;
        mGenre = genre;
        mFormat = format;
        mPrice = 0.00;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public String getmBandName() {
        return mBandName;
    }

    public void setmBandName(String mBandName) {
        this.mBandName = mBandName;
    }

    public String getmAlbumTitle() {
        return mAlbumTitle;
    }

    public void setmAlbumTitle(String mAlbumTitle) {
        this.mAlbumTitle = mAlbumTitle;
    }

    public String getmGenre() {
        return mGenre;
    }

    public void setmGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getmFormat() {
        return mFormat;
    }

    public void setmFormat(String mFormat) {
        this.mFormat = mFormat;
    }

    public Double getmPrice() {
        return mPrice;
    }

    public void setmPrice(Double mPrice) {
        this.mPrice = mPrice;
    }
}

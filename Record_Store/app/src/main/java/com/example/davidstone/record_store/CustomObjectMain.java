package com.example.davidstone.record_store;

import android.widget.ImageView;

/**
 * Created by davidstone on 7/26/16.
 */
public class CustomObjectMain {

    private int mMainObjectID;
    private int mAlbumIcon;
    private String mBandName;
    private String mAlbumTitle;
    private String mGenre;
    private String mFormat;
    private Double mPrice;




    public CustomObjectMain(int mainObjectID, int albumIcon, String bandName, String albumTitle, String genre,
                            String format, Double price) {

        mMainObjectID = mainObjectID;
        mAlbumIcon = albumIcon;
        mBandName = bandName;
        mAlbumTitle = albumTitle;
        mGenre = genre;
        mFormat = format;
        mPrice = price;



    }

    public int getmAlbumIcon() {
        return mAlbumIcon;
    }

    public void setmAlbumIcon(int mAlbumIcon) {
        this.mAlbumIcon = mAlbumIcon;
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

    public int getmMainObjectID() {
        return mMainObjectID;
    }

    public void setmMainObjectID(int mMainObjectID) {
        this.mMainObjectID = mMainObjectID;
    }
}

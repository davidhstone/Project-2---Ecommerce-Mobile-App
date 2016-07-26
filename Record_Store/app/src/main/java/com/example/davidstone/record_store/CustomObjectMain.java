package com.example.davidstone.record_store;

import android.widget.ImageView;

/**
 * Created by davidstone on 7/26/16.
 */
public class CustomObjectMain {

    int mAlbumIcon;
    String mBandName;
    String mAlbumName;


    public CustomObjectMain() {

        mAlbumIcon = 999;
        mBandName = "BandName 1";
        mAlbumName = "AlbumName 1";
    }

    public CustomObjectMain(int albumIcon, String bandName, String albumName) {

        mAlbumIcon = albumIcon;
        mBandName = bandName;
        mAlbumName = albumName;

        //     this.bandName = bandName;
        //     this.albumName = albumName;
        //     this.color = color;
        // }
//
        // String bandName;
        // String albumName;
        // int color;
    }

    public String getmBandName() {
        return mBandName;
    }

    public void setmBandName(String mBandName) {
        this.mBandName = mBandName;
    }

    public String getmAlbumName() {
        return mAlbumName;
    }

    public void setmAlbumName(String mAlbumName) {
        this.mAlbumName = mAlbumName;
    }

    public int getmAlbumIcon() {
        return mAlbumIcon;
    }

    public void setmAlbumIcon(int mAlbumIcon) {
        this.mAlbumIcon = mAlbumIcon;
    }
}

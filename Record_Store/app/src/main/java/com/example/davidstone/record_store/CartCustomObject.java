package com.example.davidstone.record_store;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartCustomObject {

    private int mCartObjectID;
    private String mBandName;
    private String mAlbumTitle;
    private String mFormat;
    private double mPrice;


   public CartCustomObject(int cartObjectID, String bandName, String albumTitle, String format, double price) {

       mCartObjectID = cartObjectID;
       mBandName = bandName;
       mAlbumTitle = albumTitle;
       mFormat = format;
       mPrice = price;


   }

    public int getmCartObjectID() {
        return mCartObjectID;
    }

    public void setmCartObjectID(int mCartObjectID) {
        this.mCartObjectID = mCartObjectID;
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

    public String getmFormat() {
        return mFormat;
    }

    public void setmFormat(String mFormat) {
        this.mFormat = mFormat;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }
}

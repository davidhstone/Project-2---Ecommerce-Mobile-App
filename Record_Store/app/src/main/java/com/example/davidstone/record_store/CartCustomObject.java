package com.example.davidstone.record_store;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartCustomObject {

    String mBandName;
    String mAlbumTitle;
    String mGenre;
    String mFormat;
    double mPrice;
    List<CartCustomObject> cartCustomObjectList;

    public CartCustomObject() {

        mBandName = "bandName";
        mAlbumTitle = "albumTitle";
        mGenre = "genre";
        mFormat = "albumFormat";
        mPrice = 0.00;
        cartCustomObjectList = new LinkedList<>();
    }

    public List<CartCustomObject> getCartCustomObjectList(){
        return cartCustomObjectList;
    }

    public void setCartCustomObjectList(List<CartCustomObject> cartCustomObjectList) {
        if (cartCustomObjectList == null) {
            this.cartCustomObjectList = new LinkedList<>();
        }
        else {
            this.cartCustomObjectList = cartCustomObjectList;
        }
    }

    public CartCustomObject(String bandName, String albumTitle, String format, double price) {

        mBandName = bandName;
        mAlbumTitle = albumTitle;
        mFormat = format;
        mPrice = price;
        cartCustomObjectList = new LinkedList<>();
    }

    public String getBandName() {
        return mBandName;
    }

    public void setBandName(String bandName) {
        mBandName = bandName;
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        mAlbumTitle = albumTitle;
    }

    public String getFormat() {
        return mFormat;
    }

    public void setFormat(String format) {
        mFormat = format;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }
}

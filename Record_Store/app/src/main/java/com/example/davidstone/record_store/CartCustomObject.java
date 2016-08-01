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
  //  List<CartCustomObject> cartCustomObjectList;

   // public CartCustomObject() {
//
   //     mCartObjectID = "cartObjectID";
   //     mBandName = "bandName";
   //     mAlbumTitle = "albumTitle";
   //     mFormat = "albumFormat";
   //     mPrice = 0.00;
   //
   // }

  //  public List<CartCustomObject> getCartCustomObjectList(){
  //      return cartCustomObjectList;
  //  }

  //  public void setCartCustomObjectList(List<CartCustomObject> cartCustomObjectList) {
  //      if (cartCustomObjectList == null) {
  //          this.cartCustomObjectList = new LinkedList<>();
  //      }
  //      else {
  //          this.cartCustomObjectList = cartCustomObjectList;
  //      }
  //  }

   public CartCustomObject(int cartObjectID, String bandName, String albumTitle, String format, double price) {

       mCartObjectID = cartObjectID;
       mBandName = bandName;
       mAlbumTitle = albumTitle;
       mFormat = format;
       mPrice = price;

  //     mCartObjectID = 1;
  //     mBandName = bandName;
  //     mAlbumTitle = albumTitle;
  //     mFormat = format;
  //     mPrice = price;
  //  //   cartCustomObjectList = new LinkedList<>();
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

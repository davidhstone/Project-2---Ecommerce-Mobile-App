package com.example.davidstone.record_store;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartSingleton {

    private static CartSingleton cartSingleton = null;

    private static List<String> bandNames;
    private static List<String> albumTitles;
    private static List<String> formats;
    private static List<Double> prices;
    List<CartCustomObject> cartList;

    private CartSingleton() {
        bandNames = new LinkedList<String>();
        albumTitles = new LinkedList<String>();
        formats = new LinkedList<String>();
        prices = new LinkedList<Double>();
        cartList = new LinkedList<>();

        CartCustomObject cart = new CartCustomObject(0, "","","",0);

      //  List cartList  = new LinkedList();
      //  cartList.add(new CartCustomObject());

      //  cart.setCartCustomObjectList(cartList);
    }

    public static CartSingleton getInstance() {

        if (cartSingleton == null) {
            cartSingleton = new CartSingleton();
        }
        return cartSingleton;
    }

    public void addBandName(String bandName){
        bandNames.add(bandName);
    }

    public void addAlbumTitle(String albumTitle){
        albumTitles.add(albumTitle);
    }

    public void addFormat(String format) {
        formats.add(format);
    }

    public void addPrice(Double price){
        prices.add(price);
    }

    public void addToCartList(CartCustomObject cart) {
        cartList.add(cart);
    }

    public String getBandNames(int position){
        return bandNames.get(position);
    }

    public String getAlbumTitles(int position){
        return albumTitles.get(position);
    }

    public String getFormats(int position){
        return formats.get(position);
    }

    public Double getPrices(int position){
        return prices.get(position);
    }

    public List<CartCustomObject> getCartList() {
        return cartList;
    }


}

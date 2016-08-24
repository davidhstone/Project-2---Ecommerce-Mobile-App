package com.example.davidstone.record_store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    CartRecyclerViewAdapter cartRecyclerViewAdapter;
    CartSingleton cartSingleton;

    ArrayList mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        onEmptyCart();

        /*
        mRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);

        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(ItemsSQLiteOpenHelper.
                getInstance(MainActivity.this).itemList());

        mRecyclerView.setAdapter(mainRecyclerViewAdapter);

         */

        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);


        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(ItemsSQLiteOpenHelper.
                getInstance(CartActivity.this).cartList());
        mRecyclerView.setAdapter(cartRecyclerViewAdapter);


    }

    public void onEmptyCart () {

        //THIS METHOD IS HERE TO MAKE SURE I CAN SEE ALBUMS IN THE CART, WILL BE COMMENTED OUT LATER

        if ((ItemsSQLiteOpenHelper.getInstance(this).checkIfCartExists()) == false)

        {
            ItemsSQLiteOpenHelper itemsSQLiteOpenHelper = ItemsSQLiteOpenHelper.getInstance(this);

            //these lines below are just to see if anything shows up
            itemsSQLiteOpenHelper.insertRowCart(new CartCustomObject(1, "AC/DC", "Powerage",
                    "Vinyl", 15.99));
            itemsSQLiteOpenHelper.insertRowCart(new CartCustomObject(1, "Bad Brains", "ROIR Sessions",
                    "Cassette", 12.99));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_badge:
                return true;

            case R.id.shopping_cart:
                return true;

            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

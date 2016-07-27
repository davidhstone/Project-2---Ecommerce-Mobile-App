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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //NEED REFERENCE TO THE CART LIST

      //  mainRecyclerViewAdapter = new MainRecyclerViewAdapter(customObjectMainList);
      //  mRecyclerView.setAdapter(mainRecyclerViewAdapter);

        List<CartCustomObject> cartCustomObjectList = new ArrayList<>();

        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(cartCustomObjectList);
        mRecyclerView.setAdapter(cartRecyclerViewAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
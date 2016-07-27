package com.example.davidstone.record_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    //WHAT DO I NEED TO DECLARE HERE, THIS SCREEN WON'T BE A RECYCLERVIEW
    RecyclerView mRecyclerView;
    CartSingleton cartSingleton;
    CartRecyclerViewAdapter cartRecyclerViewAdapter;

    Button mTestScreenSwitchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cartSingleton = CartSingleton.getInstance();
        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(cartSingleton.cartList);
        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);

        //IS THIS SUPPOSED TO BE "THIS" HERE, SINCE IT'S MEANT TO ADJUST THE CART
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //      mRecyclerView.setLayoutManager(linearLayoutManager);
        //      mRecyclerView.setAdapter(cartRecyclerViewAdapter);

        //   final int position = getIntent().getIntExtra("position", 0);

        cartSingleton = CartSingleton.getInstance();
//
        //   cartRecyclerViewAdapter = new CartRecyclerViewAdapter(cartSingleton.
        //           cartList.get(position).getCartCustomObjectList());
        //   mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);
        //
        //   mRecyclerView.setLayoutManager(linearLayoutManager);
        //   mRecyclerView.setAdapter(cartRecyclerViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //           .setAction("Action", null).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                //      final RelativeLayout relativeLayout = new RelativeLayout(view.getContext());

                //     final LinearLayout linearLayout = new LinearLayout(view.getContext());

                //     final TextView bandNameConfirm = new TextView(view.getContext());
                //     bandNameConfirm.setText("Test Band Name Confirm");
                //     builder.setView(bandNameConfirm);
//
                //     final TextView albumTitleConfirm = new TextView(view.getContext());
                //     albumTitleConfirm.setText("Test Album Title Confirm");
                //     builder.setView(albumTitleConfirm);
//
                //     final TextView formatConfirm = new TextView(view.getContext());
                //     formatConfirm.setText("Test Album Format Confirm");
                //     builder.setView(formatConfirm);
//
                //   final TextView priceConfirm = new TextView(view.getContext());
                //   priceConfirm.setText("Test Album Price Confirm");
                //   builder.setView(priceConfirm);

                //   final TextView confirmAdd = new TextView(view.getContext());
                //   confirmAdd.setText("Are you sure you want to add this album to your cart?");
                //   builder.setView(confirmAdd);

                final TextView confirmAdd = new TextView(view.getContext());
                confirmAdd.setText("Are you sure you want to add this album to your cart?");
                builder.setView(confirmAdd);

                //  builder.setView(relativeLayout);

                builder.setPositiveButton("Add", null);
                builder.setNegativeButton("Cancel", null);

                final AlertDialog addItemDialog = builder.create();
                addItemDialog.show();

                addItemDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                CartCustomObject newCartItem = new CartCustomObject
                                        ("Band Name",
                                                "Album Title",
                                                "Format Type", 0);

                                Toast.makeText(view.getContext(), "This... is a journey",
                                        Toast.LENGTH_SHORT).show();

                                //            CartCustomObject newItem = new CartCustomObject(
                                //                    bandNameConfirm.getText().toString(),
                                //                    albumTitleConfirm.getText().toString(),
                                //                    formatConfirm.getText().toString(),
                                //                    priceConfirm.getText().toString(), false);

                                cartSingleton.cartList.add(newCartItem);
                                addItemDialog.cancel();
                                cartRecyclerViewAdapter.notifyDataSetChanged();
                            }
                        }
                );
            }
        });


    //THIS CODE BELOW IS TO TEST A BASIC SWITCH SCREEN BUTTON
    mTestScreenSwitchButton=(Button)

    findViewById(R.id.button3);

    mTestScreenSwitchButton.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(view.getContext(), CartActivity.class);
        startActivity(intent);
    }
    }

    );
}
     //END TEST

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

                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);

                return true;

            case R.id.action_settings:

                return true;


            default:

                return super.onOptionsItemSelected(item);
        }
    }

}

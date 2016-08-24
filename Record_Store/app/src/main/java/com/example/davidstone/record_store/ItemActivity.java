package com.example.davidstone.record_store;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
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


    RecyclerView mRecyclerView;
    CartSingleton cartSingleton;
    CartRecyclerViewAdapter cartRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //BELOW IS THE CODE FOR PREPARING THE VIEWS WITH THE ALBUM INFO

        TextView bandNameTextView = (TextView) findViewById(R.id.bandName_textview);
        TextView albumTitleTextView = (TextView) findViewById(R.id.albumTitle_textview);
        TextView genreTextView = (TextView) findViewById(R.id.genre_textview);
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);

        //BELOW CODE SETS THE SELECTED ALBUM INFO INTO THE VIEWS

        int selectedId = getIntent().getIntExtra("dbIndex",-1);

        if(selectedId != -1) {
            // use the getItem() method to get the one item we want to show, and specify its primary key value as an argument
            Cursor selectedItemCursor = ItemsSQLiteOpenHelper.getInstance(ItemActivity.this).getInventoryItem(selectedId);
            selectedItemCursor.moveToFirst();

            bandNameTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_BAND_NAME)));
            albumTitleTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_ALBUM_TITLE)));
            genreTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_GENRE)));
            priceTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(String.valueOf(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_PRICE))));

            selectedItemCursor.close();

        }

        //PREPARING THE CART

        cartSingleton = CartSingleton.getInstance();
        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(cartSingleton.cartList);
        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);


        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               //PREPARES THE DIALOG TO ADD ITEMS TO THE CART

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());


                final TextView formatChoose = new TextView(view.getContext());
                formatChoose.setText("Which format do you want?");
                builder.setView(formatChoose);


                //need to adjust this to a three button setup that selects between vinyl, cassette, and cd with a custom dialog

                builder.setPositiveButton("Vinyl", null);
                builder.setNegativeButton("Cancel", null);

                final AlertDialog addItemDialog = builder.create();
                addItemDialog.show();

                addItemDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                //ADDS ITEMS TO THE CART... IT ALMOST WORKS RIGHT. IT ADDS ITEMS BUT DOESN'T POPULATE THEM

                                CartCustomObject newCartItem = new CartCustomObject
                                        (0, "Band Name", "Album Name", "Format", 0);


                                Toast.makeText(view.getContext(), "This... is a journey",
                                        Toast.LENGTH_SHORT).show();


                                ItemsSQLiteOpenHelper.getInstance(ItemActivity.this).insertRowCart(newCartItem);

                                cartSingleton.cartList.add(newCartItem);
                                cartRecyclerViewAdapter.notifyDataSetChanged();
                                addItemDialog.cancel();

                            }
                        }
                );
            }
        });
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

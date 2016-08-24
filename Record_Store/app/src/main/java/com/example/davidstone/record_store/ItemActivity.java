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

    //WHAT DO I NEED TO DECLARE HERE? THIS SCREEN WON'T BE A RECYCLERVIEW
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

        //BELOW IS THE CODE FOR FILLING THE VIEWS WITH THE ALBUM INFO

        TextView bandNameTextView = (TextView) findViewById(R.id.bandName_textview);
        TextView albumTitleTextView = (TextView) findViewById(R.id.albumTitle_textview);
        TextView genreTextView = (TextView) findViewById(R.id.genre_textview);

// ADD AVAILABLE FORMATS VIEWS ANd MAKE THEM SELECTABLE IF I  CAN GET THE TEXTVIEWS TO WORK
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);

        //below is to test searching along with other changes made on 8/20

      //  if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
      //      String query = getIntent().getStringExtra(SearchManager.QUERY);
      //      Cursor searchCursor = ItemsSQLiteOpenHelper.getInstance(this).searchInventoryList(query);
//
      //      bandNameTextView.setText(searchCursor.getString(searchCursor.getColumnIndex(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_BAND_NAME)));
      //      albumTitleTextView.setText(searchCursor.getString(searchCursor.getColumnIndex(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_ALBUM_TITLE)));
      //      genreTextView.setText(searchCursor.getString(searchCursor.getColumnIndex(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_GENRE)));
      //      priceTextView.setText(searchCursor.getString(searchCursor.getColumnIndex(String.valueOf(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_PRICE))));
//
      //      searchCursor.close();
      //  } else {
      //      bandNameTextView.setText("Error: The selected item was not found!");
      //  }


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
        } else {
            bandNameTextView.setText("Error: The selected item was not found!");
        }



        cartSingleton = CartSingleton.getInstance();
        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(cartSingleton.cartList);
        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recyclerview);

        //IS THIS SUPPOSED TO BE "THIS" HERE, SINCE IT'S MEANT TO ADJUST THE CART?
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

              //  ItemsSQLiteOpenHelper itemsSQLiteOpenHelper = ItemsSQLiteOpenHelper.getInstance(ItemActivity.this);

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

                final TextView formatChoose = new TextView(view.getContext());
                formatChoose.setText("Which format do you want?");
                builder.setView(formatChoose);

                //  builder.setView(relativeLayout);

                //need to adjust this to a three button setup that selects betwween vinyl, cassette, and cd

                builder.setPositiveButton("Vinyl", null);
                builder.setNegativeButton("Cancel", null);

                final AlertDialog addItemDialog = builder.create();
                addItemDialog.show();

                addItemDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                CartCustomObject newCartItem = new CartCustomObject
                                        (0, "Band Name", "Album Name", "Format", 0);

                                //CartCustomObject newCartItem = new CartCustomObject();

                                Toast.makeText(view.getContext(), "This... is a journey",
                                        Toast.LENGTH_SHORT).show();

                                //            CartCustomObject newItem = new CartCustomObject(
                                //                    bandNameConfirm.getText().toString(),
                                //                    albumTitleConfirm.getText().toString(),
                                //                    formatConfirm.getText().toString(),
                                //                    priceConfirm.getText().toString(), false);

                                ItemsSQLiteOpenHelper.getInstance(ItemActivity.this).insertRowCart(newCartItem);

                                //cartRecyclerViewAdapter.notifyDataSetChanged();

                                cartSingleton.cartList.add(newCartItem);

                                addItemDialog.cancel();
                                cartRecyclerViewAdapter.notifyDataSetChanged();
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

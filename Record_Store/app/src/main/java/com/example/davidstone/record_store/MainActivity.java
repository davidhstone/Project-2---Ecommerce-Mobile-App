package com.example.davidstone.record_store;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    CursorAdapter mCursorAdapter;
    //  Button mTestScreenSwitchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //   //THE CODE BELOW IS ADDED TO TEST FRAGMENT
        //   Fragment itemFragment = ItemFragment.newInstance(null, this);
        //   getSupportFragmentManager().beginTransaction().
        //           add(R.id.fragment_container, itemFragment).commit();

        //   DON'T KNOW IF I NEED THE CODE BELOW
        //   DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        //   dbSetup.getReadableDatabase();
//
        mRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);

     //   Cursor cursor = ItemsSQLiteOpenHelper.getInstance(MainActivity.this).itemList();
//
     //   mCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
     //           cursor, new String[]{ItemsSQLiteOpenHelper.InventoryItem.COLUMN_BAND_NAME}, new int[]{
     //           android.R.id.text1},0);

        //THIS CODE BELOW IS TO TEST



      //  List<CustomObjectMain> customObjectMainList = new ArrayList<>();
//
      //  customObjectMainList.add(new CustomObjectMain(R.color.colorAccent,
      //          "AC/DC", "PowerAge"));
//
      //  customObjectMainList.add(new CustomObjectMain(R.color.colorPrimaryDark,
      //          "RKL", "Keep Laughing"));
//
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(ItemsSQLiteOpenHelper.
                getInstance(MainActivity.this).itemList());
        mRecyclerView.setAdapter(mainRecyclerViewAdapter);


        // I SUSPECT THERE'S SOMETHING WRONG WITH HOW THIS RECYCLERVIEW ADAPTER IS SET; SHOULD SOMEHOW TAKE IN THE CURSOR ADAPTER I THINK


     //   mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     //       @Override
     //       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     //           Intent i = new Intent(MainActivity.this,ItemActivity.class);
     //           Cursor selectedItem = (Cursor)parent.getItemAtPosition(position);
////
     //           int databaseID = selectedItem.getInt(selectedItem.getColumnIndex(
     //                   ItemsSQLiteOpenHelper.getInstance(MainActivity.this).itemList());
     //           i.putExtra("dbIndex",databaseID);
     //           startActivity(i);
     //       }
     //   });

        handleIntent(getIntent());

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);



//THE CODE BELOW IS FOR THE NON-FRAGMENT RECYCLERVIEW
     //   mainRecyclerViewAdapter = new MainRecyclerViewAdapter(ItemsSQLiteOpenHelper.
     //           getInstance(MainActivity.this).getInventoryList());
     //   mRecyclerView.setAdapter(mainRecyclerViewAdapter);

        //END TEST


        /*THIS CODE BELOW IS TO TEST A BASIC SWITCH SCREEN BUTTON
        mTestScreenSwitchButton = (Button) findViewById(R.id.button2);

        mTestScreenSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ItemActivity.class);
                startActivity(intent);
            }
        });
        END TEST */

        //      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //      fab.setOnClickListener(new View.OnClickListener() {
        //          @Override
        //          public void onClick(View view) {
        //              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                      .setAction("Action", null).show();
        //          }
        //      });
    }
    // THE CODE BELOW IS FROM WHEN I TRIED TO USE FRAGMENTS. DID NOT WORK
    // @Override
    // public void onAlbumSelected(String selectedAlbum) {
    //     Bundle bundle = new Bundle();
    //     bundle.putString("selected_album", selectedAlbum);
    //     Fragment detailFragment = DetailFragment.newInstance(bundle);
    //     FragmentManager supportManager = getSupportFragmentManager();
    //     FragmentTransaction transaction = supportManager.beginTransaction();
    //     transaction.replace(R.id.fragment_container, detailFragment).commit();
    // }

    public void onEmptyDatabase () {

        if ((ItemsSQLiteOpenHelper.getInstance(this).checkIfTableExists()) == false)

        {
            ItemsSQLiteOpenHelper itemsSQLiteOpenHelper = ItemsSQLiteOpenHelper.getInstance(this);
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "ACDC", "Powerage",
                    "Rock", "Vinyl", 15.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "Bad Brains", "ROIR Sessions",
                    "Hardcore", "Cassette", 12.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "Public Enemy",
                    "It Take a Nation of Millions to Hold Us Back", "Hip Hop", "CD", 18.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "The Clash", "Black Market " +
                    "Clash", "Punk", "Vinyl", 15.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "The Wailers",
                    "Judge Not - 7-inch", "Ska", "Vinyl", 3.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "Void", "Faith / Void ",
                    "Hardcore", "Vinyl", 10.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "RKL", "Keep Laughing",
                    "Skate Punk", "Vinyl", 12.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "The Impressions",
                    "The Best of The Impressions", "Soul", "Vinyl", 12.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "Manu Chau", "Clandestino",
                    "World", "CD", 15.99));
            itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "Sly & the Family Stone",
                    "Stand", "Funk", "Vinyl", 14.99));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem menuItem = menu.findItem(R.id.search_badge);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_badge).
                getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


//         android.widget.SearchView searchView = (android.widget.SearchView) menu.findItem(R.id.search_badge);
     //   ComponentName componentName = new ComponentName(this,SearchResultActivity.class);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_badge:

             //   Toast.makeText(MainActivity.this, "Get up a get git git a get down! " +
             //           "911's a joke in yo town", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.shopping_cart:
                Toast.makeText(MainActivity.this, "BASE! How low can you go? "  +
                                "Death row! What a brotha know!"
                        , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);

                return true;

            case R.id.action_settings:

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = ItemsSQLiteOpenHelper.getInstance(MainActivity.this).searchInventoryList(query);
            mCursorAdapter.changeCursor(cursor);
            mCursorAdapter.notifyDataSetChanged();
        }
    }



}

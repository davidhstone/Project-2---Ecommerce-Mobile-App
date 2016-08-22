package com.example.davidstone.record_store;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


   // These are for AsyncTask, which is breaking the project right now
   //ProgressBar mProgressBar;
   //TextView mTextView;

    RecyclerView mRecyclerView;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    CursorAdapter mCursorAdapter;
    private ItemsSQLiteOpenHelper mHelper;

    private ListView mShoppingListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
        mRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);


        mHelper = ItemsSQLiteOpenHelper.getInstance(this);

        Cursor cursor = ItemsSQLiteOpenHelper.getInstance(MainActivity.this).getInventoryList();
//
        mCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                cursor, new String[]{ItemsSQLiteOpenHelper.InventoryItem.COLUMN_BAND_NAME}, new int[]{
                android.R.id.text1},0);


        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(ItemsSQLiteOpenHelper.
                getInstance(MainActivity.this).itemList());
        mRecyclerView.setAdapter(mainRecyclerViewAdapter);




        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        onEmptyDatabase();
        handleIntent(getIntent());

    }


    public void onEmptyDatabase () {



//
            if ((ItemsSQLiteOpenHelper.getInstance(this).checkIfTableExists()) == false) {



                    {
                        ItemsSQLiteOpenHelper itemsSQLiteOpenHelper = ItemsSQLiteOpenHelper.getInstance(this);
                        itemsSQLiteOpenHelper.insertRowItem(new CustomObjectMain(1, 999, "AC/DC", "Powerage",
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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        //THIS IS SEARCH CODE BEFORE 8/21
        //SearchManager searchManager =
        //        (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //MenuItem menuItem = menu.findItem(R.id.search_badge);
        //SearchView searchView = (SearchView) menu.findItem(R.id.search_badge).
        //        getActionView();
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        // Below is just holding to add if this deosn't work... looks like it goes below Searchview searchview in the lesson
        // ComponentName componentName = new ComponentName(this,ItemActivity.class);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //MenuItem menuItem = menu.findItem(R.id.search);
        MenuItem menuItem = menu.findItem(R.id.search_badge);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_badge).
                getActionView();
        //ComponentName componentName = new ComponentName(this,ItemActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        //DONT CONTROL Z PAST THIS!!!!

        MenuItemCompat.setOnActionExpandListener(menuItem,new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Cursor cursor = mHelper.getInventoryList();
                mCursorAdapter.changeCursor(cursor);
                return true;
            }
        });



//         android.widget.SearchView searchView = (android.widget.SearchView) menu.findItem(R.id.search_badge);
     //   ComponentName componentName = new ComponentName(this,SearchResultActivity.class);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);

        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_badge:

                Toast.makeText(MainActivity.this, "Get up a get git git a get down! " +
                        "911's a joke in yo town", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.shopping_cart:
                Toast.makeText(MainActivity.this, "BASE! How low can you go? "
                        , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);

                return true;

            case R.id.action_settings:

                return true;

            default:

               // return super.onOptionsItemSelected(item);
                return true;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //Cursor cursor = ItemsSQLiteOpenHelper.getInstance(MainActivity.this).searchInventoryList(query);
            Cursor cursor = mHelper.searchInventoryList(query);
            mCursorAdapter.changeCursor(cursor);

        }
    }



}

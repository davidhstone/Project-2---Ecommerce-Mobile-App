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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    CursorAdapter mCursorAdapter;
    Cursor mCursor;

    private ItemsSQLiteOpenHelper mHelper;

    ArrayList mArrayList;

    TextView mBandNameTextView;

  //  List<CustomObjectMain> mCustomObjectsMainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    //    mCustomObjectsMainList =  customObjectsMainList;

        mRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(ItemsSQLiteOpenHelper.
                getInstance(MainActivity.this).itemList());
        mRecyclerView.setAdapter(mainRecyclerViewAdapter);

      //  mArrayList = (ArrayList) ItemsSQLiteOpenHelper.getInstance(MainActivity.this).getInventoryList();

        mHelper = ItemsSQLiteOpenHelper.getInstance(this);

        mCursor = ItemsSQLiteOpenHelper.getInstance(MainActivity.this).getInventoryList();
        Log.d("cursor", mCursor.getCount()+"");

        //mCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.
        //        simple_list_item_1, mCursor, new String[]{ItemsSQLiteOpenHelper.
        //        InventoryItem.COLUMN_BAND_NAME}, new int[]{android.R.id.text1}, 0);



        //ItemsSQLiteOpenHelper.getInstance(MainActivity.this).getInventoryList().setA

        //mCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
        //        cursor, new String[]{ItemsSQLiteOpenHelper.InventoryItem.COLUMN_BAND_NAME}, new int[]{
        //        android.R.id.text1}, 0);


        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        onEmptyDatabase();
        handleIntent(getIntent());

    }

    public void onEmptyDatabase() {

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


        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
     //   MenuItem menuItem = menu.findItem(R.id.search_badge);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_badge).
                getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


     //  MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {

     //      @Override
     //      public boolean onMenuItemActionExpand(MenuItem item) {
     //          return true;
     //      }

     //      @Override
     //      public boolean onMenuItemActionCollapse(MenuItem item) {
     //          Cursor cursor = mHelper.getInventoryList();
     //          mCursorAdapter.changeCursor(cursor);
     //          return true;
     //      }
     //  });

     //   return super.onCreateOptionsMenu(menu);

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("MainActivity", "onNewIntent: yeah");
    //    setIntent(intent);
        handleIntent(intent);

     //   mBandNameTextView = (TextView) findViewById(R.id.bandName_textview);
//
     //   if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//
     //       String query = getIntent().getStringExtra(SearchManager.QUERY);
     //       if(query != null){
     //           Log.d("cursor2", query);
     //       }
//
     //       mCursor = ItemsSQLiteOpenHelper.getInstance(this).searchInventoryList(query);
     //       Log.d("cursor2", mCursor.getCount()+"");
//
     //       mCursorAdapter = new CursorAdapter(this, mCursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER) {
//
     //           @Override
     //           public View newView(Context context, Cursor cursor, ViewGroup parent) {
     //               return LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_item, parent, false);
     //           }
//
     //           @Override
     //           public void bindView(View view, Context context, Cursor cursor) {
     //               //         ListView items = (ListView) view.findViewById(R.id.item_list_view);
//
     //               TextView bandNameTextView = (TextView) findViewById(R.id.bandName_textview);
     //               TextView albumTitleTextView = (TextView) findViewById(R.id.albumTitle_textview);
     //               TextView genreTextView = (TextView) findViewById(R.id.genre_textview);
//
     //               // ADD AVAILABLE FORMATS VIEWS ANd MAKE THEM SELECTABLE IF I  CAN GET THE TEXTVIEWS TO WORK
     //               TextView priceTextView = (TextView) findViewById(R.id.price_textview);
//
     //               bandNameTextView.setText(ItemsSQLiteOpenHelper.InventoryItem.COLUMN_BAND_NAME);
//
     //          //     Intent intent = new Intent(view.getContext(), ItemActivity.class);
     //         //      intent.putExtra("dbIndex",customObjectsMainList.get(position).getmMainObjectID());
     //         //      view.getContext().startActivity(intent);
//
//
     //              // Toast.makeText(view.getContext(), customObjectMain.getmBandName() + " " +
     //              //                 customObjectMain.getmAlbumTitle() + " is a great choice!",
     //              //         Toast.LENGTH_SHORT).show();
//
     //         //      view.getContext().startActivity(intent);
//
     //           }
     //       };
//
     //       //mCursorAdapter.changeCursor(mCursor);
//
     //    //   mListView.setAdapter(mCursorAdapter);
     //   }
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

                return true;
        }
    }


    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //Cursor cursor = ItemsSQLiteOpenHelper.getInstance(MainActivity.this).searchInventoryList(query);
            Cursor cursor = mHelper.searchInventoryList(query);
          //  mCursorAdapter.changeCursor(cursor);

        }
    }
}

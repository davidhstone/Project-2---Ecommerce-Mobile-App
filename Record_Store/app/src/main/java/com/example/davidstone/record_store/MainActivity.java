package com.example.davidstone.record_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
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
//
        mRecyclerView = (RecyclerView) findViewById(R.id.mainrecyclerview);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        List<CustomObjectMain> customObjectMainList = new ArrayList<>();


        //THIS CODE BELOW IS TO TEST
        customObjectMainList.add(new CustomObjectMain(R.color.colorAccent,
                "AC/DC", "PowerAge"));

        customObjectMainList.add(new CustomObjectMain(R.color.colorPrimaryDark,
                "RKL", "Keep Laughing"));

//THE CODE BELOW IS FOR THE NON-FRAGMENT RECYCLERVIEW
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(customObjectMainList);
        mRecyclerView.setAdapter(mainRecyclerViewAdapter);
        //END TEST

        //   mainRecyclerViewAdapter = new MainRecyclerViewAdapter(customObjectMainList);
        //   mRecyclerView.setAdapter(mainRecyclerViewAdapter);

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
                Toast.makeText(MainActivity.this, "Get up a get git git a get down! " +
                        "911's a joke in yo town", Toast.LENGTH_SHORT).show();

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

}

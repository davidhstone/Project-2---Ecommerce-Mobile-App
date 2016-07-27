package com.example.davidstone.record_store;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    Button mTestScreenSwitchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        //END TEST

        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(customObjectMainList);
        mRecyclerView.setAdapter(mainRecyclerViewAdapter);

        //THIS CODE BELOW IS TO TEST
      // mTestScreenSwitchButton = (Button) findViewById(R.id.button2);

      // mTestScreenSwitchButton.setOnClickListener(new View.OnClickListener() {
      //     @Override
      //     public void onClick(View view) {
      //         Intent intent = new Intent(view.getContext(), ItemActivity.class);
      //         startActivity(intent);
      //     }
      // });
        //END TEST



        //      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //      fab.setOnClickListener(new View.OnClickListener() {
        //          @Override
        //          public void onClick(View view) {
        //              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                      .setAction("Action", null).show();
        //          }
        //      });
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

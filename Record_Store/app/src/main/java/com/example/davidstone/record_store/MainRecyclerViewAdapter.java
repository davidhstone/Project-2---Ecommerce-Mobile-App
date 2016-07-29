package com.example.davidstone.record_store;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

// NEED TO WORK OUT THE DETAIL OF ONBINDVIEWHOLDER

/**
 * Created by davidstone on 7/26/16.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainCustomViewHolder>  {

    private Context context;

    List<CustomObjectMain> mCustomObjectsMainList;

    public MainRecyclerViewAdapter(final List<CustomObjectMain> customObjectsMainList) {

        mCustomObjectsMainList = customObjectsMainList;
    }

    @Override
    public MainCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.custom_view_main, parent, false);
        MainCustomViewHolder viewHolder = new MainCustomViewHolder(parentView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(MainCustomViewHolder holder, final int position) {


        final int mPosition = position;
        final CustomObjectMain customObjectMain = mCustomObjectsMainList.get(position);
     //   holder.mImageView1.setImageDrawable(customObjectMain.mAlbumIcon);
        holder.mTextView1.setText(customObjectMain.getmBandName());
        holder.mTextView2.setText(customObjectMain.getmAlbumTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ItemActivity.class);
                intent.putExtra("dbIndex",mCustomObjectsMainList.get(position).getmMainObjectID());
                view.getContext().startActivity(intent);


                Toast.makeText(view.getContext(), customObjectMain.getmBandName() + " " +
                        customObjectMain.getmAlbumTitle() + " is a great choice!",
                        Toast.LENGTH_SHORT).show();


             // switch (position){
             //     case 0:
             //         intent = new Intent(view.getContext(), MainActivity.class);
             //         break;
             //     case 1:
             //         intent = new Intent(view.getContext(), ItemActivity.class);
             //         break;
             //     default:
             // }
              view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCustomObjectsMainList.size();
    }

}

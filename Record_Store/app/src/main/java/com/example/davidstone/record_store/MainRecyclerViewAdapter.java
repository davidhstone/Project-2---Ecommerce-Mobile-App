package com.example.davidstone.record_store;

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
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainCustomViewHolder> {

    List<CustomObjectMain> mCustomOjectsMainList;

    public MainRecyclerViewAdapter(final List<CustomObjectMain> customObjectMainList) {

        mCustomOjectsMainList = customObjectMainList;
    }

    @Override
    public MainCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.custom_view_main, parent, false);
        MainCustomViewHolder viewHolder = new MainCustomViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainCustomViewHolder holder, int position) {

        final int mPosition = position;
        final CustomObjectMain customObjectMain = mCustomOjectsMainList.get(position);
     //   holder.mImageView1.setImageDrawable(customObjectMain.mAlbumIcon);
        holder.mTextView1.setText(customObjectMain.mBandName);
        holder.mTextView2.setText(customObjectMain.mAlbumName);
        holder.mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "The name of the band is " +
                customObjectMain.mBandName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCustomOjectsMainList.size();
    }
}

package com.example.davidstone.record_store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by davidstone on 7/26/16.
 */
public class MainCustomViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView1;
    public TextView mTextView1;
    public TextView mTextView2;

    public MainCustomViewHolder(View itemView) {
        super(itemView);

        mImageView1 = (ImageView) itemView.findViewById(R.id.album_icon);
        mTextView1 = (TextView) itemView.findViewById(R.id.textview_1);
        mTextView2 = (TextView) itemView.findViewById(R.id.textview_2);
    }
}

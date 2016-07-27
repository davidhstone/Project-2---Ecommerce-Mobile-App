package com.example.davidstone.record_store;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by davidstone on 7/26/16.
 */
public class MainCustomViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView1;
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public RelativeLayout mRelLayout;

 //   private final Context context;

    public MainCustomViewHolder(View itemView) {
        super(itemView);
   //     context = itemView.getContext();

        mImageView1 = (ImageView) itemView.findViewById(R.id.album_icon);
        mTextView1 = (TextView) itemView.findViewById(R.id.textview_1);
        mTextView2 = (TextView) itemView.findViewById(R.id.textview_2);
        mTextView3 = (TextView) itemView.findViewById(R.id.textview_3);
        mRelLayout = (RelativeLayout) itemView.findViewById(R.id.item_view);
      //  itemView.setClickable(true);
      //  itemView.setOnClickListener((View.OnClickListener) this);
    }

}

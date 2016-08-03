package com.example.davidstone.record_store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartCustomViewHolder extends RecyclerView.ViewHolder {

    public TextView mBand;
    public TextView mAlbum;
    public TextView mFormat;
    public TextView mPrice;
    public RelativeLayout mRelLayout;

    public CartCustomViewHolder(View itemView) {
        super(itemView);

        mBand = (TextView) itemView.findViewById(R.id.band_textview);
        mAlbum = (TextView) itemView.findViewById(R.id.album_title_textview);
        mFormat = (TextView) itemView.findViewById(R.id.format_textview);
        mPrice = (TextView) itemView.findViewById(R.id.price_textview);
        mRelLayout = (RelativeLayout) itemView.findViewById(R.id.cart_view);
    }
}

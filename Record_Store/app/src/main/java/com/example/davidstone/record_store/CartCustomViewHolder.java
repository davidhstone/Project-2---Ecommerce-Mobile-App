package com.example.davidstone.record_store;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartCustomViewHolder extends RecyclerView.ViewHolder {

    TextView band;
    TextView album;
    TextView format;
    TextView price;

    public CartCustomViewHolder(View itemView) {
        super(itemView);

        band = (TextView) itemView.findViewById(R.id.band_textview);
        album = (TextView) itemView.findViewById(R.id.album_title_textview);
        format = (TextView) itemView.findViewById(R.id.format_textview);
        price = (TextView) itemView.findViewById(R.id.price_textview);
    }
}

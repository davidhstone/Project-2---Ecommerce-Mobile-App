package com.example.davidstone.record_store;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartCustomViewHolder>{

    List<CartCustomObject> cartCustomObjectList;

    public CartRecyclerViewAdapter(List<CartCustomObject> cartCustomObjects) {
      //  if (cartCustomObjects == null)
      //      cartCustomObjectList = new LinkedList<>();
      //  else
            cartCustomObjectList = cartCustomObjects;
    }

    @Override
    public CartCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.cart_custom_layout, parent, false);
        CartCustomViewHolder viewHolder = new CartCustomViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CartCustomViewHolder holder, int position) {

        final int myPosition = position;
        final CartCustomObject cartCustomObject = cartCustomObjectList.get(position);
        holder.band.setText(cartCustomObject.getBandName());
        holder.album.setText(cartCustomObject.getAlbumTitle());
        holder.format.setText(cartCustomObject.getFormat());
        holder.price.setText((int) cartCustomObject.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ItemActivity.class);
                intent.putExtra("position", myPosition);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartCustomObjectList.size();
    }
}

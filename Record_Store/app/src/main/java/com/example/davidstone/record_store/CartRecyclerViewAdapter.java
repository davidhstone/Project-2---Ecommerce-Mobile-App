package com.example.davidstone.record_store;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartCustomViewHolder>{

    List<CartCustomObject> cartCustomObjectList;
    CartSingleton cartSingleton;


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
        holder.band.setText(cartCustomObject.getmBandName());
        holder.album.setText(cartCustomObject.getmAlbumTitle());
        holder.format.setText(cartCustomObject.getmFormat());
        holder.price.setText((int) cartCustomObject.getmPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(view.getContext(), ItemActivity.class);
               // intent.putExtra("position", myPosition);
               // view.getContext().startActivity(intent);

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                final TextView confirmModifyOrRemove = new TextView(view.getContext());
                confirmModifyOrRemove.setText("Do you want to modify or remove this item?");
                builder.setView(confirmModifyOrRemove);

                builder.setPositiveButton("Remove", null);
                builder.setNegativeButton("Cancel", null);

                final AlertDialog removeOrModifyItemDialog = builder.create();
                removeOrModifyItemDialog.show();

                removeOrModifyItemDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                              //  CartCustomObject newCartItem = new CartCustomObject
                              //          ("Band Name",
                              //                  "Album Title",
                              //                  "Format Type", 0);

                                Toast.makeText(view.getContext(), "This... is another journey",
                                        Toast.LENGTH_SHORT).show();

                                //            CartCustomObject newItem = new CartCustomObject(
                                //                    bandNameConfirm.getText().toString(),
                                //                    albumTitleConfirm.getText().toString(),
                                //                    formatConfirm.getText().toString(),
                                //                    priceConfirm.getText().toString(), false);

                                cartSingleton.cartList.remove(myPosition);
                                removeOrModifyItemDialog.cancel();
                                        notifyDataSetChanged();
                            }
                        }
                );
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartCustomObjectList.size();
    }
}

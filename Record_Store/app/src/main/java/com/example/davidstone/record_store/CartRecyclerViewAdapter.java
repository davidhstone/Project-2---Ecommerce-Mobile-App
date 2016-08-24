package com.example.davidstone.record_store;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by davidstone on 7/27/16.
 */
public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartCustomViewHolder>{

    List<CartCustomObject> mCartCustomObjectsList;
    CartSingleton cartSingleton;


    public CartRecyclerViewAdapter(final List<CartCustomObject> cartCustomObjectsList) {
      //  if (cartCustomObjects == null)
      //      cartCustomObjectList = new LinkedList<>();
      //  else

            mCartCustomObjectsList = cartCustomObjectsList;
    }

    @Override
    public CartCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.custom_view_cart, parent, false);
        CartCustomViewHolder viewHolder = new CartCustomViewHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CartCustomViewHolder holder, final int position) {

       // final int mPosition = position;

        final CartCustomObject cartCustomObject = mCartCustomObjectsList.get(position);
        holder.mBand.setText(cartCustomObject.getmBandName());
        holder.mAlbum.setText(cartCustomObject.getmAlbumTitle());
        holder.mFormat.setText(cartCustomObject.getmFormat());
//        holder.mPrice.setText((int) cartCustomObject.getmPrice());

      //  holder.itemView.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {
//
//
      //      //    Intent intent = new Intent(view.getContext(), ItemActivity.class);
      //      //    intent.putExtra("position", mPosition);
      //      //    view.getContext().startActivity(intent);
////
      //          Toast.makeText(view.getContext(), cartCustomObject.getmBandName() + " " +
      //                          cartCustomObject.getmAlbumTitle() + " is a great choice!",
      //                  Toast.LENGTH_SHORT).show();
//
      //          //AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
////
      //          //final TextView confirmModifyOrRemove = new TextView(view.getContext());
      //          //confirmModifyOrRemove.setText("Do you want to modify or remove this item?");
      //          //builder.setView(confirmModifyOrRemove);
////
      //          //builder.setPositiveButton("Remove", null);
      //          //builder.setNegativeButton("Cancel", null);
////
      //          //final AlertDialog removeOrModifyItemDialog = builder.create();
      //          //removeOrModifyItemDialog.show();
////
      //          //removeOrModifyItemDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(
      //          //        new View.OnClickListener() {
      //          //            @Override
      //          //            public void onClick(View view) {
////
      //          //              //  CartCustomObject newCartItem = new CartCustomObject
      //          //              //          ("Band Name",
      //          //              //                  "Album Title",
      //          //              //                  "Format Type", 0);
////
      //          //                Toast.makeText(view.getContext(), "This... is another journey",
      //          //                        Toast.LENGTH_SHORT).show();
////
      //          //                //            CartCustomObject newItem = new CartCustomObject(
      //          //                //                    bandNameConfirm.getText().toString(),
      //          //                //                    albumTitleConfirm.getText().toString(),
      //          //                //                    formatConfirm.getText().toString(),
      //          //                //                    priceConfirm.getText().toString(), false);
////
      //          //                cartSingleton.cartList.remove(mPosition);
      //          //                removeOrModifyItemDialog.cancel();
      //          //                        notifyDataSetChanged();
      //          //            }
      //          //        }
      //          //);
      //         // view.getContext().startActivity(intent);
      //      }
      //  });

    }

    @Override
    public int getItemCount() {
        return mCartCustomObjectsList.size();
    }
}

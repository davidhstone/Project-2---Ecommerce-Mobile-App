package com.example.davidstone.record_store;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.davidstone.record_store.dummy.DummyContent;
import com.example.davidstone.record_store.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    ListView mListView;
    //beliw added as a test from lesson
    OnAlbumSelectedListener mListener;

    //BELOW ADDED AS A TEST FROM LESSON
    public interface OnAlbumSelectedListener {
        public void onAlbumSelected(String selectedAlbum);
    }


  //  // TODO: Customize parameter argument names
  //  private static final String ARG_COLUMN_COUNT = "column-count";
  //  // TODO: Customize parameters
  //  private int mColumnCount = 2;
  //  private OnListFragmentInteractionListener mListener;
//
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
  //  public ItemFragment() {
  //  }

    // TODO: Customize parameter initialization
  //  @SuppressWarnings("unused")
  //  public static ItemFragment newInstance(int columnCount) {
  //      ItemFragment fragment = new ItemFragment();
  //      Bundle args = new Bundle();
  //      args.putInt(ARG_COLUMN_COUNT, columnCount);
  //      fragment.setArguments(args);
  //      return fragment;
  //  }

  //  @Override
  //  public void onCreate(Bundle savedInstanceState) {
  //      super.onCreate(savedInstanceState);
//
  //      if (getArguments() != null) {
  //          mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
  //      }
  //  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    //    View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        mListView = (ListView) view.findViewById(R.id.list);   //this refers to myitemrecyclerviewadapter

        return view;

        // Set the adapter
    //    if (view instanceof RecyclerView) {
    //        Context context = view.getContext();
    //        RecyclerView recyclerView = (RecyclerView) view;
    //        if (mColumnCount <= 2) {
    //            recyclerView.setLayoutManager(new LinearLayoutManager(context));
    //        } else {
    //            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
    //        }
    //        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS, mListener));
    //    }
    //    return view;

    }

    public static ItemFragment newInstance (Bundle bundle, OnAlbumSelectedListener listener) {
        Fragment fragment = new ItemFragment();
        fragment.setArguments(bundle);
        mListener = listener;
     //   return fragment;
    }

    //THE ENTIRE METHOD BELOW WAS ADDED FROM THE LESSON
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(
                R.array.Albums));

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mListener.onAlbumSelected(
                    adapterView.getAdapter().getItem(position).toString());

            }
        });

    }





  //  @Override
  //  public void onAttach(Context context) {
  //      super.onAttach(context);
  //      if (context instanceof OnListFragmentInteractionListener) {
  //          mListener = (OnListFragmentInteractionListener) context;
  //      } else {
  //          throw new RuntimeException(context.toString()
  //                  + " must implement OnListFragmentInteractionListener");
  //      }
  //  }

  //  @Override
  //  public void onDetach() {
  //      super.onDetach();
  //      mListener = null;
  //  }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
  //  public interface OnListFragmentInteractionListener {
  //      // TODO: Update argument type and name
  //      void onListFragmentInteraction(DummyItem item);
  //  }


}


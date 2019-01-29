package com.miguelpeachey.marketplacesimulator.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelpeachey.marketplacesimulator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarketplaceFragment extends Fragment {


    public MarketplaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_marketplace, container, false);



        return view;
    }
}

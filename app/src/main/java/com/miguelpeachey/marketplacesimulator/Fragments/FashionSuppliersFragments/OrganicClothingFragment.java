package com.miguelpeachey.marketplacesimulator.Fragments.FashionSuppliersFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelpeachey.marketplacesimulator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrganicClothingFragment extends Fragment {


    public OrganicClothingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_organic_clothing, container, false);
    }

}

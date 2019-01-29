package com.miguelpeachey.marketplacesimulator.Fragments;


import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelpeachey.marketplacesimulator.Adapters.CustomAdapter;
import com.miguelpeachey.marketplacesimulator.Classes.SuppliersCardview;
import com.miguelpeachey.marketplacesimulator.Fragments.FashionSuppliersFragments.DesignsWorkshopFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.FashionSuppliersFragments.OrganicClothingFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.FashionSuppliersFragments.SunsSewingFragment;
import com.miguelpeachey.marketplacesimulator.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuppliersFragment extends Fragment {

    CustomAdapter adapter;
    ListView lv;


    public SuppliersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suppliers, container, false);

        lv = view.findViewById(R.id.lvFragmentSuppliers);

        adapter = new CustomAdapter(getContext(), getData());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;

                switch (position) {

                    case 0:
                        fragment = new DesignsWorkshopFragment();

                        break;

                    case 1:
                        fragment = new OrganicClothingFragment();

                        break;

                    case 2:
                        fragment = new SunsSewingFragment();

                }

               if (fragment != null) {

                    FragmentTransaction ft = getFragmentManager().beginTransaction();

                    ft.replace(R.id.content_frame, fragment);

                    ft.addToBackStack(null);

                    ft.commit();
                }

           }
        });

        return view;
    }

    private ArrayList getData() {

        ArrayList<SuppliersCardview> suppliersCardview = new ArrayList<>();

        SuppliersCardview s = new SuppliersCardview();
        s.setThumbnail(R.drawable.designs_workshop_logo);
        s.setName("Designs Workshop");
        suppliersCardview.add(s);

        s = new SuppliersCardview();
        s.setThumbnail(R.drawable.organic_clothing_logo);
        s.setName("Organic Clothing Industries");
        suppliersCardview.add(s);

        s = new SuppliersCardview();
        s.setThumbnail(R.drawable.suns_sewing_ltd);
        s.setName("Sun's Sewing Ltd");
        suppliersCardview.add(s);

        return suppliersCardview;
    }
}

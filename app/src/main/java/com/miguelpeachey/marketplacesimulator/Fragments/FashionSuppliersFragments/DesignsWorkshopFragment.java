package com.miguelpeachey.marketplacesimulator.Fragments.FashionSuppliersFragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelpeachey.marketplacesimulator.Databases.DBManager;
import com.miguelpeachey.marketplacesimulator.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesignsWorkshopFragment extends Fragment implements View.OnClickListener {

    private DBManager dbManager;


    public DesignsWorkshopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_designs_workshop, container, false);

        TextView tvUserFunds = view.findViewById(R.id.tvUserFunds);

        //Shirts
        ImageView ivPurpleJacket = view.findViewById(R.id.ivPurpleJacket);
        ImageView ivOrangeJacket = view.findViewById(R.id.ivOrangeJacket);
        ImageView ivBlueJacket = view.findViewById(R.id.ivBlueJacket);
        ImageView ivPoloShirt = view.findViewById(R.id.ivPoloShirt);
        ImageView ivCoat = view.findViewById(R.id.ivCoat);
        //Shorts
        ImageView ivSkyBlueShorts = view.findViewById(R.id.ivSkyBlueShorts);
        ImageView ivRippedJeans = view.findViewById(R.id.ivRippedJeans);
        ImageView ivBlackShorts = view.findViewById(R.id.ivBlackShorts);
        ImageView ivBrownPants = view.findViewById(R.id.ivBrownPants);
        ImageView ivSweatPants = view.findViewById(R.id.ivSweatpants);
        //Shoes
        ImageView ivBrownBoots = view.findViewById(R.id.ivBrownBoots);
        ImageView ivBlueShoes = view.findViewById(R.id.ivBlueShoes);
        ImageView ivRedSneakers = view.findViewById(R.id.ivRedSneakers);
        ImageView ivFormalShoes = view.findViewById(R.id.ivFormalShoes);
        ImageView ivHighHeels = view.findViewById(R.id.ivHighHeels);


        ivPurpleJacket.setOnClickListener(this);
        ivOrangeJacket.setOnClickListener(this);
        ivBlueJacket.setOnClickListener(this);
        ivPoloShirt.setOnClickListener(this);
        ivCoat.setOnClickListener(this);
        ivSkyBlueShorts.setOnClickListener(this);
        ivRippedJeans.setOnClickListener(this);
        ivBlackShorts.setOnClickListener(this);
        ivBrownPants.setOnClickListener(this);
        ivSweatPants.setOnClickListener(this);
        ivBrownBoots.setOnClickListener(this);
        ivBlueShoes.setOnClickListener(this);
        ivRedSneakers.setOnClickListener(this);
        ivFormalShoes.setOnClickListener(this);
        ivHighHeels.setOnClickListener(this);

        dbManager = new DBManager(getActivity());
        dbManager.open();

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ivPurpleJacket:

                SharedPreferences.Editor editor = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor.putString("item_name", "Purple Jacket");
                editor.putString("item_cost", "55");
                editor.apply();

                alertDialog();

                break;

            case R.id.ivOrangeJacket:

                SharedPreferences.Editor editor1 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor1.putString("item_name", "Orange Zipped Jacket");
                editor1.putString("item_cost", "65");
                editor1.apply();

                alertDialog();

                break;

            case R.id.ivBlueJacket:

                SharedPreferences.Editor editor2 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor2.putString("item_name", "Blue Formal Jacket");
                editor2.putString("item_cost", "80");
                editor2.apply();

                alertDialog();

                break;

            case R.id.ivPoloShirt:

                SharedPreferences.Editor editor3 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor3.putString("item_name", "White Polo Shirt");
                editor3.putString("item_cost", "50");
                editor3.apply();

                alertDialog();

                break;

            case R.id.ivCoat:

                SharedPreferences.Editor editor4 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor4.putString("item_name", "Navy Coat");
                editor4.putString("item_cost", "55");
                editor4.apply();

                alertDialog();

                break;

            case R.id.ivSkyBlueShorts:

                SharedPreferences.Editor editor5 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor5.putString("item_name", "Sky Blue Shorts");
                editor5.putString("item_cost", "35");
                editor5.apply();

                alertDialog();

                break;

            case R.id.ivRippedJeans:

                SharedPreferences.Editor editor6 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor6.putString("item_name", "Ripped Jeans");
                editor6.putString("item_cost", "48");
                editor6.apply();

                alertDialog();

                break;

            case R.id.ivBlackShorts:

                SharedPreferences.Editor editor7 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor7.putString("item_name", "Black Shorts");
                editor7.putString("item_cost", "40");
                editor7.apply();

                alertDialog();

                break;

            case R.id.ivBrownPants:

                SharedPreferences.Editor editor8 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor8.putString("item_name", "Brown Cargo Pants");
                editor8.putString("item_cost", "50");
                editor8.apply();

                alertDialog();

                break;

            case R.id.ivSweatpants:

                SharedPreferences.Editor editor9 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor9.putString("item_name", "Grey Sweatpants");
                editor9.putString("item_cost", "40");
                editor9.apply();

                alertDialog();

                break;

            case R.id.ivBrownBoots:

                SharedPreferences.Editor editor10 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor10.putString("item_name", "Brown Work Boots");
                editor10.putString("item_cost", "60");
                editor10.apply();

                alertDialog();

                break;

            case R.id.ivBlueShoes:

                SharedPreferences.Editor editor11 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor11.putString("item_name", "Light Blue High Tops");
                editor11.putString("item_cost", "55");
                editor11.apply();

                alertDialog();

                break;

            case R.id.ivRedSneakers:

                SharedPreferences.Editor editor12 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor12.putString("item_name", "Red Sneakers");
                editor12.putString("item_cost", "75");
                editor12.apply();

                alertDialog();

                break;

            case R.id.ivFormalShoes:

                SharedPreferences.Editor editor13 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor13.putString("item_name", "Brown Formal Shoes");
                editor13.putString("item_cost", "95");
                editor13.apply();

                alertDialog();

                break;

            case R.id.ivHighHeels:

                SharedPreferences.Editor editor14 = getActivity().getSharedPreferences("dbPrefs", MODE_PRIVATE).edit();
                editor14.putString("item_name", "Pink High Heels");
                editor14.putString("item_cost", "80");
                editor14.apply();

                alertDialog();

                break;

        }
    }

    public void alertDialog() {

        final TextView tvUserFunds = getActivity().findViewById(R.id.tvUserFunds);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("dbPrefs", Context.MODE_PRIVATE);
        final String item_name = sharedPreferences.getString("item_name", "Stock Unavailable");

        SharedPreferences sharedCost = getActivity().getSharedPreferences("dbPrefs", Context.MODE_PRIVATE);
        final String item_cost = sharedCost.getString("item_cost", "1000");

        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage("Item name: " + item_name + "\n" +
                "Price: $" + item_cost + "\n" +
                "Do you wish to purchase this item?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Purchase",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                            dbManager.insert(item_name, item_cost);
                            Toast.makeText(getContext(), "Transaction Completed", Toast.LENGTH_SHORT).show();

                    }
                });


        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}


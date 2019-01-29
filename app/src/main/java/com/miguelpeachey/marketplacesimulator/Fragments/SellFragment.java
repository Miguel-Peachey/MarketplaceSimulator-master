package com.miguelpeachey.marketplacesimulator.Fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelpeachey.marketplacesimulator.Databases.DBManager;
import com.miguelpeachey.marketplacesimulator.Helpers.ItemsDatabaseHelper;
import com.miguelpeachey.marketplacesimulator.R;

import java.util.Random;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SellFragment extends Fragment {

    final String[] from = new String[]{ItemsDatabaseHelper._ID,
            ItemsDatabaseHelper.ITEM,
            ItemsDatabaseHelper.PRICE};
    final int[] to = new int[]{R.id.id, R.id.tvListName, R.id.tvListPrice};

    DBManager dbManager;
    ListView lvItems;
    TextView tvStatus;
    private Cursor mCursor;
    private SimpleCursorAdapter adapter;
    private long _id;

    public SellFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sell, container, false);

        dbManager = new DBManager(getActivity());
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        lvItems = view.findViewById(R.id.list_view);
        lvItems.setEmptyView(view.findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(getActivity(), R.layout.custom_listview_sell, cursor, from, to, 0);

        lvItems.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, final int position, final long viewId) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.modify_item, null);
                builder.setView(dialogView);
                builder.setCancelable(true);

                final AlertDialog dialog = builder.create();
                dialog.show();

                TextView titleTextView = lvItems.getChildAt(position).findViewById(R.id.tvListName);
                TextView priceTextView = lvItems.getChildAt(position).findViewById(R.id.tvListPrice);
                tvStatus = lvItems.getChildAt(position).findViewById(R.id.tvStatus);

                final String nameID = titleTextView.getText().toString();
                final String price = priceTextView.getText().toString();

                final int priceID = Integer.valueOf(price);

                final TextView idTextView = lvItems.getChildAt(position).findViewById(R.id.id);
                String id = idTextView.getText().toString();
                _id = Long.parseLong(id);

                TextView tv_name = dialogView.findViewById(R.id.name);
                TextView tv_price = dialogView.findViewById(R.id.price);
                final EditText etAskingPrice = dialogView.findViewById(R.id.etAskingPrice);
                Button btnSellItem = dialogView.findViewById(R.id.btnSellItem);

                tv_name.setText("Item: " + nameID);
                tv_price.setText("Original Price: " + priceID);

                btnSellItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        tvStatus.setText(R.string.string_public);
                        tvStatus.setTextColor(getResources().getColor(R.color.colorTextGreen));

                        String value = etAskingPrice.getText().toString();

                        final int valueID = Integer.valueOf(value);

                        if (valueID > priceID) {

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    deleteRowItem(_id);

                                    mCursor = dbManager.fetch();
                                    adapter.swapCursor(mCursor);

                                    int profit = valueID - priceID;

                                    Toast.makeText(getContext(), "Your " + nameID + " has been sold for $" + valueID + "\n" + "You made a profit of $" + profit, Toast.LENGTH_LONG).show();

                                }
                            }, 5000);
                        } else if (valueID < priceID) {

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    deleteRowItem(_id);

                                    mCursor = dbManager.fetch();
                                    adapter.swapCursor(mCursor);

                                    int loss = priceID - valueID;

                                    Toast.makeText(getContext(), "Your " + nameID + " has been sold for $" + valueID + "\n" + "You made a loss of $" + loss, Toast.LENGTH_LONG).show();
                                }
                            }, 1000);

                        } else if (valueID == priceID) {


                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    deleteRowItem(_id);

                                    mCursor = dbManager.fetch();
                                    adapter.swapCursor(mCursor);

                                    Toast.makeText(getContext(), "Your " + nameID + " has been sold for $" + valueID, Toast.LENGTH_SHORT).show();
                                }
                            }, 2500);
                        }

                        dialog.dismiss();

                    }


                });

            }

        });

        return view;

    }

    public void deleteRowItem(long index) {
        this.dbManager.delete(index);
    }
}

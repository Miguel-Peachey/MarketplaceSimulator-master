package com.miguelpeachey.marketplacesimulator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelpeachey.marketplacesimulator.Classes.SuppliersCardview;
import com.miguelpeachey.marketplacesimulator.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<SuppliersCardview> suppliersCardview;

    public CustomAdapter(Context c, ArrayList<SuppliersCardview> suppliersCardview) {
        this.c = c;
        this.suppliersCardview = suppliersCardview;
    }

    @Override
    public int getCount() {
        return suppliersCardview.size();
    }

    @Override
    public Object getItem(int position) {
        return suppliersCardview.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.cardview_layout, parent, false);
        }

        final SuppliersCardview s = (SuppliersCardview) this.getItem(position);

        ImageView imageView = convertView.findViewById(R.id.ivSupplierLogo);
        TextView textView = convertView.findViewById(R.id.tvSupplierName);

        imageView.setImageResource(s.getThumbnail());
        textView.setText(s.getName());

        return convertView;
    }

}
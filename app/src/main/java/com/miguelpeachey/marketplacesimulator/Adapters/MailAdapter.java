package com.miguelpeachey.marketplacesimulator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.miguelpeachey.marketplacesimulator.Classes.MailCardview;
import com.miguelpeachey.marketplacesimulator.R;

import java.util.ArrayList;

public class MailAdapter extends BaseAdapter {

    Context c;
    ArrayList<MailCardview> mailCardView;

    public MailAdapter (Context c, ArrayList<MailCardview> mailCardView) {
        this.c = c;
        this.mailCardView = mailCardView;
    }

    @Override
    public int getCount() {
        return mailCardView.size();
    }

    @Override
    public Object getItem(int position) {
        return mailCardView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(c).inflate(R.layout.cardview_layout, parent, false);
        }

        final MailCardview m = (MailCardview) this.getItem(position);

        TextView sender = convertView.findViewById(R.id.tvSenderName);
        TextView subject = convertView.findViewById(R.id.tvSubject);
        TextView message = convertView.findViewById(R.id.tvMessage);

        sender.setText(m.getSender());
        subject.setText(m.getSubject());
        message.setText(m.getMessage());

        return convertView;
    }
}

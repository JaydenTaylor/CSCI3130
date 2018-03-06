package ca.dal.cs.softeng.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import ca.dal.cs.softeng.R;
import ca.dal.cs.softeng.common.Constants;


public class EntryAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Course> dataSource;

    public EntryAdapter(Context context, ArrayList<Course> data) {
        this.context = context;
        this.dataSource = data;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view, parent, false);

            holder = new Holder();
            holder.id = convertView.findViewById(R.id.code);
            holder.name = convertView.findViewById(R.id.name);
            holder.days = convertView.findViewById(R.id.days);
            holder.start = convertView.findViewById(R.id.start);
            holder.end = convertView.findViewById(R.id.end);
            holder.seats = convertView.findViewById(R.id.seats);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        TextView id = holder.id;
        TextView name = holder.name;
        TextView days = holder.days;
        TextView start = holder.start;
        TextView end = holder.end;
        TextView seats = holder.seats;

        Course entry = dataSource.get(position);

        id.setText(String.format("%s%s", entry.get(Constants.FACULTY), entry.get(Constants.ID)));
        name.setText((String) entry.get(Constants.NAME));
        days.setText(getDays((String) entry.get(Constants.DAYS)));
        start.setText((String) entry.get(Constants.START));
        end.setText((String) entry.get(Constants.END));
        seats.setText(String.format("%s|%s",
                entry.get(Constants.SEATS_TAKEN), entry.get(Constants.TOTAL_SEATS)));

        return convertView;
    }

    private static class Holder {
        public TextView id;
        public TextView name;
        public TextView days;
        public TextView start;
        public TextView end;
        public TextView seats;
    }


    public String getDays(String bin) {
        int value = Integer.parseInt(bin, 2);
        String ret = "";
        if ((value & 16) == 16) {
            ret += "M";
        }
        if ((value & 8) == 8) {
            ret += "T";
        }
        if ((value & 4) == 4) {
            ret += "W";
        }
        if ((value & 2) == 2) {
            ret += "R";
        }
        if ((value & 1) == 1) {
            ret += "F";
        }
        return ret;
    }
}

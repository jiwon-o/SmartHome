package com.appforest.smarthome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// ListView adapter of Stats fragment
public class StatsListViewAdapter extends BaseAdapter {
    // ArrayList for storing data added to Adapter
    private ArrayList<StatsListViewItem> listViewItemStatsList = new ArrayList<StatsListViewItem>();

    // Constructor of the ListViewAdapter
    public StatsListViewAdapter() {

    }

    // Return the number of data used by Adapter: Required implementation
    @Override
    public int getCount() {
        return listViewItemStatsList.size();
    }

    // Return View to be used to output data located in position to the screen: Required implementation
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // Inflate "listview_item" Layout to obtain convertView reference.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.stats_listview_item, parent, false);
        }

        // Obtain a reference to the widget from View (with layout inflated) to be displayed on the screen
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView usageTextView = (TextView) convertView.findViewById(R.id.textView2);
        TextView costTextView = (TextView) convertView.findViewById(R.id.textView3);

        // Obtain data reference located in position in Data Set(listViewItemList)
        StatsListViewItem statsListViewItem = listViewItemStatsList.get(position);

        // Reflect data in each widget in the item
        iconImageView.setImageDrawable(statsListViewItem.getIcon());
        titleTextView.setText(statsListViewItem.getTitle());
        usageTextView.setText(statsListViewItem.getUsage());
        costTextView.setText(statsListViewItem.getCost());

        return convertView;
    }

    // Return the ID of the item (row) associated with the data to the specified position: Required implementation
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Data return at the specified position: required implementation
    @Override
    public Object getItem(int position) {
        return listViewItemStatsList.get(position);
    }

    // Function for adding item data
    public void addItem(Drawable icon, String title, String desc, String desc2) {
        StatsListViewItem item = new StatsListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        item.setDesc2(desc2);

        listViewItemStatsList.add(item);
    }
}
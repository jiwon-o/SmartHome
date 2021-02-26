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

// ListView adapter of Setting fragment
public class SettingListViewAdapter extends BaseAdapter {
    // ArrayList for storing data added to Adapter
    private ArrayList<SettingListViewItem> listViewItemSettingList = new ArrayList<SettingListViewItem>();

    // Constructor of the ListViewAdapter
    public SettingListViewAdapter() {

    }

    // Return the number of data used by Adapter: Required implementation
    @Override
    public int getCount() {
        return listViewItemSettingList.size();
    }

    // Return View to be used to output data located in position to the screen: Required implementation
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // Inflate "listview_item" Layout to obtain convertView reference.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.setting_listview_item, parent, false);
        }

        // Obtain a reference to the widget from View (with layout inflated) to be displayed on the screen
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);

        // Obtain data reference located in position in Data Set(listViewItemList)
        SettingListViewItem settingListViewItem = listViewItemSettingList.get(position);

        // Reflect data in each widget in the item
        iconImageView.setImageDrawable(settingListViewItem.getIcon());
        titleTextView.setText(settingListViewItem.getTitle());

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
        return listViewItemSettingList.get(position);
    }

    // Function for adding item data
    public void addItem(Drawable icon, String title) {
        SettingListViewItem item = new SettingListViewItem();

        item.setIcon(icon);
        item.setTitle(title);

        listViewItemSettingList.add(item);
    }
}
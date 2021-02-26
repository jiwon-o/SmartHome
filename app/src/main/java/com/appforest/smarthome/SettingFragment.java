package com.appforest.smarthome;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

// Setting fragment
public class SettingFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        ListView listview;
        SettingListViewAdapter adapter;

        // Create Adapter
        adapter = new SettingListViewAdapter();

        // Reference listview
        listview = (ListView) view.findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // Add the first item
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_set_device),
                "Device management");
        // Add the second item
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_set_mode),
                "Mode");
        // Add the third item
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_set_home),
                "Home screen");
        // Add the fourth item
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_set_member),
                "Member connect");
        // Add the fifth item
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_set_inquiry),
                "Inquiry");


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Get item
                SettingListViewItem item = (SettingListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                Drawable iconDrawable = item.getIcon();

                // TODO : use item data.
            }
        });

        return view;
    }

}
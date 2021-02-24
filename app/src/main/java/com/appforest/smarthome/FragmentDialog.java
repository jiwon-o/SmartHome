package com.appforest.smarthome;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDialog extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);

        Bundle args = getArguments();
        String value = args.getString("key");

        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        getDialog().getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.background_overview));

        return view;
    }
}
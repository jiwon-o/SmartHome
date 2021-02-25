package com.appforest.smarthome;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

// Bathroom fragment
public class BathroomFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;
    private CardView lightSettingButton;
    private CardView tempSettingButton;

    Intent intent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bathroom, container, false);

        // Get id of the light button
        lightButton = (ImageView) view.findViewById(R.id.img_bathroom_light);

        // Start lightPowerBtn method
        lightPowerBtn(lightButton);

        // Listener to go to the light setting screen
        lightSettingButton = (CardView) view.findViewById(R.id.btn_light);
        lightSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), LightActivity.class);
                startActivity(intent);
            }
        });

        // Listener to go to the temperature setting screen
        tempSettingButton = (CardView) view.findViewById(R.id.btn_temp);
        tempSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), TempActivity.class);
                startActivity(intent);
            }
        });

        // Get id of the add button
        CardView addButton = (CardView) view.findViewById(R.id.btn_add);
        addButton.setOnClickListener(this);

        return view;
    }

    // Current Light on
    private boolean lightChecked = true;

    // Click to change the status of light bulb
    private void lightPowerBtn(ImageView lightButton) {
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lightChecked == true) { // When the light turn on
                    lightButton.setImageResource(R.drawable.ic_light_on);
                    lightChecked = false;
                } else { // When the light turn off
                    lightButton.setImageResource(R.drawable.ic_light_off);
                    lightChecked = true;
                }
            }
        });
    }

    // When you press the add button, connecting Pop-up dialog open
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                // Sending data to the dialogue
                Bundle args = new Bundle();
                args.putString("key", "value");

                FragmentDialog dialog = new FragmentDialog();
                dialog.setArguments(args); // Data transfer
                dialog.show(getActivity().getSupportFragmentManager(), "tag");

                break;
        }
    }
}
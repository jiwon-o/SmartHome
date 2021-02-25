package com.appforest.smarthome;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// Kitchen fragment
public class KitchenFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;
    private ImageView fridgeButton;
    private ImageView ovenButton;

    private TextView fridgeText;
    private TextView ovenText;

    private CardView fridgeBackground;
    private CardView ovenBackground;

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
        View view = inflater.inflate(R.layout.fragment_kitchen, container, false);

        // Get id of the buttons
        lightButton = (ImageView) view.findViewById(R.id.img_kitchen_light);
        fridgeButton = (ImageView) view.findViewById(R.id.img_kitchen_fridge);
        ovenButton = (ImageView) view.findViewById(R.id.img_kitchen_oven);

        // Get id of the On/Off text
        fridgeText = (TextView) view.findViewById(R.id.txt_kitchen_fridge);
        ovenText = (TextView) view.findViewById(R.id.txt_kitchen_oven);

        // Get id of the background color
        fridgeBackground = (CardView) view.findViewById(R.id.background_kitchen_fridge);
        ovenBackground = (CardView) view.findViewById(R.id.background_kitchen_oven);

        // Get id of the add button
        CardView addButton = (CardView) view.findViewById(R.id.btn_add);
        addButton.setOnClickListener(this);

        // Start each method
        lightPowerBtn(lightButton);
        fridgePowerBtn(fridgeButton);
        ovenPowerBtn(ovenButton);

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

    // Current Refrigerator off
    private boolean fridgeChecked = false;

    // Click to change the status of refrigerator power
    private void fridgePowerBtn(ImageView fridgeButton) {
        fridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fridgeChecked == true) { // When the refrigerator turn on
                    fridgeButton.setImageResource(R.drawable.ic_on);
                    fridgeText.setText("ON");
                    fridgeBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    fridgeChecked = false;
                } else { // When the refrigerator turn off
                    fridgeButton.setImageResource(R.drawable.ic_off);
                    fridgeText.setText("OFF");
                    fridgeBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    fridgeChecked = true;
                }
            }
        });
    }

    // Current Oven on
    private boolean ovenChecked = true;

    // Click to change the status of oven power
    private void ovenPowerBtn(ImageView ovenButton) {
        ovenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ovenChecked == true) { // When the oven turn on
                    ovenButton.setImageResource(R.drawable.ic_on);
                    ovenText.setText("ON");
                    ovenBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    ovenChecked = false;
                } else { // When the oven turn off
                    ovenButton.setImageResource(R.drawable.ic_off);
                    ovenText.setText("OFF");
                    ovenBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    ovenChecked = true;
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
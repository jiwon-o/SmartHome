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

// Bedroom fragment
public class BedroomFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;
    private ImageView tvButton;
    private ImageView airconButton;
    private ImageView fanButton;

    private TextView tvText;
    private TextView airconText;
    private TextView fanText;

    private CardView tvBackground;
    private CardView airconBackground;
    private CardView fanBackground;

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
        View view = inflater.inflate(R.layout.fragment_bedroom, container, false);

        // Get id of the buttons
        lightButton = (ImageView) view.findViewById(R.id.img_badroom_light);
        tvButton = (ImageView) view.findViewById(R.id.img_badroom_tv);
        airconButton = (ImageView) view.findViewById(R.id.img_badroom_aircon);
        fanButton = (ImageView) view.findViewById(R.id.img_badroom_fan);

        // Get id of the On/Off text
        tvText = (TextView) view.findViewById(R.id.txt_bedroom_tv);
        airconText = (TextView) view.findViewById(R.id.txt_bedroom_aircon);
        fanText = (TextView) view.findViewById(R.id.txt_bedroom_fan);

        // Get id of the background color
        tvBackground = (CardView) view.findViewById(R.id.background_bedroom_tv);
        airconBackground = (CardView) view.findViewById(R.id.background_bedroom_aircon);
        fanBackground = (CardView) view.findViewById(R.id.background_bedroom_fan);

        // Get id of the add button
        CardView addButton = (CardView) view.findViewById(R.id.btn_add);
        addButton.setOnClickListener(this);

        // Start each method
        lightPowerBtn(lightButton);
        tvPowerBtn(tvButton);
        airconPowerBtn(airconButton);
        fanPowerBtn(fanButton);

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

    // Current Light off
    private boolean lightChecked = false;

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

    // Current TV off
    private boolean tvChecked = false;

    // Click to change the status of TV power
    private void tvPowerBtn(ImageView tvButton) {
        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvChecked == true) { // When the TV turn on
                    tvButton.setImageResource(R.drawable.ic_on);
                    tvText.setText("ON");
                    tvBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    tvChecked = false;
                } else { // When the TV turn off
                    tvButton.setImageResource(R.drawable.ic_off);
                    tvText.setText("OFF");
                    tvBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    tvChecked = true;
                }
            }
        });
    }

    // Current Air conditioner on
    private boolean airconChecked = true;

    // Click to change the status of air conditioner power
    private void airconPowerBtn(ImageView airconButton) {
        airconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (airconChecked == true) { // When the air conditioner turn on
                    airconButton.setImageResource(R.drawable.ic_on);
                    airconText.setText("ON");
                    airconBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    airconChecked = false;
                } else { // When the air conditioner turn off
                    airconButton.setImageResource(R.drawable.ic_off);
                    airconText.setText("OFF");
                    airconBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    airconChecked = true;
                }
            }
        });
    }

    // Current Fan on
    private boolean fanChecked = true;

    // Click to change the status of fan power
    private void fanPowerBtn(ImageView fanButton) {
        fanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fanChecked == true) { // When the fan turn on
                    fanButton.setImageResource(R.drawable.ic_on);
                    fanText.setText("ON");
                    fanBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    fanChecked = false;
                } else { // When the fan turn off
                    fanButton.setImageResource(R.drawable.ic_off);
                    fanText.setText("OFF");
                    fanBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    fanChecked = true;
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
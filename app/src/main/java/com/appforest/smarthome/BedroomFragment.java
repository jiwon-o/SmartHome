package com.appforest.smarthome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BedroomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BedroomFragment extends Fragment {

    private ImageView lightButton;
    private ImageView tvButton;
    private ImageView airconButton;
    private ImageView fanButton;

    private TextView tvText;
    private TextView airconText;
    private TextView fanText;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BedroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BedroomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BedroomFragment newInstance(String param1, String param2) {
        BedroomFragment fragment = new BedroomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bedroom, container, false);

        lightButton = (ImageView) view.findViewById(R.id.iv_bedroom_light);
        tvButton = (ImageView) view.findViewById(R.id.iv_bedroom_tv);
        airconButton = (ImageView) view.findViewById(R.id.iv_bedroom_aircon);
        fanButton = (ImageView) view.findViewById(R.id.iv_bedroom_fan);

        tvText = (TextView) view.findViewById(R.id.tv_bedroom_tv);
        airconText = (TextView) view.findViewById(R.id.tv_bedroom_aircon);
        fanText = (TextView) view.findViewById(R.id.tv_bedroom_fan);

        lightPowerBtn(lightButton);
        tvPowerBtn(tvButton);
        airconPowerBtn(airconButton);
        fanPowerBtn(fanButton);

        return view;
    }


    private boolean lightChecked = true;
    private void lightPowerBtn(ImageView lightButton) {
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lightChecked == true) {
                    lightButton.setImageResource(R.drawable.ic_light);
                    lightChecked = false;
                } else {
                    lightButton.setImageResource(R.drawable.ic_light_off);
                    lightChecked = true;
                }
            }
        });
    }

    private boolean tvChecked = true;
    private void tvPowerBtn(ImageView tvButton) {
        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvChecked == true) {
                    tvButton.setImageResource(R.drawable.ic_on);
                    tvText.setText("ON");
                    tvChecked = false;
                } else {
                    tvButton.setImageResource(R.drawable.ic_off);
                    tvText.setText("OFF");
                    tvChecked = true;
                }
            }
        });
    }

    private boolean airconChecked = true;
    private void airconPowerBtn(ImageView airconButton) {
        airconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (airconChecked == true) {
                    airconButton.setImageResource(R.drawable.ic_on);
                    airconText.setText("ON");
                    airconChecked = false;
                } else {
                    airconButton.setImageResource(R.drawable.ic_off);
                    airconText.setText("OFF");
                    airconChecked = true;
                }
            }
        });
    }

    private boolean fanChecked = true;
    private void fanPowerBtn(ImageView fanButton) {
        fanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fanChecked == true) {
                    fanButton.setImageResource(R.drawable.ic_on);
                    fanText.setText("ON");
                    fanChecked = false;
                } else {
                    fanButton.setImageResource(R.drawable.ic_off);
                    fanText.setText("OFF");
                    fanChecked = true;
                }
            }
        });
    }
}
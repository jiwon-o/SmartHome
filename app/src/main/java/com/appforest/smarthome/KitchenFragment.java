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
 * Use the {@link KitchenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KitchenFragment extends Fragment {

    private ImageView lightButton;
    private ImageView fridgeButton;
    private ImageView ovenButton;

    private TextView fridgeText;
    private TextView ovenText;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KitchenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KitchenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KitchenFragment newInstance(String param1, String param2) {
        KitchenFragment fragment = new KitchenFragment();
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
        View view = inflater.inflate(R.layout.fragment_kitchen, container, false);

        lightButton = (ImageView) view.findViewById(R.id.iv_kitchen_light);
        fridgeButton = (ImageView) view.findViewById(R.id.iv_kitchen_fridge);
        ovenButton = (ImageView) view.findViewById(R.id.iv_kitchen_oven);

        fridgeText = (TextView) view.findViewById(R.id.tv_kitchen_fridge);
        ovenText = (TextView) view.findViewById(R.id.tv_kitchen_oven);

        lightPowerBtn(lightButton);
        fridgePowerBtn(fridgeButton);
        ovenPowerBtn(ovenButton);

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

    private boolean fridgeChecked = true;
    private void fridgePowerBtn(ImageView fridgeButton) {
        fridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fridgeChecked == true) {
                    fridgeButton.setImageResource(R.drawable.ic_on);
                    fridgeText.setText("ON");
                    fridgeChecked = false;
                } else {
                    fridgeButton.setImageResource(R.drawable.ic_off);
                    fridgeText.setText("OFF");
                    fridgeChecked = true;
                }
            }
        });
    }

    private boolean ovenChecked = true;
    private void ovenPowerBtn(ImageView ovenButton) {
        ovenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ovenChecked == true) {
                    ovenButton.setImageResource(R.drawable.ic_on);
                    ovenText.setText("ON");
                    ovenChecked = false;
                } else {
                    ovenButton.setImageResource(R.drawable.ic_off);
                    ovenText.setText("OFF");
                    ovenChecked = true;
                }
            }
        });
    }

}
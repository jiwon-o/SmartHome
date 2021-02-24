package com.appforest.smarthome;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class KitchenFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;
    private ImageView fridgeButton;
    private ImageView ovenButton;

    private TextView fridgeText;
    private TextView ovenText;

    private CardView fridgeBackground;
    private CardView ovenBackground;

    private CardView lightFrame;
    private CardView tempFrame;

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

        lightButton = (ImageView) view.findViewById(R.id.iv_kitchen_light);
        fridgeButton = (ImageView) view.findViewById(R.id.iv_kitchen_fridge);
        ovenButton = (ImageView) view.findViewById(R.id.iv_kitchen_oven);

        fridgeText = (TextView) view.findViewById(R.id.tv_kitchen_fridge);
        ovenText = (TextView) view.findViewById(R.id.tv_kitchen_oven);

        fridgeBackground = (CardView) view.findViewById(R.id.background_kitchen_fridge);
        ovenBackground = (CardView) view.findViewById(R.id.background_kitchen_oven);

        lightPowerBtn(lightButton);
        fridgePowerBtn(fridgeButton);
        ovenPowerBtn(ovenButton);

        CardView open = (CardView) view.findViewById(R.id.btn_plus);
        open.setOnClickListener(this);

        lightFrame = (CardView) view.findViewById(R.id.btn_light);
        lightFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), LightActivity.class);
                startActivity(intent);
            }
        });

        tempFrame = (CardView) view.findViewById(R.id.btn_temp);
        tempFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), TempActivity.class);
                startActivity(intent);
            }
        });

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

    private boolean fridgeChecked = false;
    private void fridgePowerBtn(ImageView fridgeButton) {
        fridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fridgeChecked == true) {
                    fridgeButton.setImageResource(R.drawable.ic_on);
                    fridgeText.setText("ON");
                    fridgeBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    fridgeChecked = false;
                } else {
                    fridgeButton.setImageResource(R.drawable.ic_off);
                    fridgeText.setText("OFF");
                    fridgeBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
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
                    ovenBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    ovenChecked = false;
                } else {
                    ovenButton.setImageResource(R.drawable.ic_off);
                    ovenText.setText("OFF");
                    ovenBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    ovenChecked = true;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_plus:
                // 데이터를 다이얼로그로 보내는 코드
                Bundle args = new Bundle();
                args.putString("key", "value");
                //---------------------------------------.//
                FragmentDialog dialog = new FragmentDialog();
                dialog.setArguments(args); // 데이터 전달
                dialog.show(getActivity().getSupportFragmentManager(),"tag");

                break;

        }
    }

}
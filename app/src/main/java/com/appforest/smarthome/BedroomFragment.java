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
        View view = inflater.inflate(R.layout.fragment_bedroom, container, false);

        lightButton = (ImageView) view.findViewById(R.id.iv_bedroom_light);
        tvButton = (ImageView) view.findViewById(R.id.iv_bedroom_tv);
        airconButton = (ImageView) view.findViewById(R.id.iv_bedroom_aircon);
        fanButton = (ImageView) view.findViewById(R.id.iv_bedroom_fan);

        tvText = (TextView) view.findViewById(R.id.tv_bedroom_tv);
        airconText = (TextView) view.findViewById(R.id.tv_bedroom_aircon);
        fanText = (TextView) view.findViewById(R.id.tv_bedroom_fan);

        tvBackground = (CardView) view.findViewById(R.id.background_bedroom_tv);
        airconBackground = (CardView) view.findViewById(R.id.background_bedroom_aircon);
        fanBackground = (CardView) view.findViewById(R.id.background_bedroom_fan);

        lightPowerBtn(lightButton);
        tvPowerBtn(tvButton);
        airconPowerBtn(airconButton);
        fanPowerBtn(fanButton);

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


    private boolean lightChecked = false;
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

    private boolean tvChecked = false;
    private void tvPowerBtn(ImageView tvButton) {
        tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvChecked == true) {
                    tvButton.setImageResource(R.drawable.ic_on);
                    tvText.setText("ON");
                    tvBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    tvChecked = false;
                } else {
                    tvButton.setImageResource(R.drawable.ic_off);
                    tvText.setText("OFF");
                    tvBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
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
                    airconBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    airconChecked = false;
                } else {
                    airconButton.setImageResource(R.drawable.ic_off);
                    airconText.setText("OFF");
                    airconBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
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
                    fanBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    fanChecked = false;
                } else {
                    fanButton.setImageResource(R.drawable.ic_off);
                    fanText.setText("OFF");
                    fanBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    fanChecked = true;
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
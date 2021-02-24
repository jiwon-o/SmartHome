package com.appforest.smarthome;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class LivingroomFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;
    private ImageView tvButton;
    private ImageView airconButton;
    private ImageView speakerButton;

    private TextView tvText;
    private TextView airconText;
    private TextView speakerText;

    private CardView tvBackground;
    private CardView airconBackground;
    private CardView speakerBackground;

    private ImageView checkingImage;

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
        View view = inflater.inflate(R.layout.fragment_livingroom, container, false);

        lightButton = (ImageView) view.findViewById(R.id.iv_livingroom_light);
        tvButton = (ImageView) view.findViewById(R.id.iv_livingroom_tv);
        airconButton = (ImageView) view.findViewById(R.id.iv_livingroom_aircon);
        speakerButton = (ImageView) view.findViewById(R.id.iv_livingroom_speaker);

        tvText = (TextView) view.findViewById(R.id.tv_livingroom_tv);
        airconText = (TextView) view.findViewById(R.id.tv_livingroom_aircon);
        speakerText = (TextView) view.findViewById(R.id.tv_livingroom_speaker);

        tvBackground = (CardView) view.findViewById(R.id.background_livingroom_tv);
        airconBackground = (CardView) view.findViewById(R.id.background_livingroom_aircon);
        speakerBackground = (CardView) view.findViewById(R.id.background_livingroom_speaker);

        checkingImage = (ImageView) view.findViewById(R.id.iv_check);

        buttonAnimation(checkingImage);

        lightPowerBtn(lightButton);
        tvPowerBtn(tvButton);
        airconPowerBtn(airconButton);
        speakerPowerBtn(speakerButton);

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

    private void buttonAnimation(ImageView checkingImage) {
        //You can check the animation you received in the anim folder.
        Animation startAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.flash_animation);
        checkingImage.startAnimation(startAnimation);
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

    private boolean tvChecked = true;
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

    private boolean airconChecked = false;
    private void airconPowerBtn(ImageView airconButton) {
        airconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (airconChecked == true) {
                    airconButton.setImageResource(R.drawable.ic_on);
                    airconText.setText("ON");
                    airconBackground.setCardBackgroundColor(getActivity().getColor(R.color.checking));
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

    private boolean speakerChecked = true;
    private void speakerPowerBtn(ImageView speakerButton) {
        speakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (speakerChecked == true) {
                    speakerButton.setImageResource(R.drawable.ic_on);
                    speakerText.setText("Playing");
                    speakerBackground.setCardBackgroundColor(getActivity().getColor(R.color.white));
                    speakerChecked = false;
                } else {
                    speakerButton.setImageResource(R.drawable.ic_off);
                    speakerText.setText("OFF");
                    speakerBackground.setCardBackgroundColor(getActivity().getColor(R.color.light_gray));
                    speakerChecked = true;
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
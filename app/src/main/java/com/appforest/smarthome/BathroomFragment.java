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

public class BathroomFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;

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
        View view = inflater.inflate(R.layout.fragment_bathroom, container, false);

        lightButton = (ImageView) view.findViewById(R.id.iv_bathroom_light);

        lightPowerBtn(lightButton);

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
                dialog.show(getActivity().getSupportFragmentManager(), "tag");

                break;

        }
    }
}
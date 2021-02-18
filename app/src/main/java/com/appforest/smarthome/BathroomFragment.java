package com.appforest.smarthome;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BathroomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BathroomFragment extends Fragment implements View.OnClickListener {

    private ImageView lightButton;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BathroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BathroomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BathroomFragment newInstance(String param1, String param2) {
        BathroomFragment fragment = new BathroomFragment();
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
        View view = inflater.inflate(R.layout.fragment_bathroom, container, false);

        lightButton = (ImageView) view.findViewById(R.id.iv_bathroom_light);

        lightPowerBtn(lightButton);

        CardView open = (CardView) view.findViewById(R.id.btn_plus);

        open.setOnClickListener(this);

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
                dialog.show(getActivity().getSupportFragmentManager(),"tag");

                break;

        }
    }
}
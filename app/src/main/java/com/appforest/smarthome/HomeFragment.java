package com.appforest.smarthome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView inhomeImage;
    private ImageView goingoutImage;
    private ImageView nightImage;
    private ImageView partyImage;
    private ImageView movieImage;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        inhomeImage = (ImageView) view.findViewById(R.id.iv_inhome);
        goingoutImage = (ImageView) view.findViewById(R.id.iv_goingout);
        nightImage = (ImageView) view.findViewById(R.id.iv_night);
        partyImage = (ImageView) view.findViewById(R.id.iv_party);
        movieImage = (ImageView) view.findViewById(R.id.iv_movie);


        ClickInhomeButton(inhomeImage);
        ClickGoingoutButton(goingoutImage);
        ClickNightButton(nightImage);
        ClickPartyButton(partyImage);
        ClickMovieButton(movieImage);


        TabLayout tabLayout = view.findViewById(R.id.tab_layout_data);

        tabLayout.addTab(tabLayout.newTab().setText("Living room"));
        tabLayout.addTab(tabLayout.newTab().setText("Kitchen"));
        tabLayout.addTab(tabLayout.newTab().setText("Bedroom"));
        tabLayout.addTab(tabLayout.newTab().setText("Bathroom"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = view.findViewById(R.id.pager_data);
        final PagerAdapterData adapter = new PagerAdapterData
                (getFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(2); //No reset

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });

        return view;
    }

    private boolean inhomeChecked = true;
    private boolean goingoutChecked = true;
    private boolean nightChecked = true;
    private boolean partyChecked = true;
    private boolean movieChecked = true;


    private void ClickInhomeButton(ImageView inhomeImage) {
        inhomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inhomeChecked == true) {
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_click);
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_unclick);
                    nightImage.setImageResource(R.drawable.ic_mode_night_unclick);
                    partyImage.setImageResource(R.drawable.ic_mode_party_unclick);
                    movieImage.setImageResource(R.drawable.ic_mode_movie_unclick);
                    inhomeChecked = false;
                    goingoutChecked = true;
                    nightChecked = true;
                    partyChecked = true;
                    movieChecked = true;
                } else {
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_unclick);
                    inhomeChecked = true;
                }
            }
        });
    }


    private void ClickGoingoutButton(ImageView goingoutImage) {
        goingoutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (goingoutChecked == true) {
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_unclick);
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_click);
                    nightImage.setImageResource(R.drawable.ic_mode_night_unclick);
                    partyImage.setImageResource(R.drawable.ic_mode_party_unclick);
                    movieImage.setImageResource(R.drawable.ic_mode_movie_unclick);
                    inhomeChecked = true;
                    goingoutChecked = false;
                    nightChecked = true;
                    partyChecked = true;
                    movieChecked = true;
                } else {
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_unclick);
                    goingoutChecked = true;
                }
            }
        });
    }


    private void ClickNightButton(ImageView nightImage) {
        nightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nightChecked == true) {
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_unclick);
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_unclick);
                    nightImage.setImageResource(R.drawable.ic_mode_night_click);
                    partyImage.setImageResource(R.drawable.ic_mode_party_unclick);
                    movieImage.setImageResource(R.drawable.ic_mode_movie_unclick);
                    inhomeChecked = true;
                    goingoutChecked = true;
                    nightChecked = false;
                    partyChecked = true;
                    movieChecked = true;
                } else {
                    nightImage.setImageResource(R.drawable.ic_mode_night_unclick);
                    nightChecked = true;
                }
            }
        });
    }


    private void ClickPartyButton(ImageView partyImage) {
        partyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (partyChecked == true) {
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_unclick);
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_unclick);
                    nightImage.setImageResource(R.drawable.ic_mode_night_unclick);
                    partyImage.setImageResource(R.drawable.ic_mode_party_click);
                    movieImage.setImageResource(R.drawable.ic_mode_movie_unclick);
                    inhomeChecked = true;
                    goingoutChecked = true;
                    nightChecked = true;
                    partyChecked = false;
                    movieChecked = true;
                } else {
                    partyImage.setImageResource(R.drawable.ic_mode_party_unclick);
                    partyChecked = true;
                }
            }
        });
    }


    private void ClickMovieButton(ImageView movieImage) {
        movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieChecked == true) {
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_unclick);
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_unclick);
                    nightImage.setImageResource(R.drawable.ic_mode_night_unclick);
                    partyImage.setImageResource(R.drawable.ic_mode_party_unclick);
                    movieImage.setImageResource(R.drawable.ic_mode_movie_click);
                    inhomeChecked = true;
                    goingoutChecked = true;
                    nightChecked = true;
                    partyChecked = true;
                    movieChecked = false;
                } else {
                    movieImage.setImageResource(R.drawable.ic_mode_movie_unclick);
                    movieChecked = true;
                }
            }
        });
    }

}
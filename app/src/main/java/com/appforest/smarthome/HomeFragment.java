package com.appforest.smarthome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

// Home fragment
public class HomeFragment extends Fragment {

    private ImageView inhomeImage;
    private ImageView goingoutImage;
    private ImageView nightImage;
    private ImageView partyImage;
    private ImageView movieImage;

    private boolean inhomeChecked = true;
    private boolean goingoutChecked = true;
    private boolean nightChecked = true;
    private boolean partyChecked = true;
    private boolean movieChecked = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Get id of the mode button
        inhomeImage = (ImageView) view.findViewById(R.id.img_inhome);
        goingoutImage = (ImageView) view.findViewById(R.id.img_goingout);
        nightImage = (ImageView) view.findViewById(R.id.img_night);
        partyImage = (ImageView) view.findViewById(R.id.img_party);
        movieImage = (ImageView) view.findViewById(R.id.img_movie);

        // Start each method
        ClickInhomeButton(inhomeImage);
        ClickGoingoutButton(goingoutImage);
        ClickNightButton(nightImage);
        ClickPartyButton(partyImage);
        ClickMovieButton(movieImage);

        // Get id of the tabLayout
        TabLayout tabLayout = view.findViewById(R.id.tab_layout_data);

        // Set text of tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Living room"));
        tabLayout.addTab(tabLayout.newTab().setText("Kitchen"));
        tabLayout.addTab(tabLayout.newTab().setText("Bedroom"));
        tabLayout.addTab(tabLayout.newTab().setText("Bathroom"));

        // Set Gravity of tabLayout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // ViewPager adapter
        final ViewPager viewPager = view.findViewById(R.id.pager_data);
        final PagerAdapter adapter = new PagerAdapter
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

    // Click to change the status of inhome mode
    private void ClickInhomeButton(ImageView inhomeImage) {
        inhomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inhomeChecked == true) { // When the inhome button is pressed
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
                } else { // When the inhome button isn't pressed
                    inhomeImage.setImageResource(R.drawable.ic_mode_inhome_unclick);
                    inhomeChecked = true;
                }
            }
        });
    }

    // Click to change the status of goingout mode
    private void ClickGoingoutButton(ImageView goingoutImage) {
        goingoutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (goingoutChecked == true) { // When the goingout button is pressed
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
                } else { // When the goingout button isn't pressed
                    goingoutImage.setImageResource(R.drawable.ic_mode_goingout_unclick);
                    goingoutChecked = true;
                }
            }
        });
    }

    // Click to change the status of night mode
    private void ClickNightButton(ImageView nightImage) {
        nightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nightChecked == true) { // When the night button is pressed
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
                } else { // When the night button isn't pressed
                    nightImage.setImageResource(R.drawable.ic_mode_night_unclick);
                    nightChecked = true;
                }
            }
        });
    }

    // Click to change the status of party mode
    private void ClickPartyButton(ImageView partyImage) {
        partyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (partyChecked == true) { // When the party button is pressed
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
                } else { // When the party button isn't pressed
                    partyImage.setImageResource(R.drawable.ic_mode_party_unclick);
                    partyChecked = true;
                }
            }
        });
    }

    // Click to change the status of movie mode
    private void ClickMovieButton(ImageView movieImage) {
        movieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieChecked == true) { // When the movie button is pressed
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
                } else { // When the movie button isn't pressed
                    movieImage.setImageResource(R.drawable.ic_mode_movie_unclick);
                    movieChecked = true;
                }
            }
        });
    }

}
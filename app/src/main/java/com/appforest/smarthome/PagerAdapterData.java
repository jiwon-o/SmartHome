package com.appforest.smarthome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

// Pager adapter in fragment_data
public class PagerAdapterData extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public PagerAdapterData(@NonNull FragmentManager fm, int NumOfTabs) {
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LivingroomFragment();
            case 1:
                return new KitchenFragment();
            case 2:
                return new BedroomFragment();
            case 3:
                return new BathroomFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
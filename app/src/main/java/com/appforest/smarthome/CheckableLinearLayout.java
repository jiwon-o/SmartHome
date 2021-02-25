package com.appforest.smarthome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;

// Checkable linear layout of sliding up panel layout
class CheckableLinearLayout extends LinearLayout implements Checkable {

    // Current Power off
    private boolean powerChecked = false;

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void setChecked(boolean checked) {
        // Get id of the power image
        ImageView powerImage = (ImageView) findViewById(R.id.img_power);

        // Click to change the status of power button
        powerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                powerChecked = !powerChecked;
                if (powerChecked) {
                    powerImage.setImageResource(R.drawable.ic_on);

                } else {
                    powerImage.setImageResource(R.drawable.ic_off);

                }
            }
        });

    }

    @Override
    public boolean isChecked() {
        // Get id of the power image
        ImageView powerImage = (ImageView) findViewById(R.id.img_power);

        // return powerChecked
        return powerChecked;
    }

    @Override
    public void toggle() {
        // Get id of the power image
        ImageView powerImage = (ImageView) findViewById(R.id.img_power);

        setChecked(powerChecked ? false : true);
    }
}

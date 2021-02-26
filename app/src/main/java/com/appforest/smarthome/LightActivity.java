package com.appforest.smarthome;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// Light setting activity
public class LightActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ImageView backImage;

    private ToggleButton lightPowerButton;

    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;

    private TextView txt_light1;
    private TextView txt_light2;
    private TextView txt_light3;
    private TextView txt_light4;

    private Switch switch1;
    private Switch switch2;
    private Switch switch3;
    private Switch switch4;

    // Current Light on
    private boolean lightChecked = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        // Get id of back image
        backImage = findViewById(R.id.img_back);

        // Get id of seek bars
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);

        // Get id of text value
        txt_light1 = (TextView) findViewById(R.id.txt_light1);
        txt_light2 = (TextView) findViewById(R.id.txt_light2);
        txt_light3 = (TextView) findViewById(R.id.txt_light3);
        txt_light4 = (TextView) findViewById(R.id.txt_light4);

        // Get id of switches
        switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(this);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch3.setOnCheckedChangeListener(this);
        switch4 = (Switch) findViewById(R.id.switch4);
        switch4.setOnCheckedChangeListener(this);

        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // SeekBar of Main light
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // value of brightness from 0 to 100 when the seek bar changes
                txt_light1.setText(Integer.toString(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // SeekBar of light #1
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // value of brightness from 0 to 100 when the seek bar changes
                txt_light2.setText(Integer.toString(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // SeekBar of light #2
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // value of brightness from 0 to 100 when the seek bar changes
                txt_light3.setText(Integer.toString(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // SeekBar of light #3
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // value of brightness from 0 to 100 when the seek bar changes
                txt_light4.setText(Integer.toString(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        // Click listener for all light power button
        lightPowerButton = (ToggleButton) findViewById(R.id.btn_light);

        lightPowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightChecked = !lightChecked;
                if (lightChecked) { // When the power button is pressed, all switches are turned on.
                    lightPowerButton.setBackgroundResource(R.drawable.ic_on_big);
                    switch1.setChecked(true);
                    switch2.setChecked(true);
                    switch3.setChecked(true);
                    switch4.setChecked(true);
                } else { // When the power button is off
                    lightPowerButton.setBackgroundResource(R.drawable.ic_off_big);
                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);

                }
            }
        });

    }

    // onCheckedChanged() listener of switches
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch1:
                if (isChecked) { // When switch1 is switched on, the light power button is also turned on.
                    lightPowerButton.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else { // When all switches are switched off, the light power button is turned off.
                    if (!switch2.isChecked() && !switch3.isChecked() && !switch4.isChecked()) {
                        lightPowerButton.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;
            case R.id.switch2:
                if (isChecked) { // When switch2 is switched on, the light power button is also turned on.
                    lightPowerButton.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else { // When all switches are switched off, the light power button is turned off.
                    if (!switch1.isChecked() && !switch3.isChecked() && !switch4.isChecked()) {
                        lightPowerButton.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;

            case R.id.switch3:
                if (isChecked) { // When switch2 is switched on, the light power button is also turned on.
                    lightPowerButton.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else { // When all switches are switched off, the light power button is turned off.
                    if (!switch1.isChecked() && !switch2.isChecked() && !switch4.isChecked()) {
                        lightPowerButton.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;

            case R.id.switch4:
                if (isChecked) { // When switch2 is switched on, the light power button is also turned on.
                    lightPowerButton.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else { // When all switches are switched off, the light power button is turned off.
                    if (!switch1.isChecked() && !switch2.isChecked() && !switch3.isChecked()) {
                        lightPowerButton.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;

        }

    }

}

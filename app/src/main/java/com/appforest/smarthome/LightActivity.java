package com.appforest.smarthome;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LightActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton btnLight;
    private ImageView backImage;
    private SeekBar seekBarMain;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;

    private TextView txtValueMain;
    private TextView txtValue1;
    private TextView txtValue2;
    private TextView txtValue3;

    private Switch switchMain;
    private Switch switch1;
    private Switch switch2;
    private Switch switch3;

    private boolean lightChecked = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        backImage = findViewById(R.id.image_back);

        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtValueMain = (TextView) findViewById(R.id.txtValue_main);
        seekBarMain = (SeekBar) findViewById(R.id.seekBar_main);

        txtValue1 = (TextView) findViewById(R.id.txtValue1);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);

        txtValue2 = (TextView) findViewById(R.id.txtValue2);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);

        txtValue3 = (TextView) findViewById(R.id.txtValue3);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);

        btnLight = (ToggleButton) findViewById(R.id.btn_light);
        btnLight.setOnCheckedChangeListener(this);


        switchMain = (Switch) findViewById(R.id.switch_main);
        switchMain.setOnCheckedChangeListener(this);
        switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(this);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch3.setOnCheckedChangeListener(this);

        seekBarMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValueMain.setText(Integer.toString(progress) + "%");
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

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue1.setText(Integer.toString(progress) + "%");
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

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue2.setText(Integer.toString(progress) + "%");
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

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtValue3.setText(Integer.toString(progress) + "%");
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


        btnLight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                lightChecked = !lightChecked;

                if (lightChecked) {
                    btnLight.setBackgroundResource(R.drawable.ic_on_big);
                    switchMain.setChecked(true);
                    switch1.setChecked(true);
                    switch2.setChecked(true);
                    switch3.setChecked(true);


                } else {
                    btnLight.setBackgroundResource(R.drawable.ic_off_big);
                    switchMain.setChecked(false);
                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);


                }
            }
        });


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch_main:
                if (isChecked) {
                    btnLight.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else {
                    if (!switch1.isChecked() && !switch2.isChecked() && !switch3.isChecked()) {
                        btnLight.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;
            case R.id.switch1:
                if (isChecked) {
                    btnLight.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else {
                    if (!switchMain.isChecked() && !switch2.isChecked() && !switch3.isChecked()) {
                        btnLight.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;

            case R.id.switch2:
                if (isChecked) {
                    btnLight.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else {
                    if (!switchMain.isChecked() && !switch1.isChecked() && !switch3.isChecked()) {
                        btnLight.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;

            case R.id.switch3:
                if (isChecked) {
                    btnLight.setBackgroundResource(R.drawable.ic_on_big);
                    lightChecked = true;

                } else {
                    if (!switchMain.isChecked() && !switch1.isChecked() && !switch2.isChecked()) {
                        btnLight.setBackgroundResource(R.drawable.ic_off_big);
                        lightChecked = false;
                    }
                }
                break;

        }

    }

}

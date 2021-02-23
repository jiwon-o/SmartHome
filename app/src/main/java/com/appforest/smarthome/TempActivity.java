package com.appforest.smarthome;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TempActivity extends AppCompatActivity {

    private ImageView backImage;
    private ImageView autoButton;
    private ImageView sleepButton;
    private ImageView coolButton;
    private ImageView hotButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        backImage = findViewById(R.id.image_back);

        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        autoButton = (ImageView) findViewById(R.id.img_temp_auto_unclick);
        sleepButton = (ImageView) findViewById(R.id.img_temp_sleep_unclick);
        coolButton = (ImageView) findViewById(R.id.img_temp_cool_unclick);
        hotButton = (ImageView) findViewById(R.id.img_temp_hot_unclick);

        ClickAutoButton(autoButton);
        ClickSleepButton(sleepButton);
        ClickCoolButton(coolButton);
        ClickHotButton(hotButton);
    }

    private boolean autoChecked = true;
    private boolean sleepChecked = true;
    private boolean coolChecked = true;
    private boolean hotChecked = true;

    private void ClickAutoButton(ImageView inhomeImage) {
        inhomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autoChecked == true) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_click);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);
                    autoChecked = false;
                    sleepChecked = true;
                    coolChecked = true;
                    hotChecked = true;
                } else {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    autoChecked = true;
                }
            }
        });
    }

    private void ClickSleepButton(ImageView inhomeImage) {
        inhomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sleepChecked == true) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_click);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);
                    autoChecked = true;
                    sleepChecked = false;
                    coolChecked = true;
                    hotChecked = true;
                } else {
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    sleepChecked = true;
                }
            }
        });
    }

    private void ClickCoolButton(ImageView inhomeImage) {
        inhomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coolChecked == true) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_click);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);
                    autoChecked = true;
                    sleepChecked = true;
                    coolChecked = false;
                    hotChecked = true;
                } else {
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    coolChecked = true;
                }
            }
        });
    }

    private void ClickHotButton(ImageView inhomeImage) {
        inhomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hotChecked == true) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_click);
                    autoChecked = true;
                    sleepChecked = true;
                    coolChecked = true;
                    hotChecked = false;
                } else {
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);
                    hotChecked = true;
                }
            }
        });
    }
}

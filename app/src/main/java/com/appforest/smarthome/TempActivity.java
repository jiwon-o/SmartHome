package com.appforest.smarthome;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TempActivity extends AppCompatActivity {

    private ImageView backImage;

    private TextView temperatureNum;
    private ImageView plusButton;
    private ImageView minusButton;
    private ToggleButton tempPowerButton;

    private ImageView autoButton;
    private ImageView sleepButton;
    private ImageView coolButton;
    private ImageView hotButton;

    boolean tempChecked = false;
    private int count = 70;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        backImage = findViewById(R.id.image_back);

        temperatureNum = findViewById(R.id.temperature_Number);
        plusButton = findViewById(R.id.btn_temp_plus);
        minusButton = findViewById(R.id.btn_temp_minus);

        tempPowerButton = findViewById(R.id.btn_temp);

        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        plusButton = findViewById(R.id.btn_temp_plus);
        minusButton = findViewById(R.id.btn_temp_minus);

        autoButton = (ImageView) findViewById(R.id.img_temp_auto_unclick);
        sleepButton = (ImageView) findViewById(R.id.img_temp_sleep_unclick);
        coolButton = (ImageView) findViewById(R.id.img_temp_cool_unclick);
        hotButton = (ImageView) findViewById(R.id.img_temp_hot_unclick);

        ClickAutoButton(autoButton);
        ClickSleepButton(sleepButton);
        ClickCoolButton(coolButton);
        ClickHotButton(hotButton);
        temperatureButton(tempPowerButton);

        upDownButton upDownButton = new upDownButton();
        temperatureNum.setText(count + "");
        plusButton.setOnClickListener(upDownButton);
        minusButton.setOnClickListener(upDownButton);

    }

    //Toast when pressing the temperature button without turning on the power
    public static void setCustomToast(Context context) {
        TextView view = new TextView(context);
        view.setBackgroundResource(R.color.background_white);

        final Toast toast = Toast.makeText(context, "Please, turn on the A/C first.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
        toast.show();
    }

    //You can control the number of temperatures
    class upDownButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (tempChecked == true) {//When you click Climate On/Off button
                switch (v.getId()) {
                    case R.id.btn_temp_plus: {
                        if (count < 85) {
                            count = count + 1;
                        }
                        temperatureNum.setText(count + "");
                        break;
                    }
                    case R.id.btn_temp_minus: {
                        if (count > 65) {
                            count = count - 1;
                        }
                        temperatureNum.setText(count + "");
                        break;
                    }
                }
            } else if (tempChecked == false) {//When you didn't click Climate On/Off button
                switch (v.getId()) {
                    case R.id.btn_temp_plus:
                    case R.id.btn_temp_minus:
                        setCustomToast(getApplicationContext());
                        break;

                }
            }
        }
    }

    //Climate On/Off button
    private void temperatureButton(ToggleButton tempPowerButton) {
        tempPowerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (tempChecked == true) {
                    tempChecked = false;
                } else {

                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);

                    tempChecked = true;
                }

            }
        });
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

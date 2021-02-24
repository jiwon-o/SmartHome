package com.appforest.smarthome;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
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

    private boolean tempChecked = true;
    private int count = 70;

    private SeekBar seekBarMain;


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

        clickAutoButton(autoButton);
        clickSleepButton(sleepButton);
        clickCoolButton(coolButton);
        clickHotButton(hotButton);

        PlusMinusButton plusMinusButton = new PlusMinusButton();
        temperatureNum.setText(count + "");
        plusButton.setOnClickListener(plusMinusButton);
        minusButton.setOnClickListener(plusMinusButton);

        seekBarMain = (SeekBar) findViewById(R.id.seekBar_main);
        TextView textView = (TextView) findViewById(R.id.textView);

        tempPowerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                tempChecked = !tempChecked;

                if (tempChecked) {
                    tempPowerButton.setBackgroundResource(R.drawable.ic_on_big);

                } else {
                    tempPowerButton.setBackgroundResource(R.drawable.ic_off_big);

                }
            }
        });
    }

    //Toast when pressing the temperature button without turning on the power
    public static void setCustomToast(Context context) {
        TextView view = new TextView(context);
        view.setBackgroundResource(R.color.background_white);

        final Toast toast = Toast.makeText(context, "Please, turn on the power first.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
        toast.show();
    }

    //You can control the number of temperatures
    class PlusMinusButton implements View.OnClickListener {
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


    private boolean autoChecked = false;
    private boolean sleepChecked = false;
    private boolean coolChecked = false;
    private boolean hotChecked = false;

    private void clickAutoButton(ImageView autoButton) {
        autoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoChecked = !autoChecked;
                if (autoChecked) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_click);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);

                    sleepChecked = false;
                    coolChecked = false;
                    hotChecked = false;
                } else {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                }
            }
        });
    }

    private void clickSleepButton(ImageView sleepButton) {
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleepChecked = !sleepChecked;
                if (sleepChecked) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_click);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);
                    autoChecked = false;

                    coolChecked = false;
                    hotChecked = false;
                } else {
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                }
            }
        });
    }

    private void clickCoolButton(ImageView coolButton) {
        coolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coolChecked = !coolChecked;
                if (coolChecked) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_click);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);
                    autoChecked = false;
                    sleepChecked = false;
                    hotChecked = false;
                } else {
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                }
            }
        });
    }

    private void clickHotButton(ImageView hotButton) {
        hotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotChecked = !hotChecked;
                if (hotChecked) {
                    autoButton.setImageResource(R.drawable.btn_temp_mode_auto_unclick);
                    sleepButton.setImageResource(R.drawable.btn_temp_mode_sleep_unclick);
                    coolButton.setImageResource(R.drawable.btn_temp_mode_cool_unclick);
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_click);
                    autoChecked = false;
                    sleepChecked = false;
                    coolChecked = false;
                } else {
                    hotButton.setImageResource(R.drawable.btn_temp_mode_hot_unclick);

                }
            }
        });
    }
}

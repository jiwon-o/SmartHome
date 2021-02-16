package com.appforest.smarthome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

class CheckableLinearLayout extends LinearLayout implements Checkable {

    // 만약 CheckBox가 아닌 View를 추가한다면 아래의 변수 사용 가능.
     private boolean mIsChecked;

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

         mIsChecked = true ;

    }

    @Override
    public void setChecked(boolean checked) {
        ImageView tb = (ImageView) findViewById(R.id.iv_power) ;

        tb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mIsChecked == true) {
                    tb.setImageResource(R.drawable.ic_on);
                    mIsChecked = false;
                } else {
                    tb.setImageResource(R.drawable.ic_off);
                    mIsChecked = true;
                }
            }
        });

        // CheckBox 가 아닌 View의 상태 변경.
    }

    @Override
    public boolean isChecked() {
        ImageView tb = (ImageView) findViewById(R.id.iv_power) ;


         return mIsChecked ;
    }

    @Override
    public void toggle() {
        ImageView tb = (ImageView) findViewById(R.id.iv_power) ;

        //setChecked(tv.isChecked() ? false : true) ;
        setChecked(mIsChecked ? false : true) ;
    }
}

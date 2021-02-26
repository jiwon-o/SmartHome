package com.appforest.smarthome;

import android.graphics.drawable.Drawable;

// ListView item of Stats fragment
public class StatsListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String UsageStr;
    private String CostStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }

    public void setTitle(String title) {
        titleStr = title;
    }

    public void setDesc(String desc) {
        UsageStr = desc;
    }

    public void setDesc2(String desc2) {
        CostStr = desc2;
    }

    public Drawable getIcon() {
        return this.iconDrawable;
    }

    public String getTitle() {
        return this.titleStr;
    }

    public String getUsage() {
        return this.UsageStr;
    }

    public String getCost() {
        return this.CostStr;
    }

}
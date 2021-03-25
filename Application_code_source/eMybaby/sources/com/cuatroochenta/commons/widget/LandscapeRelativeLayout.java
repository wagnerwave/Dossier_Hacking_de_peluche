package com.cuatroochenta.commons.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class LandscapeRelativeLayout extends RelativeLayout {
    public LandscapeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (getMeasuredWidth() * 9) / 16);
    }
}

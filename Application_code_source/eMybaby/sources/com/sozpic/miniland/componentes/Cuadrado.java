package com.sozpic.miniland.componentes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class Cuadrado extends LinearLayout {
    public Cuadrado(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }
}

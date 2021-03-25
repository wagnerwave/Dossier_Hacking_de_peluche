package com.cuatroochenta.miniland.humidificador.device;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan extends SuperscriptSpan {

    /* renamed from: a  reason: collision with root package name */
    public int f3906a = 4;

    /* renamed from: b  reason: collision with root package name */
    public float f3907b = 0.0f;

    public TopAlignSuperscriptSpan(float f) {
        double d2 = (double) f;
        if (d2 > 0.0d && d2 < 1.0d) {
            this.f3907b = f;
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        float ascent = textPaint.ascent();
        textPaint.setTextSize(textPaint.getTextSize() / ((float) this.f3906a));
        float f = textPaint.getFontMetrics().ascent;
        float f2 = this.f3907b;
        textPaint.baselineShift = (int) (((ascent - (ascent * f2)) - (f - (f2 * f))) + ((float) textPaint.baselineShift));
    }

    public void updateMeasureState(TextPaint textPaint) {
        updateDrawState(textPaint);
    }
}

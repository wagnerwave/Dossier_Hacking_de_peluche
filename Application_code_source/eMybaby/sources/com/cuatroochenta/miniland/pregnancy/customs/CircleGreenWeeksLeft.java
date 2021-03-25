package com.cuatroochenta.miniland.pregnancy.customs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sozpic.miniland.R;
import java.util.Locale;

public class CircleGreenWeeksLeft extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f3991a = ((TextView) findViewById(R.id.circle_green_text_weeks));

    /* renamed from: b  reason: collision with root package name */
    public TextView f3992b = ((TextView) findViewById(R.id.circle_green_text_semanas_hoy));

    /* renamed from: c  reason: collision with root package name */
    public TextView f3993c = ((TextView) findViewById(R.id.circle_green_text_days));

    public CircleGreenWeeksLeft(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(LayoutInflater.from(getContext()).inflate(R.layout.layout_circle_green_weeks_left, this, false));
    }

    public void setDays(int i) {
        this.f3993c.setText(String.valueOf(i));
    }

    public void setSemanasHoyText(String str) {
        this.f3992b.setText(str);
    }

    public void setWeeks(int i) {
        this.f3991a.setText(String.format(Locale.getDefault(), "%02d", new Object[]{Integer.valueOf(i)}));
    }
}

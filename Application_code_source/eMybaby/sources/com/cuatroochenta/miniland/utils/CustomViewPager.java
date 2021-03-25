package com.cuatroochenta.miniland.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4084a = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f4084a && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f4084a && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.f4084a = z;
    }
}

package com.antonyt.infiniteviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import b.a.a;
import java.util.ArrayList;

public class InfiniteViewPager extends ViewPager {
    public static final int OFFSET = 1000;
    public ArrayList<a> datesInMonth;
    public boolean enabled = true;
    public int rowHeight = 0;
    public boolean sixWeeksInCalendar = false;

    public InfiniteViewPager(Context context) {
        super(context);
    }

    public InfiniteViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArrayList<a> getDatesInMonth() {
        return this.datesInMonth;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isSixWeeksInCalendar() {
        return this.sixWeeksInCalendar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = this.datesInMonth.size() / 7;
        boolean z = View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE;
        int measuredHeight = getMeasuredHeight();
        if (z && this.rowHeight == 0) {
            i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE));
                this.rowHeight = childAt.getMeasuredHeight() / size;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((this.sixWeeksInCalendar ? this.rowHeight * 6 : this.rowHeight * size) + 3, 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.enabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        setCurrentItem(1000);
    }

    public void setDatesInMonth(ArrayList<a> arrayList) {
        this.datesInMonth = arrayList;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setSixWeeksInCalendar(boolean z) {
        this.sixWeeksInCalendar = z;
        this.rowHeight = 0;
    }
}

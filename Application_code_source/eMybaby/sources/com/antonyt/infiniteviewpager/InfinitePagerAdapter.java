package com.antonyt.infiniteviewpager;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

public class InfinitePagerAdapter extends PagerAdapter {
    public PagerAdapter adapter;

    public InfinitePagerAdapter(PagerAdapter pagerAdapter) {
        this.adapter = pagerAdapter;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.adapter.destroyItem(viewGroup, i % getRealCount(), obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.adapter.finishUpdate(viewGroup);
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public int getRealCount() {
        return this.adapter.getCount();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return this.adapter.instantiateItem(viewGroup, i % getRealCount());
    }

    public boolean isViewFromObject(View view, Object obj) {
        return this.adapter.isViewFromObject(view, obj);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.adapter.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.adapter.saveState();
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.adapter.startUpdate(viewGroup);
    }
}

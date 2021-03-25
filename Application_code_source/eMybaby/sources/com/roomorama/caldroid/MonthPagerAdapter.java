package com.roomorama.caldroid;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class MonthPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<DateGridFragment> fragments;

    public MonthPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public int getCount() {
        return 4;
    }

    public ArrayList<DateGridFragment> getFragments() {
        if (this.fragments == null) {
            this.fragments = new ArrayList<>();
            for (int i = 0; i < getCount(); i++) {
                this.fragments.add(new DateGridFragment());
            }
        }
        return this.fragments;
    }

    public Fragment getItem(int i) {
        return getFragments().get(i);
    }

    public void setFragments(ArrayList<DateGridFragment> arrayList) {
        this.fragments = arrayList;
    }
}

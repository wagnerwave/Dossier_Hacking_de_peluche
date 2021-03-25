package com.roomorama.caldroid;

import android.view.View;
import java.util.Date;

public abstract class CaldroidListener {
    public void onCaldroidViewCreated() {
    }

    public void onChangeMonth(int i, int i2) {
    }

    public void onLongClickDate(Date date, View view) {
    }

    public abstract void onSelectDate(Date date, View view);
}

package com.roomorama.caldroid;

import a.b.b;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class WeekdayArrayAdapter extends ArrayAdapter<String> {
    public static int textColor = -3355444;
    public Context context;

    public WeekdayArrayAdapter(Context context2, int i, List<String> list) {
        super(context2, i, list);
        this.context = context2;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        String str = (String) getItem(i);
        textView.setTextSize(0, this.context.getResources().getDimension(b.fuente_home));
        textView.setTextColor(textColor);
        textView.setGravity(17);
        return textView;
    }

    public boolean isEnabled(int i) {
        return false;
    }
}

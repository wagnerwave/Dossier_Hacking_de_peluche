package com.roomorama.caldroid;

import a.b.c;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import b.a.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class CaldroidGridAdapter extends BaseAdapter {
    public HashMap<String, Object> caldroidData;
    public Context context;
    public ArrayList<a> datetimeList;
    public ArrayList<a> disableDates;
    public HashMap<a, Integer> disableDatesMap = new HashMap<>();
    public HashMap<String, Object> extraData;
    public a maxDateTime;
    public a minDateTime;
    public int month;
    public Resources resources;
    public ArrayList<a> selectedDates;
    public HashMap<a, Integer> selectedDatesMap = new HashMap<>();
    public boolean sixWeeksInCalendar;
    public int startDayOfWeek;
    public a today;
    public int year;

    public CaldroidGridAdapter(Context context2, int i, int i2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        this.month = i;
        this.year = i2;
        this.context = context2;
        this.caldroidData = hashMap;
        this.extraData = hashMap2;
        this.resources = context2.getResources();
        populateFromCaldroidData();
    }

    private void populateFromCaldroidData() {
        ArrayList<a> arrayList = (ArrayList) this.caldroidData.get(CaldroidFragment.DISABLE_DATES);
        this.disableDates = arrayList;
        if (arrayList != null) {
            this.disableDatesMap.clear();
            Iterator<a> it = this.disableDates.iterator();
            while (it.hasNext()) {
                this.disableDatesMap.put(it.next(), 1);
            }
        }
        ArrayList<a> arrayList2 = (ArrayList) this.caldroidData.get(CaldroidFragment.SELECTED_DATES);
        this.selectedDates = arrayList2;
        if (arrayList2 != null) {
            this.selectedDatesMap.clear();
            Iterator<a> it2 = this.selectedDates.iterator();
            while (it2.hasNext()) {
                this.selectedDatesMap.put(it2.next(), 1);
            }
        }
        this.minDateTime = (a) this.caldroidData.get(CaldroidFragment._MIN_DATE_TIME);
        this.maxDateTime = (a) this.caldroidData.get(CaldroidFragment._MAX_DATE_TIME);
        this.startDayOfWeek = ((Integer) this.caldroidData.get(CaldroidFragment.START_DAY_OF_WEEK)).intValue();
        boolean booleanValue = ((Boolean) this.caldroidData.get(CaldroidFragment.SIX_WEEKS_IN_CALENDAR)).booleanValue();
        this.sixWeeksInCalendar = booleanValue;
        this.datetimeList = CalendarHelper.getFullWeeks(this.month, this.year, this.startDayOfWeek, booleanValue);
    }

    public void customizeTextView(int i, TextView textView) {
        boolean z;
        a aVar;
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        a aVar2 = this.datetimeList.get(i);
        aVar2.n();
        if (aVar2.f3723b.intValue() != this.month) {
            textView.setTextColor(this.resources.getColor(a.b.a.caldroid_darker_gray));
        }
        a aVar3 = this.minDateTime;
        boolean z2 = true;
        if ((aVar3 == null || !aVar2.t(aVar3)) && (((aVar = this.maxDateTime) == null || !aVar2.s(aVar)) && (this.disableDates == null || !this.disableDatesMap.containsKey(aVar2)))) {
            z = true;
        } else {
            textView.setTextColor(CaldroidFragment.disabledTextColor);
            int i2 = CaldroidFragment.disabledBackgroundDrawable;
            if (i2 == -1) {
                i2 = c.disable_cell;
            }
            textView.setBackgroundResource(i2);
            if (aVar2.equals(getToday())) {
                textView.setBackgroundResource(a.b.a.lila);
            }
            z = false;
        }
        if (this.selectedDates != null && this.selectedDatesMap.containsKey(aVar2)) {
            int i3 = CaldroidFragment.selectedBackgroundDrawable;
            if (i3 != -1) {
                textView.setBackgroundResource(i3);
            } else {
                textView.setBackgroundColor(this.resources.getColor(a.b.a.caldroid_sky_blue));
            }
            textView.setTextColor(CaldroidFragment.selectedTextColor);
            z2 = false;
        }
        if (z && z2) {
            textView.setBackgroundResource(aVar2.equals(getToday()) ? a.b.a.lila : c.cell_bg);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        aVar2.n();
        sb.append(aVar2.f3724c);
        textView.setText(sb.toString());
        setCustomResources(aVar2, textView, textView);
    }

    public HashMap<String, Object> getCaldroidData() {
        return this.caldroidData;
    }

    public int getCount() {
        return this.datetimeList.size();
    }

    public ArrayList<a> getDatetimeList() {
        return this.datetimeList;
    }

    public ArrayList<a> getDisableDates() {
        return this.disableDates;
    }

    public HashMap<String, Object> getExtraData() {
        return this.extraData;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public a getMaxDateTime() {
        return this.maxDateTime;
    }

    public a getMinDateTime() {
        return this.minDateTime;
    }

    public ArrayList<a> getSelectedDates() {
        return this.selectedDates;
    }

    public a getToday() {
        if (this.today == null) {
            this.today = CalendarHelper.convertDateToDateTime(new Date());
        }
        return this.today;
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r2, android.view.View r3, android.view.ViewGroup r4) {
        /*
            r1 = this;
            android.content.Context r4 = r1.context
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r4 = r4.getSystemService(r0)
            android.view.LayoutInflater r4 = (android.view.LayoutInflater) r4
            r0 = r3
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r3 != 0) goto L_0x0019
            int r3 = a.b.e.date_cell
            r0 = 0
            android.view.View r3 = r4.inflate(r3, r0)
            r0 = r3
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0019:
            r1.customizeTextView(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.roomorama.caldroid.CaldroidGridAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void setAdapterDateTime(a aVar) {
        aVar.n();
        this.month = aVar.f3723b.intValue();
        aVar.n();
        int intValue = aVar.f3722a.intValue();
        this.year = intValue;
        this.datetimeList = CalendarHelper.getFullWeeks(this.month, intValue, this.startDayOfWeek, this.sixWeeksInCalendar);
    }

    public void setCaldroidData(HashMap<String, Object> hashMap) {
        this.caldroidData = hashMap;
        populateFromCaldroidData();
    }

    public void setCustomResources(a aVar, View view, TextView textView) {
        Integer num;
        HashMap hashMap = (HashMap) this.caldroidData.get(CaldroidFragment._BACKGROUND_FOR_DATETIME_MAP);
        if (!(hashMap == null || ((Integer) hashMap.get(aVar)) == null)) {
            view.setBackgroundResource(c.rosa_selected);
        }
        HashMap hashMap2 = (HashMap) this.caldroidData.get(CaldroidFragment._TEXT_COLOR_FOR_DATETIME_MAP);
        if (hashMap2 != null && (num = (Integer) hashMap2.get(aVar)) != null) {
            textView.setTextColor(this.resources.getColor(num.intValue()));
        }
    }

    public void setDisableDates(ArrayList<a> arrayList) {
        this.disableDates = arrayList;
    }

    public void setExtraData(HashMap<String, Object> hashMap) {
        this.extraData = hashMap;
    }

    public void setMaxDateTime(a aVar) {
        this.maxDateTime = aVar;
    }

    public void setMinDateTime(a aVar) {
        this.minDateTime = aVar;
    }

    public void setSelectedDates(ArrayList<a> arrayList) {
        this.selectedDates = arrayList;
    }

    public void updateToday() {
        this.today = CalendarHelper.convertDateToDateTime(new Date());
    }
}

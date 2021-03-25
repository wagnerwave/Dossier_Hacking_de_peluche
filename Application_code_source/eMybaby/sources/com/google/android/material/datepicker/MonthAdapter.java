package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import androidx.annotation.Nullable;

public class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;

    public MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    public int getCount() {
        return firstPositionInMonth() + this.month.daysInMonth;
    }

    @Nullable
    public Long getItem(int i) {
        if (i < this.month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i)));
    }

    public long getItemId(int i) {
        return (long) (i / this.month.daysInWeek);
    }

    /* JADX WARNING: type inference failed for: r7v20, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.initializeStyles(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x001e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001e:
            int r7 = r5.firstPositionInMonth()
            int r7 = r6 - r7
            r8 = 1
            if (r7 < 0) goto L_0x005e
            com.google.android.material.datepicker.Month r2 = r5.month
            int r3 = r2.daysInMonth
            if (r7 < r3) goto L_0x002e
            goto L_0x005e
        L_0x002e:
            int r7 = r7 + r8
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.setText(r2)
            com.google.android.material.datepicker.Month r2 = r5.month
            long r2 = r2.getDay(r7)
            com.google.android.material.datepicker.Month r7 = r5.month
            int r7 = r7.year
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.current()
            int r4 = r4.year
            if (r7 != r4) goto L_0x0050
            java.lang.String r7 = com.google.android.material.datepicker.DateStrings.getMonthDayOfWeekDay(r2)
            goto L_0x0054
        L_0x0050:
            java.lang.String r7 = com.google.android.material.datepicker.DateStrings.getYearMonthDayOfWeekDay(r2)
        L_0x0054:
            r0.setContentDescription(r7)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L_0x0066
        L_0x005e:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L_0x0066:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x006d
            return r0
        L_0x006d:
            com.google.android.material.datepicker.CalendarConstraints r7 = r5.calendarConstraints
            com.google.android.material.datepicker.CalendarConstraints$DateValidator r7 = r7.getDateValidator()
            long r2 = r6.longValue()
            boolean r7 = r7.isValid(r2)
            if (r7 == 0) goto L_0x00cc
            r0.setEnabled(r8)
            com.google.android.material.datepicker.DateSelector<?> r7 = r5.dateSelector
            java.util.Collection r7 = r7.getSelectedDays()
            java.util.Iterator r7 = r7.iterator()
        L_0x008a:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b2
            java.lang.Object r8 = r7.next()
            java.lang.Long r8 = (java.lang.Long) r8
            long r1 = r8.longValue()
            long r3 = r6.longValue()
            long r3 = com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(r3)
            long r1 = com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(r1)
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x008a
            com.google.android.material.datepicker.CalendarStyle r6 = r5.calendarStyle
            com.google.android.material.datepicker.CalendarItemStyle r6 = r6.selectedDay
        L_0x00ae:
            r6.styleItem(r0)
            return r0
        L_0x00b2:
            java.util.Calendar r7 = com.google.android.material.datepicker.UtcDates.getTodayCalendar()
            long r7 = r7.getTimeInMillis()
            long r1 = r6.longValue()
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x00c7
            com.google.android.material.datepicker.CalendarStyle r6 = r5.calendarStyle
            com.google.android.material.datepicker.CalendarItemStyle r6 = r6.todayDay
            goto L_0x00ae
        L_0x00c7:
            com.google.android.material.datepicker.CalendarStyle r6 = r5.calendarStyle
            com.google.android.material.datepicker.CalendarItemStyle r6 = r6.day
            goto L_0x00ae
        L_0x00cc:
            r0.setEnabled(r1)
            com.google.android.material.datepicker.CalendarStyle r6 = r5.calendarStyle
            com.google.android.material.datepicker.CalendarItemStyle r6 = r6.invalidDay
            goto L_0x00ae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isFirstInRow(int i) {
        return i % this.month.daysInWeek == 0;
    }

    public boolean isLastInRow(int i) {
        return (i + 1) % this.month.daysInWeek == 0;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int i) {
        return (i - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public boolean withinMonth(int i) {
        return i >= firstPositionInMonth() && i <= lastPositionInMonth();
    }
}

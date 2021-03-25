package com.roomorama.caldroid;

import a.b.d;
import a.b.e;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import b.a.a;
import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.antonyt.infiniteviewpager.InfiniteViewPager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

@SuppressLint({"DefaultLocale"})
public class CaldroidFragment extends DialogFragment {
    public static final String DIALOG_TITLE = "dialogTitle";
    public static final String DISABLE_DATES = "disableDates";
    public static final String ENABLE_CLICK_ON_DISABLED_DATES = "enableClickOnDisabledDates";
    public static final String ENABLE_SWIPE = "enableSwipe";
    public static int FRIDAY = 6;
    public static final String MAX_DATE = "maxDate";
    public static final String MIN_DATE = "minDate";
    public static int MONDAY = 2;
    public static final String MONTH = "month";
    public static final int MONTH_YEAR_FLAG = 52;
    public static final int NUMBER_OF_PAGES = 4;
    public static int SATURDAY = 7;
    public static final String SELECTED_DATES = "selectedDates";
    public static final String SHOW_NAVIGATION_ARROWS = "showNavigationArrows";
    public static final String SIX_WEEKS_IN_CALENDAR = "sixWeeksInCalendar";
    public static final String START_DAY_OF_WEEK = "startDayOfWeek";
    public static int SUNDAY = 1;
    public static int THURSDAY = 5;
    public static int TUESDAY = 3;
    public static int WEDNESDAY = 4;
    public static final String YEAR = "year";
    public static final String _BACKGROUND_FOR_DATETIME_MAP = "_backgroundForDateTimeMap";
    public static final String _MAX_DATE_TIME = "_maxDateTime";
    public static final String _MIN_DATE_TIME = "_minDateTime";
    public static final String _TEXT_COLOR_FOR_DATETIME_MAP = "_textColorForDateTimeMap";
    public static int disabledBackgroundDrawable = -1;
    public static int disabledTextColor = -7829368;
    public static int selectedBackgroundDrawable = -1;
    public static int selectedTextColor = -16777216;
    public String TAG = "CaldroidFragment";
    public HashMap<a, Integer> backgroundForDateTimeMap = new HashMap<>();
    public HashMap<String, Object> caldroidData = new HashMap<>();
    public CaldroidListener caldroidListener;
    public ArrayList<a> dateInMonthsList;
    public AdapterView.OnItemClickListener dateItemClickListener;
    public AdapterView.OnItemLongClickListener dateItemLongClickListener;
    public ArrayList<CaldroidGridAdapter> datePagerAdapters = new ArrayList<>();
    public InfiniteViewPager dateViewPager;
    public String dialogTitle;
    public ArrayList<a> disableDates = new ArrayList<>();
    public boolean enableClickOnDisabledDates = false;
    public boolean enableSwipe = true;
    public HashMap<String, Object> extraData = new HashMap<>();
    public Time firstMonthTime = new Time();
    public ArrayList<DateGridFragment> fragments;
    public Button leftArrowButton;
    public a maxDateTime;
    public a minDateTime;
    public int month = -1;
    public TextView monthTitleTextView;
    public Formatter monthYearFormatter = new Formatter(this.monthYearStringBuilder, Locale.getDefault());
    public final StringBuilder monthYearStringBuilder = new StringBuilder(50);
    public DatePageChangeListener pageChangeListener;
    public Button rightArrowButton;
    public ArrayList<a> selectedDates = new ArrayList<>();
    public boolean showNavigationArrows = true;
    public boolean sixWeeksInCalendar = true;
    public int startDayOfWeek = SUNDAY;
    public HashMap<a, Integer> textColorForDateTimeMap = new HashMap<>();
    public GridView weekdayGridView;
    public int year = -1;

    public class DatePageChangeListener implements ViewPager.OnPageChangeListener {
        public ArrayList<CaldroidGridAdapter> caldroidGridAdapters;
        public a currentDateTime;
        public int currentPage = 1000;

        public DatePageChangeListener() {
        }

        private int getNext(int i) {
            return (i + 1) % 4;
        }

        private int getPrevious(int i) {
            return (i + 3) % 4;
        }

        public ArrayList<CaldroidGridAdapter> getCaldroidGridAdapters() {
            return this.caldroidGridAdapters;
        }

        public int getCurrent(int i) {
            return i % 4;
        }

        public a getCurrentDateTime() {
            return this.currentDateTime;
        }

        public int getCurrentPage() {
            return this.currentPage;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            refreshAdapters(i);
            CaldroidFragment.this.setCalendarDateTime(this.currentDateTime);
            CaldroidFragment.this.dateInMonthsList.clear();
            CaldroidFragment.this.dateInMonthsList.addAll(this.caldroidGridAdapters.get(i % 4).getDatetimeList());
        }

        public void refreshAdapters(int i) {
            Integer num;
            Integer num2;
            Integer num3;
            Integer num4;
            Integer num5;
            Integer num6;
            Integer num7;
            a.C0089a aVar;
            a v;
            a.C0089a aVar2 = a.C0089a.LastDay;
            CaldroidGridAdapter caldroidGridAdapter = this.caldroidGridAdapters.get(getCurrent(i));
            CaldroidGridAdapter caldroidGridAdapter2 = this.caldroidGridAdapters.get(getPrevious(i));
            CaldroidGridAdapter caldroidGridAdapter3 = this.caldroidGridAdapters.get(getNext(i));
            int i2 = this.currentPage;
            if (i == i2) {
                caldroidGridAdapter.setAdapterDateTime(this.currentDateTime);
                caldroidGridAdapter.notifyDataSetChanged();
                num = 0;
                num2 = 1;
                num3 = 0;
                num4 = 0;
                num5 = 0;
                num6 = 0;
                num7 = 0;
                aVar = aVar2;
                caldroidGridAdapter2.setAdapterDateTime(this.currentDateTime.u((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar));
                caldroidGridAdapter2.notifyDataSetChanged();
                v = this.currentDateTime;
            } else {
                a aVar3 = this.currentDateTime;
                if (i > i2) {
                    num = 0;
                    num2 = 1;
                    num3 = 0;
                    num4 = 0;
                    num5 = 0;
                    num6 = 0;
                    num7 = 0;
                    aVar = aVar2;
                    v = aVar3.v((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar);
                    this.currentDateTime = v;
                } else {
                    a.C0089a aVar4 = aVar2;
                    a u = aVar3.u((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar4);
                    this.currentDateTime = u;
                    caldroidGridAdapter2.setAdapterDateTime(u.u((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar4));
                    caldroidGridAdapter2.notifyDataSetChanged();
                    this.currentPage = i;
                }
            }
            caldroidGridAdapter3.setAdapterDateTime(v.v(num, num2, num3, num4, num5, num6, num7, aVar));
            caldroidGridAdapter3.notifyDataSetChanged();
            this.currentPage = i;
        }

        public void setCaldroidGridAdapters(ArrayList<CaldroidGridAdapter> arrayList) {
            this.caldroidGridAdapters = arrayList;
        }

        public void setCurrentDateTime(a aVar) {
            this.currentDateTime = aVar;
            CaldroidFragment.this.setCalendarDateTime(aVar);
        }

        public void setCurrentPage(int i) {
            this.currentPage = i;
        }
    }

    private AdapterView.OnItemClickListener getDateItemClickListener() {
        if (this.dateItemClickListener == null) {
            this.dateItemClickListener = new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    a aVar = CaldroidFragment.this.dateInMonthsList.get(i);
                    if (CaldroidFragment.this.caldroidListener != null) {
                        CaldroidFragment caldroidFragment = CaldroidFragment.this;
                        if (!caldroidFragment.enableClickOnDisabledDates) {
                            a aVar2 = caldroidFragment.minDateTime;
                            if (aVar2 == null || !aVar.t(aVar2)) {
                                a aVar3 = CaldroidFragment.this.maxDateTime;
                                if (aVar3 == null || !aVar.s(aVar3)) {
                                    ArrayList<a> arrayList = CaldroidFragment.this.disableDates;
                                    if (!(arrayList == null || arrayList.indexOf(aVar) == -1)) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        CaldroidFragment.this.caldroidListener.onSelectDate(CalendarHelper.convertDateTimeToDate(aVar), view);
                    }
                }
            };
        }
        return this.dateItemClickListener;
    }

    private AdapterView.OnItemLongClickListener getDateItemLongClickListener() {
        if (this.dateItemLongClickListener == null) {
            this.dateItemLongClickListener = new AdapterView.OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    a aVar = CaldroidFragment.this.dateInMonthsList.get(i);
                    if (CaldroidFragment.this.caldroidListener == null) {
                        return true;
                    }
                    CaldroidFragment caldroidFragment = CaldroidFragment.this;
                    if (!caldroidFragment.enableClickOnDisabledDates) {
                        a aVar2 = caldroidFragment.minDateTime;
                        if (aVar2 != null && aVar.t(aVar2)) {
                            return false;
                        }
                        a aVar3 = CaldroidFragment.this.maxDateTime;
                        if (aVar3 != null && aVar.s(aVar3)) {
                            return false;
                        }
                        ArrayList<a> arrayList = CaldroidFragment.this.disableDates;
                        if (!(arrayList == null || arrayList.indexOf(aVar) == -1)) {
                            return false;
                        }
                    }
                    CaldroidFragment.this.caldroidListener.onLongClickDate(CalendarHelper.convertDateTimeToDate(aVar), view);
                    return true;
                }
            };
        }
        return this.dateItemLongClickListener;
    }

    public static CaldroidFragment newInstance(String str, int i, int i2) {
        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DIALOG_TITLE, str);
        bundle.putInt(MONTH, i);
        bundle.putInt(YEAR, i2);
        caldroidFragment.setArguments(bundle);
        return caldroidFragment;
    }

    private void setupDateGridPages(View view) {
        a.C0089a aVar = a.C0089a.LastDay;
        a aVar2 = new a(Integer.valueOf(this.year), Integer.valueOf(this.month), 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null);
        DatePageChangeListener datePageChangeListener = new DatePageChangeListener();
        this.pageChangeListener = datePageChangeListener;
        datePageChangeListener.setCurrentDateTime(aVar2);
        aVar2.n();
        int intValue = aVar2.f3723b.intValue();
        aVar2.n();
        CaldroidGridAdapter newDatesGridAdapter = getNewDatesGridAdapter(intValue, aVar2.f3722a.intValue());
        this.dateInMonthsList = newDatesGridAdapter.getDatetimeList();
        a v = aVar2.v((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar);
        v.n();
        int intValue2 = v.f3723b.intValue();
        v.n();
        CaldroidGridAdapter newDatesGridAdapter2 = getNewDatesGridAdapter(intValue2, v.f3722a.intValue());
        a v2 = v.v((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar);
        v2.n();
        int intValue3 = v2.f3723b.intValue();
        v2.n();
        a u = aVar2.u((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, aVar);
        u.n();
        int intValue4 = u.f3723b.intValue();
        u.n();
        CaldroidGridAdapter newDatesGridAdapter3 = getNewDatesGridAdapter(intValue4, u.f3722a.intValue());
        this.datePagerAdapters.add(newDatesGridAdapter);
        this.datePagerAdapters.add(newDatesGridAdapter2);
        this.datePagerAdapters.add(getNewDatesGridAdapter(intValue3, v2.f3722a.intValue()));
        this.datePagerAdapters.add(newDatesGridAdapter3);
        this.pageChangeListener.setCaldroidGridAdapters(this.datePagerAdapters);
        InfiniteViewPager infiniteViewPager = (InfiniteViewPager) view.findViewById(d.months_infinite_pager);
        this.dateViewPager = infiniteViewPager;
        infiniteViewPager.setEnabled(this.enableSwipe);
        this.dateViewPager.setSixWeeksInCalendar(this.sixWeeksInCalendar);
        this.dateViewPager.setDatesInMonth(this.dateInMonthsList);
        MonthPagerAdapter monthPagerAdapter = new MonthPagerAdapter(getChildFragmentManager());
        this.fragments = monthPagerAdapter.getFragments();
        for (int i = 0; i < 4; i++) {
            DateGridFragment dateGridFragment = this.fragments.get(i);
            dateGridFragment.setGridAdapter(this.datePagerAdapters.get(i));
            dateGridFragment.setOnItemClickListener(getDateItemClickListener());
            dateGridFragment.setOnItemLongClickListener(getDateItemLongClickListener());
        }
        this.dateViewPager.setAdapter(new InfinitePagerAdapter(monthPagerAdapter));
        this.dateViewPager.setOnPageChangeListener(this.pageChangeListener);
    }

    public void cleanBG() {
        this.backgroundForDateTimeMap.clear();
        this.textColorForDateTimeMap.clear();
    }

    public void clearDisableDates() {
        this.disableDates.clear();
    }

    public void clearSelectedDates() {
        this.selectedDates.clear();
    }

    public HashMap<String, Object> getCaldroidData() {
        this.caldroidData.clear();
        this.caldroidData.put(DISABLE_DATES, this.disableDates);
        this.caldroidData.put(SELECTED_DATES, this.selectedDates);
        this.caldroidData.put(_MIN_DATE_TIME, this.minDateTime);
        this.caldroidData.put(_MAX_DATE_TIME, this.maxDateTime);
        this.caldroidData.put(START_DAY_OF_WEEK, Integer.valueOf(this.startDayOfWeek));
        this.caldroidData.put(SIX_WEEKS_IN_CALENDAR, Boolean.valueOf(this.sixWeeksInCalendar));
        this.caldroidData.put(_BACKGROUND_FOR_DATETIME_MAP, this.backgroundForDateTimeMap);
        this.caldroidData.put(_TEXT_COLOR_FOR_DATETIME_MAP, this.textColorForDateTimeMap);
        return this.caldroidData;
    }

    public CaldroidListener getCaldroidListener() {
        return this.caldroidListener;
    }

    public int getCurrentVirtualPosition() {
        return this.pageChangeListener.getCurrent(this.dateViewPager.getCurrentItem());
    }

    public ArrayList<CaldroidGridAdapter> getDatePagerAdapters() {
        return this.datePagerAdapters;
    }

    public ArrayList<String> getDaysOfWeek() {
        ArrayList<String> arrayList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        a w = new a(2013, 2, 17, (Integer) null, (Integer) null, (Integer) null, 0).w(Integer.valueOf(this.startDayOfWeek - SUNDAY));
        for (int i = 0; i < 7; i++) {
            arrayList.add(simpleDateFormat.format(CalendarHelper.convertDateTimeToDate(w)).toUpperCase().substring(0, 1));
            w = w.w(1);
        }
        return arrayList;
    }

    public HashMap<String, Object> getExtraData() {
        return this.extraData;
    }

    public ArrayList<DateGridFragment> getFragments() {
        return this.fragments;
    }

    public Button getLeftArrowButton() {
        return this.leftArrowButton;
    }

    public TextView getMonthTitleTextView() {
        return this.monthTitleTextView;
    }

    public CaldroidGridAdapter getNewDatesGridAdapter(int i, int i2) {
        return new CaldroidGridAdapter(getActivity(), i, i2, getCaldroidData(), this.extraData);
    }

    public WeekdayArrayAdapter getNewWeekdayAdapter() {
        return new WeekdayArrayAdapter(getActivity(), 17367043, getDaysOfWeek());
    }

    public Button getRightArrowButton() {
        return this.rightArrowButton;
    }

    public Bundle getSavedStates() {
        Bundle bundle = new Bundle();
        bundle.putInt(MONTH, this.month);
        bundle.putInt(YEAR, this.year);
        String str = this.dialogTitle;
        if (str != null) {
            bundle.putString(DIALOG_TITLE, str);
        }
        ArrayList<a> arrayList = this.selectedDates;
        if (arrayList != null && arrayList.size() > 0) {
            bundle.putStringArrayList(SELECTED_DATES, CalendarHelper.convertToStringList(this.selectedDates));
        }
        ArrayList<a> arrayList2 = this.disableDates;
        if (arrayList2 != null && arrayList2.size() > 0) {
            bundle.putStringArrayList(DISABLE_DATES, CalendarHelper.convertToStringList(this.disableDates));
        }
        a aVar = this.minDateTime;
        if (aVar != null) {
            bundle.putString(MIN_DATE, aVar.o("YYYY-MM-DD"));
        }
        a aVar2 = this.maxDateTime;
        if (aVar2 != null) {
            bundle.putString(MAX_DATE, aVar2.o("YYYY-MM-DD"));
        }
        bundle.putBoolean(SHOW_NAVIGATION_ARROWS, this.showNavigationArrows);
        bundle.putBoolean(ENABLE_SWIPE, this.enableSwipe);
        bundle.putInt(START_DAY_OF_WEEK, this.startDayOfWeek);
        bundle.putBoolean(SIX_WEEKS_IN_CALENDAR, this.sixWeeksInCalendar);
        return bundle;
    }

    public GridView getWeekdayGridView() {
        return this.weekdayGridView;
    }

    public boolean isEnableSwipe() {
        return this.enableSwipe;
    }

    public boolean isShowNavigationArrows() {
        return this.showNavigationArrows;
    }

    public boolean isSixWeeksInCalendar() {
        return this.sixWeeksInCalendar;
    }

    public void moveToDate(Date date) {
        moveToDateTime(CalendarHelper.convertDateToDateTime(date));
    }

    public void moveToDateTime(a aVar) {
        InfiniteViewPager infiniteViewPager;
        int i;
        a aVar2 = aVar;
        a.C0089a aVar3 = a.C0089a.LastDay;
        boolean z = false;
        a aVar4 = new a(Integer.valueOf(this.year), Integer.valueOf(this.month), 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null);
        aVar4.m();
        aVar4.m();
        Integer valueOf = Integer.valueOf(a.p(aVar4.f3722a, aVar4.f3723b).intValue());
        aVar4.m();
        a aVar5 = new a(aVar4.f3722a, aVar4.f3723b, valueOf, 23, 59, 59, 999999999);
        if (aVar2.compareTo(aVar4) < 0) {
            this.pageChangeListener.setCurrentDateTime(aVar.v((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, aVar3));
            int currentItem = this.dateViewPager.getCurrentItem();
            this.pageChangeListener.refreshAdapters(currentItem);
            infiniteViewPager = this.dateViewPager;
            i = currentItem - 1;
        } else {
            if (aVar2.compareTo(aVar5) > 0) {
                z = true;
            }
            if (z) {
                this.pageChangeListener.setCurrentDateTime(aVar.u((Integer) null, 1, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, aVar3));
                int currentItem2 = this.dateViewPager.getCurrentItem();
                this.pageChangeListener.refreshAdapters(currentItem2);
                infiniteViewPager = this.dateViewPager;
                i = currentItem2 + 1;
            } else {
                return;
            }
        }
        infiniteViewPager.setCurrentItem(i);
    }

    public void nextMonth() {
        this.dateViewPager.setCurrentItem(this.pageChangeListener.getCurrentPage() + 1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        retrieveInitialArgs();
        if (getDialog() != null) {
            setRetainInstance(true);
        }
        View inflate = layoutInflater.inflate(e.calendar_view, viewGroup, false);
        this.monthTitleTextView = (TextView) inflate.findViewById(d.calendar_month_year_textview);
        this.leftArrowButton = (Button) inflate.findViewById(d.calendar_left_arrow);
        this.rightArrowButton = (Button) inflate.findViewById(d.calendar_right_arrow);
        this.leftArrowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CaldroidFragment.this.prevMonth();
            }
        });
        this.rightArrowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CaldroidFragment.this.nextMonth();
            }
        });
        setShowNavigationArrows(this.showNavigationArrows);
        this.weekdayGridView = (GridView) inflate.findViewById(d.weekday_gridview);
        WeekdayArrayAdapter newWeekdayAdapter = getNewWeekdayAdapter();
        WeekdayArrayAdapter.textColor = -12303292;
        this.weekdayGridView.setAdapter(newWeekdayAdapter);
        setupDateGridPages(inflate);
        refreshView();
        CaldroidListener caldroidListener2 = this.caldroidListener;
        if (caldroidListener2 != null) {
            caldroidListener2.onCaldroidViewCreated();
        }
        return inflate;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void prevMonth() {
        this.dateViewPager.setCurrentItem(this.pageChangeListener.getCurrentPage() - 1);
    }

    public void refreshMonthTitleTextView() {
        Time time = this.firstMonthTime;
        time.year = this.year;
        time.month = this.month - 1;
        time.monthDay = 1;
        long millis = time.toMillis(true);
        this.monthYearStringBuilder.setLength(0);
        this.monthTitleTextView.setText(DateUtils.formatDateRange(getActivity(), this.monthYearFormatter, millis, millis, 52).toString());
    }

    public void refreshView() {
        if (this.month != -1 && this.year != -1) {
            refreshMonthTitleTextView();
            Iterator<CaldroidGridAdapter> it = this.datePagerAdapters.iterator();
            while (it.hasNext()) {
                CaldroidGridAdapter next = it.next();
                next.setCaldroidData(getCaldroidData());
                next.setExtraData(this.extraData);
                next.updateToday();
                next.notifyDataSetChanged();
            }
        }
    }

    public void restoreDialogStatesFromKey(FragmentManager fragmentManager, Bundle bundle, String str, String str2) {
        restoreStatesFromKey(bundle, str);
        CaldroidFragment caldroidFragment = (CaldroidFragment) fragmentManager.findFragmentByTag(str2);
        if (caldroidFragment != null) {
            caldroidFragment.dismiss();
            show(fragmentManager, str2);
        }
    }

    public void restoreStatesFromKey(Bundle bundle, String str) {
        if (bundle != null && bundle.containsKey(str)) {
            setArguments(bundle.getBundle(str));
        }
    }

    public void retrieveInitialArgs() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.month = arguments.getInt(MONTH, -1);
            this.year = arguments.getInt(YEAR, -1);
            this.dialogTitle = arguments.getString(DIALOG_TITLE);
            Dialog dialog = getDialog();
            if (dialog != null) {
                String str = this.dialogTitle;
                if (str != null) {
                    dialog.setTitle(str);
                } else {
                    dialog.requestWindowFeature(1);
                }
            }
            int i = arguments.getInt(START_DAY_OF_WEEK, 1);
            this.startDayOfWeek = i;
            if (i > 7) {
                this.startDayOfWeek = i % 7;
            }
            this.showNavigationArrows = arguments.getBoolean(SHOW_NAVIGATION_ARROWS, true);
            this.enableSwipe = arguments.getBoolean(ENABLE_SWIPE, true);
            this.sixWeeksInCalendar = arguments.getBoolean(SIX_WEEKS_IN_CALENDAR, true);
            this.enableClickOnDisabledDates = arguments.getBoolean(ENABLE_CLICK_ON_DISABLED_DATES, false);
            ArrayList<String> stringArrayList = arguments.getStringArrayList(DISABLE_DATES);
            if (stringArrayList != null && stringArrayList.size() > 0) {
                this.disableDates.clear();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    this.disableDates.add(CalendarHelper.getDateTimeFromString(it.next(), "yyyy-MM-dd"));
                }
            }
            ArrayList<String> stringArrayList2 = arguments.getStringArrayList(SELECTED_DATES);
            if (stringArrayList2 != null && stringArrayList2.size() > 0) {
                this.selectedDates.clear();
                Iterator<String> it2 = stringArrayList2.iterator();
                while (it2.hasNext()) {
                    this.selectedDates.add(CalendarHelper.getDateTimeFromString(it2.next(), "yyyy-MM-dd"));
                }
            }
            String string = arguments.getString(MIN_DATE);
            if (string != null) {
                this.minDateTime = CalendarHelper.getDateTimeFromString(string, (String) null);
            }
            String string2 = arguments.getString(MAX_DATE);
            if (string2 != null) {
                this.maxDateTime = CalendarHelper.getDateTimeFromString(string2, (String) null);
            }
        }
        if (this.month == -1 || this.year == -1) {
            TimeZone timeZone = TimeZone.getDefault();
            long currentTimeMillis = System.currentTimeMillis();
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setTimeInMillis(currentTimeMillis);
            int i2 = gregorianCalendar.get(1);
            int i3 = gregorianCalendar.get(5);
            int i4 = gregorianCalendar.get(11);
            int i5 = gregorianCalendar.get(12);
            int i6 = gregorianCalendar.get(13);
            Integer valueOf = Integer.valueOf(i2);
            Integer valueOf2 = Integer.valueOf(gregorianCalendar.get(2) + 1);
            Integer valueOf3 = Integer.valueOf(i3);
            Integer valueOf4 = Integer.valueOf(i4);
            Integer valueOf5 = Integer.valueOf(i5);
            Integer valueOf6 = Integer.valueOf(i6);
            Integer valueOf7 = Integer.valueOf(gregorianCalendar.get(14) * 1000 * 1000);
            a aVar = r8;
            a aVar2 = new a(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7);
            aVar.n();
            a aVar3 = new a(aVar.f3722a, aVar.f3723b, aVar.f3724c, (Integer) null, (Integer) null, (Integer) null, (Integer) null);
            aVar3.n();
            this.month = aVar3.f3723b.intValue();
            aVar3.n();
            this.year = aVar3.f3722a.intValue();
        }
    }

    public void saveStatesToKey(Bundle bundle, String str) {
        bundle.putBundle(str, getSavedStates());
    }

    public void setBackgroundResourceForDate(int i, Date date) {
        this.backgroundForDateTimeMap.put(CalendarHelper.convertDateToDateTime(date), Integer.valueOf(i));
    }

    public void setBackgroundResourceForDateTime(int i, a aVar) {
        this.backgroundForDateTimeMap.put(aVar, Integer.valueOf(i));
    }

    public void setBackgroundResourceForDateTimes(HashMap<a, Integer> hashMap) {
        this.backgroundForDateTimeMap.putAll(hashMap);
    }

    public void setBackgroundResourceForDates(HashMap<Date, Integer> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            this.backgroundForDateTimeMap.clear();
            for (Date next : hashMap.keySet()) {
                a convertDateToDateTime = CalendarHelper.convertDateToDateTime(next);
                this.backgroundForDateTimeMap.put(convertDateToDateTime, hashMap.get(next));
            }
        }
    }

    public void setCaldroidListener(CaldroidListener caldroidListener2) {
        this.caldroidListener = caldroidListener2;
    }

    public void setCalendarDate(Date date) {
        setCalendarDateTime(CalendarHelper.convertDateToDateTime(date));
    }

    public void setCalendarDateTime(a aVar) {
        aVar.n();
        this.month = aVar.f3723b.intValue();
        aVar.n();
        int intValue = aVar.f3722a.intValue();
        this.year = intValue;
        CaldroidListener caldroidListener2 = this.caldroidListener;
        if (caldroidListener2 != null) {
            caldroidListener2.onChangeMonth(this.month, intValue);
        }
        refreshView();
    }

    public void setDisableDates(ArrayList<Date> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.disableDates.clear();
            Iterator<Date> it = arrayList.iterator();
            while (it.hasNext()) {
                this.disableDates.add(CalendarHelper.convertDateToDateTime(it.next()));
            }
        }
    }

    public void setDisableDatesFromString(ArrayList<String> arrayList) {
        setDisableDatesFromString(arrayList, (String) null);
    }

    public void setDisableDatesFromString(ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            this.disableDates.clear();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.disableDates.add(CalendarHelper.getDateTimeFromString(it.next(), str));
            }
        }
    }

    public void setEnableSwipe(boolean z) {
        this.enableSwipe = z;
        this.dateViewPager.setEnabled(z);
    }

    public void setExtraData(HashMap<String, Object> hashMap) {
        this.extraData = hashMap;
    }

    public void setMaxDate(Date date) {
        this.maxDateTime = date == null ? null : CalendarHelper.convertDateToDateTime(date);
    }

    public void setMaxDateFromString(String str, String str2) {
        if (str == null) {
            setMaxDate((Date) null);
        } else {
            this.maxDateTime = CalendarHelper.getDateTimeFromString(str, str2);
        }
    }

    public void setMinDate(Date date) {
        this.minDateTime = date == null ? null : CalendarHelper.convertDateToDateTime(date);
    }

    public void setMinDateFromString(String str, String str2) {
        if (str == null) {
            setMinDate((Date) null);
        } else {
            this.minDateTime = CalendarHelper.getDateTimeFromString(str, str2);
        }
    }

    public void setMonthTitleTextView(TextView textView) {
        this.monthTitleTextView = textView;
    }

    public void setSelectedDateStrings(String str, String str2, String str3) {
        setSelectedDates(CalendarHelper.getDateFromString(str, str3), CalendarHelper.getDateFromString(str2, str3));
    }

    public void setSelectedDates(Date date, Date date2) {
        if (date != null && date2 != null && !date.after(date2)) {
            this.selectedDates.clear();
            a convertDateToDateTime = CalendarHelper.convertDateToDateTime(date2);
            for (a convertDateToDateTime2 = CalendarHelper.convertDateToDateTime(date); convertDateToDateTime2.t(convertDateToDateTime); convertDateToDateTime2 = convertDateToDateTime2.w(1)) {
                this.selectedDates.add(convertDateToDateTime2);
            }
            this.selectedDates.add(convertDateToDateTime);
        }
    }

    public void setShowNavigationArrows(boolean z) {
        Button button;
        int i;
        this.showNavigationArrows = z;
        if (z) {
            button = this.leftArrowButton;
            i = 0;
        } else {
            button = this.leftArrowButton;
            i = 4;
        }
        button.setVisibility(i);
        this.rightArrowButton.setVisibility(i);
    }

    public void setSixWeeksInCalendar(boolean z) {
        this.sixWeeksInCalendar = z;
        this.dateViewPager.setSixWeeksInCalendar(z);
    }

    public void setTextColorForDate(int i, Date date) {
        this.textColorForDateTimeMap.put(CalendarHelper.convertDateToDateTime(date), Integer.valueOf(i));
    }

    public void setTextColorForDateTime(int i, a aVar) {
        this.textColorForDateTimeMap.put(aVar, Integer.valueOf(i));
    }

    public void setTextColorForDateTimes(HashMap<a, Integer> hashMap) {
        this.textColorForDateTimeMap.putAll(hashMap);
    }

    public void setTextColorForDates(HashMap<Date, Integer> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            this.textColorForDateTimeMap.clear();
            for (Date next : hashMap.keySet()) {
                a convertDateToDateTime = CalendarHelper.convertDateToDateTime(next);
                this.textColorForDateTimeMap.put(convertDateToDateTime, hashMap.get(next));
            }
        }
    }
}

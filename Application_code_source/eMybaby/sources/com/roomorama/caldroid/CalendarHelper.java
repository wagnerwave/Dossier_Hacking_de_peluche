package com.roomorama.caldroid;

import b.a.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class CalendarHelper {
    public static SimpleDateFormat MMMFormat = new SimpleDateFormat("MMM", Locale.getDefault());
    public static SimpleDateFormat yyyyMMddFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public static Date convertDateTimeToDate(a aVar) {
        aVar.n();
        int intValue = aVar.f3722a.intValue();
        aVar.n();
        int intValue2 = aVar.f3723b.intValue();
        aVar.n();
        int intValue3 = aVar.f3724c.intValue();
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(intValue, intValue2 - 1, intValue3);
        return instance.getTime();
    }

    public static a convertDateToDateTime(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.setTime(date);
        return new a(Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), (Integer) null, (Integer) null, (Integer) null, 0);
    }

    public static ArrayList<String> convertToStringList(ArrayList<a> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().o("YYYY-MM-DD"));
        }
        return arrayList2;
    }

    public static Date getDateFromString(String str, String str2) {
        return (str2 == null ? yyyyMMddFormat : new SimpleDateFormat(str2, Locale.ENGLISH)).parse(str);
    }

    public static a getDateTimeFromString(String str, String str2) {
        try {
            return convertDateToDateTime(getDateFromString(str, str2));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<a> getFullWeeks(int i, int i2, int i3, boolean z) {
        a w;
        ArrayList<a> arrayList = new ArrayList<>();
        Integer valueOf = Integer.valueOf(i2);
        Integer valueOf2 = Integer.valueOf(i);
        int i4 = 0;
        a aVar = new a(valueOf, valueOf2, 1, (Integer) null, (Integer) null, (Integer) null, 0);
        aVar.m();
        a w2 = aVar.w(Integer.valueOf(a.p(aVar.f3722a, aVar.f3723b).intValue() - 1));
        int intValue = aVar.r().intValue();
        if (intValue < i3) {
            intValue += 7;
        }
        while (intValue > 0) {
            a w3 = aVar.w(Integer.valueOf(Integer.valueOf(intValue - i3).intValue() * -1));
            if (!(w3.compareTo(aVar) < 0)) {
                break;
            }
            arrayList.add(w3);
            intValue--;
        }
        while (true) {
            w2.n();
            if (i4 >= w2.f3724c.intValue()) {
                break;
            }
            arrayList.add(aVar.w(Integer.valueOf(i4)));
            i4++;
        }
        int i5 = i3 - 1;
        if (i5 == 0) {
            i5 = 7;
        }
        if (w2.r().intValue() != i5) {
            int i6 = 1;
            do {
                w = w2.w(Integer.valueOf(i6));
                arrayList.add(w);
                i6++;
            } while (w.r().intValue() != i5);
        }
        if (z) {
            int size = arrayList.size();
            int i7 = (6 - (size / 7)) * 7;
            a aVar2 = arrayList.get(size - 1);
            for (int i8 = 1; i8 <= i7; i8++) {
                arrayList.add(aVar2.w(Integer.valueOf(i8)));
            }
        }
        return arrayList;
    }
}

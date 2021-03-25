package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class StringUtils {
    public static <T> String arrayListToString(ArrayList<T> arrayList) {
        String str = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                StringBuilder n = a.n(str);
                n.append(next.toString());
                n.append("\n");
                str = n.toString();
            }
        }
        return str;
    }

    public static String substring(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        if (i > i2) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return str.substring(i, i2);
    }
}

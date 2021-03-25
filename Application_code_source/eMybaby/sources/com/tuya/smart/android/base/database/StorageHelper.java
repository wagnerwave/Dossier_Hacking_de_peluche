package com.tuya.smart.android.base.database;

import android.content.Context;
import android.content.SharedPreferences;
import com.tuya.smart.android.base.TuyaSmartSdk;

public class StorageHelper {
    public static Context sContext;

    public static boolean getBooleanValue(String str) {
        return getBooleanValue(str, false);
    }

    public static boolean getBooleanValue(String str, boolean z) {
        SharedPreferences commonSharedPreferences = getCommonSharedPreferences();
        return (commonSharedPreferences == null || !commonSharedPreferences.contains(str)) ? z : commonSharedPreferences.getBoolean(str, z);
    }

    public static synchronized SharedPreferences getCommonSharedPreferences() {
        SharedPreferences sharedPreferences;
        synchronized (StorageHelper.class) {
            if (sContext == null) {
                sContext = TuyaSmartSdk.getApplication();
            }
            sharedPreferences = sContext.getSharedPreferences("common_storage", 4);
        }
        return sharedPreferences;
    }

    public static int getIntValue(String str, int i) {
        SharedPreferences commonSharedPreferences = getCommonSharedPreferences();
        return (commonSharedPreferences == null || !commonSharedPreferences.contains(str)) ? i : commonSharedPreferences.getInt(str, i);
    }

    public static long getLongValue(String str, long j) {
        SharedPreferences commonSharedPreferences = getCommonSharedPreferences();
        return (commonSharedPreferences == null || !commonSharedPreferences.contains(str)) ? j : commonSharedPreferences.getLong(str, j);
    }

    public static String getStringValue(String str, String str2) {
        SharedPreferences commonSharedPreferences = getCommonSharedPreferences();
        return (commonSharedPreferences == null || !commonSharedPreferences.contains(str)) ? str2 : commonSharedPreferences.getString(str, str2);
    }

    public static void remove(String str) {
        getCommonSharedPreferences().edit().remove(str).commit();
    }

    public static void setBooleanValue(String str, boolean z) {
        SharedPreferences.Editor edit = getCommonSharedPreferences().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void setIntValue(String str, Integer num) {
        SharedPreferences.Editor edit = getCommonSharedPreferences().edit();
        edit.putInt(str, num.intValue());
        edit.apply();
    }

    public static void setLongValue(String str, Long l) {
        SharedPreferences.Editor edit = getCommonSharedPreferences().edit();
        edit.putLong(str, l.longValue());
        edit.apply();
    }

    public static void setStringValue(String str, String str2) {
        SharedPreferences.Editor edit = getCommonSharedPreferences().edit();
        edit.putString(str, str2);
        edit.apply();
    }
}

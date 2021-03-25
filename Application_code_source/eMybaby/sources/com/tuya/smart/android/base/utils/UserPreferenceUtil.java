package com.tuya.smart.android.base.utils;

import a.a.a.a.a;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.oo0o0oo0o;
import com.tuya.smart.mmkv.MMKV;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UserPreferenceUtil {
    public static final String TAG = "UserPreferenceUtil";
    public static volatile Boolean sIsMainProcess;
    public static volatile MMKV sMainProcessMMKV;
    public static volatile MMKV sOtherProcessMMKV;
    public static final ReentrantReadWriteLock sReadWriteLock = new ReentrantReadWriteLock();

    public static void clear() {
        sReadWriteLock.writeLock().lock();
        try {
            o00oo0oo00.O00000o0(TAG, "clear");
            getMMKV().clear();
        } finally {
            sReadWriteLock.writeLock().unlock();
        }
    }

    public static MMKV getMMKV() {
        Class<UserPreferenceUtil> cls = UserPreferenceUtil.class;
        if (sIsMainProcess == null) {
            sIsMainProcess = Boolean.valueOf(ProcessUtils.getProcessName(TuyaSdk.getApplication()).equals(TuyaSdk.getApplication().getPackageName()));
        }
        StringBuilder n = a.n("getMMKV sIsMainProcess: ");
        n.append(sIsMainProcess);
        o00oo0oo00.O00000o0(TAG, n.toString());
        if (sIsMainProcess.booleanValue()) {
            if (sMainProcessMMKV == null) {
                synchronized (cls) {
                    if (sMainProcessMMKV == null) {
                        MMKV.initialize((Context) TuyaSdk.getApplication());
                        sMainProcessMMKV = MMKV.mmkvWithID("Login_user_main", 2, oo0o0oo0o.O000000o("Login_user_main"));
                        sOtherProcessMMKV = MMKV.mmkvWithID("Login_user_other", 2, oo0o0oo0o.O000000o("Login_user_other"));
                    }
                }
            }
        } else if (sOtherProcessMMKV == null) {
            synchronized (cls) {
                if (sOtherProcessMMKV == null) {
                    MMKV.initialize((Context) TuyaSdk.getApplication());
                    sOtherProcessMMKV = MMKV.mmkvWithID("Login_user_other", 2, oo0o0oo0o.O000000o("Login_user_other"));
                }
            }
        }
        return sIsMainProcess.booleanValue() ? sMainProcessMMKV : sOtherProcessMMKV;
    }

    @Nullable
    public static String getString(String str, @Nullable String str2) {
        o00oo0oo00.O00000o0(TAG, "getString");
        sReadWriteLock.readLock().lock();
        String str3 = "";
        try {
            str3 = getMMKV().getString(str, str2);
            o00oo0oo00.O00000o0(TAG, "result: " + str3);
            return str3;
        } catch (Exception e2) {
            o00oo0oo00.O00000Oo(TAG, "getString exception: " + e2.getMessage());
            e2.printStackTrace();
            return str3;
        } finally {
            sReadWriteLock.readLock().unlock();
        }
    }

    public static void putString(String str, @Nullable String str2) {
        o00oo0oo00.O00000o0(TAG, "putString: " + str2);
        sReadWriteLock.writeLock().lock();
        try {
            getMMKV().putString(str, str2);
            getMMKV().sync();
            if (sIsMainProcess.booleanValue()) {
                o00oo0oo00.O00000o0(TAG, "putString sIsMainProcess :" + sIsMainProcess);
                sOtherProcessMMKV.putString(str, str2);
                sOtherProcessMMKV.sync();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            o00oo0oo00.O00000Oo(TAG, "putString: " + e2.getMessage());
        } catch (Throwable th) {
            sReadWriteLock.writeLock().unlock();
            throw th;
        }
        sReadWriteLock.writeLock().unlock();
    }

    public static void remove(String str) {
        sReadWriteLock.writeLock().lock();
        try {
            o00oo0oo00.O00000o0(TAG, "remove");
            getMMKV().remove(str);
            getMMKV().sync();
            if (sIsMainProcess.booleanValue()) {
                sOtherProcessMMKV.remove(str);
                sOtherProcessMMKV.sync();
            }
        } finally {
            sReadWriteLock.writeLock().unlock();
        }
    }
}

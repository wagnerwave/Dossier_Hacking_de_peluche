package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.nineoldandroids.util.ReflectiveProperty;
import com.tuya.sdk.security.SecuredPreferenceStore;
import com.tuya.smart.common.oOO0O0O0;
import java.util.Random;
import java.util.concurrent.Future;

public class PhoneUtil {
    public static final String DEVICEID = "deviceId";
    public static final String DEVICEID_STORE = "deviceId_store";
    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    public static final String MACADDRESS = "mac_address";
    public static final String TAG = "PhoneUtil";
    public static String mDeviceId = null;
    public static Future<String> mLastFuture = null;
    public static String phone_imei = "";
    public static String phone_imsi = "";
    public static String phone_wifiaddr = "";

    public static void clear(Context context) {
        mDeviceId = null;
        deleteDeviceID(context);
    }

    public static void deleteDeviceID(Context context) {
        SecuredPreferenceStore.O000000o().edit().putString("deviceId", "").apply();
    }

    public static String generateImei() {
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        String l = Long.toString(currentTimeMillis);
        sb.append(l.substring(l.length() - 5));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.MODEL.replaceAll(" ", ""));
        while (sb2.length() < 6) {
            sb2.append('0');
        }
        sb.append(sb2.substring(0, 6));
        Random random = new Random(currentTimeMillis);
        long j = 0;
        while (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = random.nextLong();
        }
        sb.append(Long.toHexString(j).substring(0, 4));
        return sb.toString();
    }

    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getDeviceID(Context context) {
        if (TextUtils.isEmpty(mDeviceId)) {
            if (TextUtils.isEmpty(mDeviceId)) {
                mDeviceId = getSharePreferenceDeviceID(context);
            }
            if (TextUtils.isEmpty(mDeviceId)) {
                mDeviceId = getRemoteDeviceID(context);
            }
        }
        return mDeviceId;
    }

    public static String getImei(Context context) {
        if (!TextUtils.isEmpty(phone_imei)) {
            return phone_imei;
        }
        SecuredPreferenceStore O000000o = SecuredPreferenceStore.O000000o();
        String string = O000000o.getString("imei", (String) null);
        if (string == null || string.length() == 0) {
            string = generateImei().replaceAll(" ", "").trim();
            while (string.length() < 15) {
                string = a.k(oOO0O0O0.O0000oO0, string);
            }
            SharedPreferences.Editor edit = O000000o.edit();
            edit.putString("imei", string);
            edit.apply();
        }
        String trim = string.trim();
        phone_imei = trim;
        return trim;
    }

    public static String getImsi(Context context) {
        if (!TextUtils.isEmpty(phone_imsi)) {
            return phone_imsi;
        }
        SecuredPreferenceStore O000000o = SecuredPreferenceStore.O000000o();
        String string = O000000o.getString("imsi", (String) null);
        if (string == null || string.length() == 0) {
            string = generateImei().replaceAll(" ", "").trim();
            while (string.length() < 15) {
                string = a.k(oOO0O0O0.O0000oO0, string);
            }
            SharedPreferences.Editor edit = O000000o.edit();
            edit.putString("imsi", string);
            edit.apply();
        }
        phone_imsi = string;
        return string;
    }

    public static String getLocalDeviceID(Context context) {
        if (TextUtils.isEmpty(mDeviceId)) {
            mDeviceId = getSharePreferenceDeviceID(context);
        }
        return mDeviceId;
    }

    public static String getRemoteDeviceID(Context context) {
        String md5AsBase64 = MD5Util.md5AsBase64(Build.BRAND + Build.MODEL);
        String md5AsBase642 = MD5Util.md5AsBase64(getAndroidId(context) + getSerialNum());
        String md5AsBase643 = MD5Util.md5AsBase64(getImei(context) + getImsi(context));
        return md5AsBase64.substring(4, 16) + md5AsBase642.substring(8, 24) + md5AsBase643.substring(16);
    }

    public static String getSerialNum() {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod(ReflectiveProperty.PREFIX_GET, new Class[]{cls, cls}).invoke(cls2, new Object[]{"ro.serialno", EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSharePreferenceDeviceID(Context context) {
        if (context == null) {
            return null;
        }
        String string = SecuredPreferenceStore.O000000o().getString("deviceId", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return null;
    }
}

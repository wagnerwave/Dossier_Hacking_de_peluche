package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.util.TimeUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.tuya.smart.common.oOO0O0O0;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TyCommonUtil {
    public static String defaultZone() {
        TimeZone timeZone = DateFormat.getInstance().getTimeZone();
        return getTimeZoneByRawOffset(timeZone.getDSTSavings() + timeZone.getRawOffset());
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static byte[] drawable2bytes(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getCountryCode(Context context, String str) {
        return TuyaUtil.getCountryCode(context, str);
    }

    public static String getCountryNumberCodeByTimeZone() {
        return TextUtils.equals(TimeZone.getDefault().getID(), "Asia/Shanghai") ? "86" : "1";
    }

    public static final DisplayMetrics getDisplayMetrics(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static String getLang(Context context) {
        if (context == null) {
            return "";
        }
        String language = (Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale).getLanguage();
        if (TextUtils.equals(language, "zh")) {
            int i = Build.VERSION.SDK_INT;
            Configuration configuration = context.getResources().getConfiguration();
            String country = (i >= 24 ? configuration.getLocales().get(0) : configuration.locale).getCountry();
            return (!TextUtils.equals(country, "TW") && !TextUtils.equals(country, "HK") && !TextUtils.equals(country, "MO")) ? language : "tw";
        }
    }

    public static String getSpaceString(long j) {
        String[] spaceFormat = spaceFormat(j);
        String[] split = TextUtils.split(spaceFormat[0], "\\.");
        return split[0] + spaceFormat[1];
    }

    public static String getTimeZone() {
        try {
            String format = new SimpleDateFormat("Z", Locale.US).format(new Date());
            if (TextUtils.isEmpty(format)) {
                return defaultZone();
            }
            return format.substring(0, 3) + ":" + format.substring(3);
        } catch (Exception unused) {
            return defaultZone();
        }
    }

    public static String getTimeZoneByRawOffset(int i) {
        String str = i >= 0 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "";
        int i2 = (i / 1000) / TimeUtils.SECONDS_PER_HOUR;
        StringBuilder n = a.n(str);
        n.append(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(((i - ((i2 * 1000) * TimeUtils.SECONDS_PER_HOUR)) / 1000) / 60)}));
        return n.toString();
    }

    public static String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    public static String getTimezoneGCMById(String str) {
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 24) {
            android.icu.util.TimeZone timeZone = android.icu.util.TimeZone.getTimeZone(str);
            i2 = timeZone.getRawOffset();
            i = timeZone.getDSTSavings();
        } else {
            TimeZone timeZone2 = SimpleTimeZone.getTimeZone(str);
            i2 = timeZone2.getRawOffset();
            i = timeZone2.getDSTSavings();
        }
        return getTimeZoneByRawOffset(i + i2);
    }

    public static boolean goToMarket(Context context) {
        StringBuilder n = a.n("market://details?id=");
        n.append(context.getPackageName());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(n.toString()));
        intent.addFlags(268435456);
        if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isApplicationBroughtToBackground(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (activityManager == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.processName.startsWith(packageName)) {
                int i = next.importance;
                return (i != 100 && i != 200) || keyguardManager.inKeyguardRestrictedInputMode();
            }
        }
        return false;
    }

    public static boolean isChina(Context context) {
        try {
            String countryCode = getCountryCode(context, (String) null);
            return TextUtils.isEmpty(countryCode) ? TextUtils.equals(TimeZone.getDefault().getID(), "Asia/Shanghai") : "CN".equals(countryCode);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isZh(Context context) {
        return getLang(context).endsWith("zh");
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String[] spaceFormat(long j) {
        String[] strArr = {oOO0O0O0.O0000oO0, "MB"};
        if (j <= 0) {
            strArr[0] = oOO0O0O0.O0000oO0;
            strArr[1] = "MB";
        } else {
            float f = ((float) j) / 1024.0f;
            if (f < 1.0f) {
                strArr[0] = "1";
                strArr[1] = "MB";
            } else if (f < 100.0f) {
                strArr[0] = String.format("%d", new Object[]{Long.valueOf((long) f)});
                strArr[1] = "MB";
            } else {
                float f2 = f / 1024.0f;
                if (f2 < 100.0f) {
                    strArr[0] = String.format("%.2f", new Object[]{Float.valueOf(f2)});
                    strArr[1] = "GB";
                } else {
                    strArr[0] = String.format("%d", new Object[]{Long.valueOf((long) f2)});
                    strArr[1] = "GB";
                }
            }
        }
        return strArr;
    }

    public static String spacePercent(long j, long j2) {
        float f = (((float) j) / ((float) j2)) * 100.0f;
        if (f == 0.0f) {
            return "0%";
        }
        if (((double) f) <= 0.01d) {
            return "0.01%";
        }
        if (f < 10.0f) {
            return String.format("%.2f%%", new Object[]{Float.valueOf(f)});
        }
        return String.format("%d%%", new Object[]{Long.valueOf((long) f)});
    }
}

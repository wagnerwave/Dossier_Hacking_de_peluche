package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import com.tuya.smart.common.oOO0O0O0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TuyaUtil {
    public static final String TAG = "TuyaUtil";

    public static long absoluteValue(long j) {
        return j > 0 ? j : -j;
    }

    public static boolean checkBvVersion(String str, float f) {
        return !TextUtils.isEmpty(str) && Float.valueOf(str).floatValue() >= f;
    }

    public static boolean checkHgwLastVersion(String str, float f) {
        return !TextUtils.isEmpty(str) && Float.valueOf(str.replace("v", "")).floatValue() > f;
    }

    public static boolean checkHgwVersion(String str, float f) {
        return !TextUtils.isEmpty(str) && Float.valueOf(str.replace("v", "")).floatValue() >= f;
    }

    public static boolean checkPvLastVersion(String str, float f) {
        return !TextUtils.isEmpty(str) && Float.valueOf(str).floatValue() > f;
    }

    public static boolean checkPvVersion(String str, float f) {
        return !TextUtils.isEmpty(str) && Float.valueOf(str).floatValue() >= f;
    }

    public static boolean checkServiceProcess(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE)) {
            if (TextUtils.equals(str, runningServiceInfo.service.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkServiceVersion(String str, String str2) {
        return TextUtils.isEmpty(str) || Float.valueOf(str).floatValue() < Float.valueOf(str2).floatValue();
    }

    public static int compare(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Invalid parameter!");
        }
        int[] value = getValue(str);
        int[] value2 = getValue(str2);
        int i = 0;
        while (i < value.length && i < value2.length) {
            if (value[i] < value2[i]) {
                return -1;
            }
            if (value[i] > value2[i]) {
                return 1;
            }
            i++;
        }
        if (value.length == value2.length) {
            return 0;
        }
        return value.length > value2.length ? 1 : -1;
    }

    public static int compareVersion(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        return compare(str, str2);
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

    public static String formatDate(int i, String str) {
        return formatDate(((long) i) * 1000, str);
    }

    public static String formatDate(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.US).format(new Date(j));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Date formatDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.US).parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001d */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014 A[ExcHandler: Exception (r4v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:3:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getApplicationName(android.content.Context r4) {
        /*
            java.lang.Class<com.tuya.smart.android.common.utils.TuyaUtil> r0 = com.tuya.smart.android.common.utils.TuyaUtil.class
            monitor-enter(r0)
            r1 = 0
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001c, Exception -> 0x0014 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x001d, Exception -> 0x0014 }
            r3 = 0
            android.content.pm.ApplicationInfo r1 = r2.getApplicationInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x001d, Exception -> 0x0014 }
            goto L_0x001d
        L_0x0012:
            r4 = move-exception
            goto L_0x0025
        L_0x0014:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0012 }
            java.lang.String r4 = ""
            monitor-exit(r0)
            return r4
        L_0x001c:
            r2 = r1
        L_0x001d:
            java.lang.CharSequence r4 = r2.getApplicationLabel(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0012 }
            monitor-exit(r0)
            return r4
        L_0x0025:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.common.utils.TuyaUtil.getApplicationName(android.content.Context):java.lang.String");
    }

    public static byte[] getAssetsData(Context context, String str, byte[] bArr) {
        try {
            InputStream open = context.getApplicationContext().getAssets().open(str);
            byte[] bArr2 = new byte[open.available()];
            open.read(bArr2);
            open.close();
            return bArr2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public static String getCountryCode(Context context, String str) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!(telephonyManager == null || telephonyManager.getPhoneType() == 2)) {
                return telephonyManager.getSimCountryIso().toUpperCase();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static final DisplayMetrics getDisplayMetrics(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static int getDrawableResId(Context context, String str, int i) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception unused) {
            return i;
        }
    }

    public static Intent getExplicitIntent(Context context, Intent intent) {
        for (ResolveInfo next : context.getPackageManager().queryIntentServices(intent, 0)) {
            if (checkServiceProcess(context, next.serviceInfo.packageName)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(next.serviceInfo.packageName);
                return intent2;
            }
        }
        return null;
    }

    public static Intent getExplicitIntent(Context context, Intent intent, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningServiceInfo> runningServices;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)) == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null) {
            return null;
        }
        for (ActivityManager.RunningServiceInfo next : runningServices) {
            if (TextUtils.equals(str, next.service.getClassName())) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(next.service.getPackageName());
                return intent2;
            }
        }
        return null;
    }

    public static String getLang(Context context) {
        return TyCommonUtil.getLang(context);
    }

    public static String getSpaceString(long j) {
        String[] spaceFormat = spaceFormat(j);
        String[] split = TextUtils.split(spaceFormat[0], "\\.");
        return split[0] + spaceFormat[1];
    }

    public static String getString(Context context, String str, String str2) {
        try {
            return context.getString(context.getResources().getIdentifier(str, StringSchemaBean.type, context.getPackageName()));
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String getUidBySessionId(String str) {
        int i = 0;
        String substring = str.substring(0, str.length() - 32);
        String substring2 = substring.substring(0, substring.length() - 1);
        Integer valueOf = Integer.valueOf(substring2.length() - Integer.valueOf(substring.substring(substring.length() - 1, substring.length())).intValue());
        int ceil = (int) Math.ceil((double) (((float) valueOf.intValue()) / 8.0f));
        Integer num = 0;
        String str2 = "";
        while (i < ceil) {
            int i2 = i + 1;
            Integer valueOf2 = Integer.valueOf(i2 * 8);
            if (valueOf2.intValue() > valueOf.intValue()) {
                valueOf2 = valueOf;
            }
            StringBuilder n = a.n(str2);
            n.append(substring2.substring(num.intValue(), valueOf2.intValue() + i));
            str2 = n.toString();
            num = Integer.valueOf(valueOf2.intValue() + i + 1);
            i = i2;
        }
        return str2;
    }

    public static int[] getValue(String str) {
        String[] split = str.split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.valueOf(split[i]).intValue();
            } catch (Exception unused) {
                iArr[i] = 0;
            }
        }
        return iArr;
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
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static boolean hasLatOrLon(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return Double.valueOf(str).doubleValue() > 1.0E-5d || Double.valueOf(str2).doubleValue() > 1.0E-5d;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean isAppForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty())) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.equals(context.getPackageName()) && next.importance == 100) {
                    return true;
                }
            }
        }
        return false;
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

    public static boolean isHgwVersionEquals(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(str.replace("v", ""), str2);
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

    public static void startForegroundService(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static int stringToInt(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}

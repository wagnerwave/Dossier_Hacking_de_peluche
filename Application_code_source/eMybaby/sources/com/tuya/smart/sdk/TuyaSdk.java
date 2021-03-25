package com.tuya.smart.sdk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.base.broadcast.NetworkBroadcastReceiver;
import com.tuya.smart.android.base.event.TuyaEventBus;
import com.tuya.smart.android.base.provider.ApiUrlProvider;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.device.utils.TuyaActivityLifecycleCallback;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.IApiUrlProvider;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00oo0oo;
import com.tuya.smart.sdk.api.INeedLoginListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class TuyaSdk {
    public static final String TAG = "TuyaSdk";
    public static String latitude;
    public static String longitude;
    public static Application mApplication;

    public static synchronized Application getApplication() {
        Application application;
        synchronized (TuyaSdk.class) {
            if (mApplication == null) {
                mApplication = getSystemApp();
            }
            application = mApplication;
        }
        return application;
    }

    public static TuyaEventBus getEventBus() {
        return TuyaSmartSdk.getEventBus();
    }

    public static String getLatitude() {
        return latitude;
    }

    public static String getLongitude() {
        return longitude;
    }

    public static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public static Application getSystemApp() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke((Object) null, new Object[0]));
        } catch (Exception unused) {
            return TuyaSmartSdk.getApplication();
        }
    }

    public static void init(Application application) {
        TuyaSmartSdk.init(application);
        init(application, TuyaSmartSdk.getAppkey(), TuyaSmartSdk.getAppSecret());
    }

    public static void init(Application application, String str, String str2) {
        TuyaSmartSdk.init(application);
        init(application, str, str2, "android", TuyaSmartNetWork.CHANNEL_SDK, (String) null, (IApiUrlProvider) null);
    }

    public static void init(Application application, String str, String str2, String str3, String str4, IApiUrlProvider iApiUrlProvider) {
        TuyaSmartSdk.init(application);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new RuntimeException("appkey and appSecret cannot be null ");
        }
        mApplication = application;
        initTuyaData(application, str, str2, str3, TuyaSmartNetWork.CHANNEL_OEM, str4, iApiUrlProvider);
        TuyaSmartNetWork.mSdkVersion = "3.11.0";
    }

    public static void init(Application application, String str, String str2, String str3, String str4, String str5, IApiUrlProvider iApiUrlProvider) {
        TuyaSmartSdk.init(application);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new RuntimeException("appkey and appSecret cannot be null ");
        }
        mApplication = application;
        initTuyaData(application, str, str2, str3, str5, str4, iApiUrlProvider);
        TuyaSmartNetWork.mSdkVersion = "3.11.0";
    }

    public static void initTuyaData(Application application, String str, String str2, String str3, String str4, String str5, IApiUrlProvider iApiUrlProvider) {
        ApiUrlProvider apiUrlProvider;
        o0o00o00o0 o0o00o00o0;
        String processName = getProcessName(getApplication());
        String packageName = getApplication().getPackageName();
        if (iApiUrlProvider == null) {
            Application application2 = application;
            apiUrlProvider = new ApiUrlProvider(application);
        } else {
            Application application3 = application;
            apiUrlProvider = iApiUrlProvider;
        }
        TuyaSmartNetWork.initialize(application, str, str2, str3, str4, (String) null, str5, apiUrlProvider);
        L.d(TAG, "processName: " + processName);
        if ((TextUtils.isEmpty(processName) || TextUtils.equals(processName, packageName)) && (o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)) != null) {
            o0o00o00o0.O0000o00();
        }
        TuyaActivityLifecycleCallback.getInstance(application);
        L.init();
        NetworkBroadcastReceiver.registerReceiver(application);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isForeginAccount() {
        /*
            java.lang.String r0 = com.tuya.smart.android.network.TuyaSmartNetWork.getRegion()
            int r1 = r0.hashCode()
            r2 = 2104(0x838, float:2.948E-42)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001d
            r2 = 2645(0xa55, float:3.706E-42)
            if (r1 == r2) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            java.lang.String r1 = "SH"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x001d:
            java.lang.String r1 = "AY"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = -1
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            if (r0 == r4) goto L_0x002d
            return r4
        L_0x002d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.sdk.TuyaSdk.isForeginAccount():boolean");
    }

    public static void logout() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().onDestroy();
        }
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo != null) {
            o0o00oo0oo.O000000o().removeUser();
        }
    }

    public static void setDebugMode(boolean z) {
        TuyaSmartSdk.setDebugMode(z);
    }

    public static void setLatAndLong(String str, String str2) {
        latitude = str;
        longitude = str2;
    }

    public static void setOnNeedLoginListener(final INeedLoginListener iNeedLoginListener) {
        TuyaSmartNetWork.setOnNeedLoginListener(new Business.OnNeedLoginListener() {
            public void onNeedLogin(final Context context) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        TuyaSdk.logout();
                        iNeedLoginListener.onNeedLogin(context);
                    }
                });
            }
        });
    }
}

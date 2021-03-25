package com.tuya.smart.android.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tuya.smart.android.base.event.TuyaEventBus;
import com.tuya.smart.android.common.task.TuyaExecutor;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.oOOO00o0;
import com.tuya.smart.common.oo0o0oo0o;

public class TuyaSmartSdk {
    public static boolean DEBUG = true;
    public static String appSecret = null;
    public static String appkey = null;
    public static volatile TuyaEventBus eventBus = null;
    public static Application mContext = null;
    public static boolean mInit = false;
    public static String ttid = "Android";

    public static void destroy() {
    }

    public static synchronized String getAppSecret() {
        String str;
        synchronized (TuyaSmartSdk.class) {
            try {
                if (TextUtils.isEmpty(appSecret)) {
                    appSecret = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), 128).metaData.getString(BaseConfig.TUYA_SMART_SECRET);
                }
                str = appSecret;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return str;
    }

    public static synchronized String getAppkey() {
        String str;
        synchronized (TuyaSmartSdk.class) {
            try {
                if (TextUtils.isEmpty(appkey)) {
                    appkey = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), 128).metaData.getString(BaseConfig.TUYA_SMART_APPKEY);
                }
                str = appkey;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return str;
    }

    public static Application getApplication() {
        return mContext;
    }

    public static TuyaEventBus getEventBus() {
        return eventBus;
    }

    public static String getLatitude() {
        return null;
    }

    public static String getLongitude() {
        return null;
    }

    public static String getTtid() {
        return ttid;
    }

    public static void init(Application application) {
        if (!mInit) {
            mInit = true;
            mContext = application;
            initEventbus();
            L.setSendLogOn(false);
            oo0o0oo0o.O000000o((Context) application);
            Oo0.O000000o(application);
        }
    }

    public static void initEventbus() {
        if (eventBus == null) {
            oOOO00o0.O00000o0();
            eventBus = new TuyaEventBus(DEBUG, TuyaExecutor.getInstance().getTuyaExecutorService());
        }
    }

    public static void setAppSecret(String str) {
        appSecret = str;
    }

    public static void setAppkey(String str) {
        appkey = str;
    }

    public static void setDebugMode(boolean z) {
        DEBUG = z;
        L.setLogSwitcher(z);
    }

    public static void setTtid(String str) {
        ttid = str;
    }
}

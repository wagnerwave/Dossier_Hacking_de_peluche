package com.tuya.smart.android.device.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tuya.smart.android.base.event.BaseEventSender;
import com.tuya.smart.android.common.utils.L;

public class TuyaActivityLifecycleCallback {
    public static final String TAG = "TuyaSdkInitManager";
    public static TuyaActivityLifecycleCallback ourInstance;
    public int activityCount;
    public long backgroundStamp;
    public boolean isForeground = false;
    public boolean isScreenOff;

    public TuyaActivityLifecycleCallback(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                L.v(TuyaActivityLifecycleCallback.TAG, "onActivityCreated");
            }

            public void onActivityDestroyed(Activity activity) {
                L.v(TuyaActivityLifecycleCallback.TAG, "onActivityDestroyed");
            }

            public void onActivityPaused(Activity activity) {
                L.v(TuyaActivityLifecycleCallback.TAG, "onActivityPaused");
            }

            public void onActivityResumed(Activity activity) {
                L.v(TuyaActivityLifecycleCallback.TAG, "onActivityResumed");
                if (!TuyaActivityLifecycleCallback.this.isForeground) {
                    boolean unused = TuyaActivityLifecycleCallback.this.isForeground = true;
                    L.mqtt(TuyaActivityLifecycleCallback.TAG, "app goto foreground");
                    BaseEventSender.sendForeGroundStatus(true);
                }
                boolean unused2 = TuyaActivityLifecycleCallback.this.isScreenOff = false;
                long unused3 = TuyaActivityLifecycleCallback.this.backgroundStamp = 0;
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                L.d(TuyaActivityLifecycleCallback.TAG, "onActivitySaveInstanceState");
            }

            public void onActivityStarted(Activity activity) {
                L.d(TuyaActivityLifecycleCallback.TAG, "onActivityStarted");
                TuyaActivityLifecycleCallback.access$008(TuyaActivityLifecycleCallback.this);
            }

            public void onActivityStopped(Activity activity) {
                L.d(TuyaActivityLifecycleCallback.TAG, "onActivityStopped");
                TuyaActivityLifecycleCallback.access$010(TuyaActivityLifecycleCallback.this);
                if (TuyaActivityLifecycleCallback.this.activityCount == 0) {
                    L.mqtt(TuyaActivityLifecycleCallback.TAG, "app goto background");
                    long unused = TuyaActivityLifecycleCallback.this.backgroundStamp = System.currentTimeMillis();
                    boolean unused2 = TuyaActivityLifecycleCallback.this.isForeground = false;
                    BaseEventSender.sendForeGroundStatus(false);
                }
            }
        });
    }

    public static /* synthetic */ int access$008(TuyaActivityLifecycleCallback tuyaActivityLifecycleCallback) {
        int i = tuyaActivityLifecycleCallback.activityCount;
        tuyaActivityLifecycleCallback.activityCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$010(TuyaActivityLifecycleCallback tuyaActivityLifecycleCallback) {
        int i = tuyaActivityLifecycleCallback.activityCount;
        tuyaActivityLifecycleCallback.activityCount = i - 1;
        return i;
    }

    public static synchronized TuyaActivityLifecycleCallback getInstance(Application application) {
        TuyaActivityLifecycleCallback tuyaActivityLifecycleCallback;
        synchronized (TuyaActivityLifecycleCallback.class) {
            if (ourInstance == null) {
                L.d(TAG, "outInstance==null");
                ourInstance = new TuyaActivityLifecycleCallback(application);
            }
            tuyaActivityLifecycleCallback = ourInstance;
        }
        return tuyaActivityLifecycleCallback;
    }

    public boolean isForeground() {
        return this.isForeground;
    }
}

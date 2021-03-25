package com.tuya.smart.android.network.util;

import a.a.a.a.a;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.oo000oo00;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeStampManager implements Business.ResultListener<Long> {
    public static final String BASE_SERVER_TIMESTAMP_KEY = "base_server_timestamp";
    public static final String BASE_TIME_ELAPSE_KEY = "base_time_elapsed";
    public static final String TIMESTAMP_SP_NAME = "timestamp_difference";
    public static final int TIME_FLAG_ERROR = -1;
    public static final int TIME_FLAG_LOADED = 1;
    public static final int TIME_FLAG_LOADING = 0;
    public String TAG = "TimeStampManager";
    public long baseServerTimeStamp = (new Date().getTime() / 1000);
    public long baseTimeElapsed = SystemClock.elapsedRealtime();
    public oo000oo00 mBusiness = new oo000oo00();
    public final boolean mIsMainProcess = TextUtils.equals(TuyaSmartNetWork.getAppContext().getPackageName(), getCurrentProcessName());
    public int timeFlag = -1;

    public static class SingletonHolder {
        public static TimeStampManager instance = new TimeStampManager();
    }

    public TimeStampManager() {
        if (TuyaSmartNetWork.getAppContext() != null && this.mIsMainProcess) {
            L.d(this.TAG, "pull in main process");
            pullTimeUtilGetSuccess();
        }
    }

    private String getCurrentProcessName() {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) TuyaSmartNetWork.getAppContext().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.pid == myPid) {
                str = next.processName;
            }
        }
        return str;
    }

    public static TimeStampManager instance() {
        return SingletonHolder.instance;
    }

    private void pullTimeUtilGetSuccess() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                L.d(TimeStampManager.this.TAG, "pullTimeUtilGetSuccess");
                if (TimeStampManager.this.timeFlag == -1) {
                    TimeStampManager.this.pullTimeStampIfNeeded();
                } else {
                    timer.cancel();
                }
            }
        }, 5000, 10000);
    }

    public long getCurrentTimeStamp() {
        long elapsedRealtime = ((SystemClock.elapsedRealtime() - this.baseTimeElapsed) / 1000) + this.baseServerTimeStamp;
        if (this.mIsMainProcess) {
            pullTimeStampIfNeeded();
        } else {
            L.d(this.TAG, "restore timestamp from local");
            restore(TuyaSmartNetWork.getAppContext());
        }
        return elapsedRealtime;
    }

    public int getTimeStampState() {
        return this.timeFlag;
    }

    public void onCreated() {
        pullTimeStampIfNeeded();
    }

    public void onFailure(BusinessResponse businessResponse, Long l, String str) {
        this.timeFlag = -1;
        restore(TuyaSmartNetWork.getAppContext());
    }

    public void onStop() {
        oo000oo00 oo000oo00;
        if (this.timeFlag == 0 && (oo000oo00 = this.mBusiness) != null) {
            oo000oo00.cancelAll();
        }
    }

    public void onSuccess(BusinessResponse businessResponse, Long l, String str) {
        String str2 = this.TAG;
        L.d(str2, "get service time stamp success ,t:" + l);
        updateTimeStamp(l.longValue());
        save(TuyaSmartNetWork.getAppContext());
    }

    public boolean pullTimeStamp(boolean z) {
        if (this.timeFlag == 0) {
            if (!z) {
                return false;
            }
            oo000oo00 oo000oo00 = this.mBusiness;
            if (oo000oo00 != null) {
                oo000oo00.cancelAll();
                L.d(this.TAG, "get time stamp has been canceled");
            }
        }
        this.timeFlag = 0;
        this.mBusiness.O000000o(this);
        L.d(this.TAG, "start pull time stamp from server");
        return true;
    }

    public boolean pullTimeStampIfNeeded() {
        if (this.timeFlag == -1) {
            return pullTimeStamp(false);
        }
        return false;
    }

    public void restore(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TIMESTAMP_SP_NAME, 0);
        long j = sharedPreferences.getLong(BASE_TIME_ELAPSE_KEY, -1);
        long j2 = sharedPreferences.getLong(BASE_SERVER_TIMESTAMP_KEY, -1);
        if (j > 0 && j2 > 0) {
            this.baseTimeElapsed = j;
            this.baseServerTimeStamp = j2;
            this.timeFlag = 1;
        }
    }

    public void save(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(TIMESTAMP_SP_NAME, 0).edit();
        edit.putLong(BASE_TIME_ELAPSE_KEY, this.baseTimeElapsed);
        edit.putLong(BASE_SERVER_TIMESTAMP_KEY, this.baseServerTimeStamp);
        edit.commit();
    }

    public void updateTimeStamp(long j) {
        this.baseTimeElapsed = SystemClock.elapsedRealtime();
        this.baseServerTimeStamp = j;
        String str = this.TAG;
        StringBuilder n = a.n("update baseServerTimeStamp: ");
        n.append(this.baseServerTimeStamp);
        n.append(" | update baseTimeElapsed: ");
        n.append(this.baseTimeElapsed);
        L.d(str, n.toString());
        this.timeFlag = 1;
    }
}

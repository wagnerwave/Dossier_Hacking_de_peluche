package com.tuya.smart.android.common.task;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;

public abstract class SafeAsyncTask<Params, Result> extends AsyncTask<Params, Void, Result> {
    public final Activity mActivity;

    public SafeAsyncTask(Activity activity) {
        this.mActivity = activity;
    }

    public static void execute(Runnable runnable) {
        Coordinator.getCurrentExecutor().execute(runnable);
    }

    public static final void init() {
    }

    public final void onPostExecute(Result result) {
        if (!this.mActivity.isFinishing()) {
            if (Build.VERSION.SDK_INT < 17 || !this.mActivity.isDestroyed()) {
                onResult(result);
            }
        }
    }

    public abstract void onResult(Result result);
}

package com.tuya.smart.blescan.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Random;

public class SafeHandler extends Handler {
    public static boolean isDebugMode = false;
    public static Random random = new Random(System.currentTimeMillis());
    public boolean isAlive;
    public WeakReference<Context> mActivity;

    public SafeHandler() {
        this.isAlive = true;
    }

    public SafeHandler(Activity activity, Looper looper) {
        this(looper);
        this.mActivity = new WeakReference<>(activity);
    }

    public SafeHandler(Activity activity, Looper looper, Handler.Callback callback) {
        this(looper, callback);
        this.mActivity = new WeakReference<>(activity);
    }

    public SafeHandler(Context context, Handler.Callback callback) {
        this(callback);
        this.mActivity = new WeakReference<>(context);
    }

    public SafeHandler(Handler.Callback callback) {
        super(callback);
        this.isAlive = true;
    }

    public SafeHandler(Looper looper) {
        super(looper);
        this.isAlive = true;
    }

    public SafeHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.isAlive = true;
    }

    public static void setDebugMode(boolean z) {
        isDebugMode = z;
    }

    public void clearMsg(Message message) {
        message.what = 0;
        message.arg1 = 0;
        message.arg2 = 0;
        message.obj = null;
        message.replyTo = null;
        message.setTarget((Handler) null);
    }

    public void destroy() {
        this.isAlive = false;
    }

    public void dispatchMessage(Message message) {
        if (this.isAlive) {
            if (isDebugMode) {
                WeakReference<Context> weakReference = this.mActivity;
                if (weakReference == null || weakReference.get() != null) {
                    super.dispatchMessage(message);
                }
            } else {
                try {
                    if (this.mActivity == null || this.mActivity.get() != null) {
                        super.dispatchMessage(message);
                    }
                } catch (Exception unused) {
                }
            }
            clearMsg(message);
        }
    }

    public boolean sendMessageAtTime(Message message, long j) {
        if (!this.isAlive) {
            return false;
        }
        return super.sendMessageAtTime(message, j);
    }
}

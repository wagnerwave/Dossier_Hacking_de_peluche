package com.tuya.smart.android.mvp.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tuya.smart.android.common.utils.SafeHandler;

public abstract class BasePresenter implements Handler.Callback, IPresenter {
    public SafeHandler mHandler;

    public BasePresenter() {
        this.mHandler = new SafeHandler(Looper.getMainLooper(), (Handler.Callback) this);
    }

    public BasePresenter(Context context) {
        this.mHandler = new SafeHandler(context, (Handler.Callback) this);
    }

    public boolean handleMessage(Message message) {
        return false;
    }

    public void onDestroy() {
        this.mHandler.destroy();
    }
}

package com.tuya.smart.android.mvp.model;

import android.content.Context;
import android.os.Message;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.bean.Result;

public abstract class BaseModel implements IModel {
    public static final int WHAT_COMMON_BASE_ERROR = 10000;
    public static final int WHAT_COMMON_BASE_SUCCESS = 10001;
    public Context mContext;
    public SafeHandler mHandler;

    public BaseModel(Context context) {
        this(context, (SafeHandler) null);
    }

    public BaseModel(Context context, SafeHandler safeHandler) {
        this.mHandler = safeHandler;
        this.mContext = context;
    }

    public void resultError(int i, String str, String str2) {
        SafeHandler safeHandler = this.mHandler;
        if (safeHandler != null) {
            Message obtainMessage = safeHandler.obtainMessage(i);
            obtainMessage.obj = new Result(str, str2);
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void resultSuccess(int i, Object obj) {
        SafeHandler safeHandler = this.mHandler;
        if (safeHandler != null) {
            Message obtainMessage = safeHandler.obtainMessage(i);
            obtainMessage.obj = new Result(obj);
            this.mHandler.sendMessage(obtainMessage);
        }
    }
}

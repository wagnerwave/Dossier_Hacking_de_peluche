package com.tuya.smart.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tuya.smart.home.sdk.api.config.IBaseConnectListener;

public abstract class OOO000o implements IBaseConnectListener {
    public static final String O000000o = "BaseConnect";
    public static final int O00000Oo = 1001;
    public Handler O00000o = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1001) {
                return false;
            }
            OOO000o.this.onActiveError("1006", "out of time");
            return false;
        }
    });
    public long O00000o0;

    public OOO000o() {
        OOOo00.O000000o();
    }

    public void O000000o() {
        this.O00000o.removeMessages(1001);
    }

    public void O000000o(long j) {
        this.O00000o0 = j;
    }

    public void O00000Oo() {
        O000000o();
    }

    public void cancel() {
        O000000o();
    }

    public void onActiveError(String str, String str2) {
        cancel();
    }

    public void onDestroy() {
        O000000o();
    }

    public void start() {
        long j = this.O00000o0;
        if (j >= 0) {
            this.O00000o.sendEmptyMessageDelayed(1001, j);
        }
    }
}

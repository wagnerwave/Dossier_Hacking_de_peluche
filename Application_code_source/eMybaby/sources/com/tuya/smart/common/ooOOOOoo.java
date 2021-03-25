package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.common.task.TuyaExecutor;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.device.event.ForeGroundStatusEvent;
import com.tuya.smart.android.device.event.ForeGroundStatusModel;
import com.tuya.smart.android.device.utils.TuyaActivityLifecycleCallback;
import com.tuya.smart.sdk.TuyaSdk;

public class ooOOOOoo implements NetWorkStatusEvent, ForeGroundStatusEvent {
    public static final String O000000o = "HardwareMobileStatusCheck";
    public final Context O00000Oo;
    public volatile boolean O00000o = true;
    public final O000000o O00000o0;
    public volatile boolean O00000oO;
    public BroadcastReceiver O00000oo = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                L.d(ooOOOOoo.O000000o, "screen on");
                boolean unused = ooOOOOoo.this.O00000o = true;
                if (ooOOOOoo.this.O00000o0 != null) {
                    ooOOOOoo.this.O00000o0.O000000o();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                L.d(ooOOOOoo.O000000o, "screen off");
                boolean unused2 = ooOOOOoo.this.O00000o = false;
            }
        }
    };

    public interface O000000o {
        void O000000o();
    }

    public ooOOOOoo(Context context, O000000o o000000o) {
        this.O00000Oo = context;
        this.O00000o0 = o000000o;
        O00000o0();
        TuyaSmartSdk.getEventBus().register(this);
    }

    private void O00000o() {
        if (!this.O00000oO) {
            this.O00000oO = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.O00000Oo.registerReceiver(this.O00000oo, intentFilter);
        }
    }

    private void O00000o0() {
        TuyaExecutor.getInstance().excutorDiscardOldestPolicy(new Runnable() {
            public void run() {
                ooOOOOoo oooooooo;
                boolean z;
                PowerManager powerManager = (PowerManager) ooOOOOoo.this.O00000Oo.getSystemService("power");
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        oooooooo = ooOOOOoo.this;
                        z = powerManager.isInteractive();
                    } else {
                        oooooooo = ooOOOOoo.this;
                        z = powerManager.isScreenOn();
                    }
                    boolean unused = oooooooo.O00000o = z;
                    L.d(ooOOOOoo.O000000o, "ScreenOn: " + ooOOOOoo.this.O00000o);
                }
            }
        });
        O00000o();
    }

    public boolean O000000o() {
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(this.O00000Oo);
        boolean isForeground = TuyaActivityLifecycleCallback.getInstance(TuyaSdk.getApplication()).isForeground();
        if (!this.O00000o) {
            StringBuilder n = a.n("screenOn: ");
            n.append(this.O00000o);
            L.e(O000000o, n.toString());
        }
        if (!isNetworkAvailable) {
            L.e(O000000o, "networkAvailable: false");
        }
        if (!isForeground) {
            L.e(O000000o, "isForeground: false");
        }
        return this.O00000o && isNetworkAvailable && isForeground;
    }

    public void O00000Oo() {
        L.d(O000000o, "onDestroy");
        if (this.O00000oO) {
            this.O00000oO = false;
            this.O00000Oo.unregisterReceiver(this.O00000oo);
        }
        TuyaSmartSdk.getEventBus().unregister(this);
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        O000000o o000000o;
        StringBuilder n = a.n("network isAvailable: ");
        n.append(netWorkStatusEventModel.isAvailable());
        L.d(O000000o, n.toString());
        if (netWorkStatusEventModel.isAvailable() && (o000000o = this.O00000o0) != null) {
            o000000o.O000000o();
        }
    }

    public void onEvent(ForeGroundStatusModel foreGroundStatusModel) {
        if (foreGroundStatusModel.isForeground()) {
            L.d(O000000o, "app goto foreground，retry connect mqtt");
            O000000o o000000o = this.O00000o0;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
    }
}

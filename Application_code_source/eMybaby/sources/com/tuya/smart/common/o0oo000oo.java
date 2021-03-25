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

public class o0oo000oo implements NetWorkStatusEvent, ForeGroundStatusEvent {
    public static final String O000000o = "MqttMobileStatusCheck";
    public final Context O00000Oo;
    public volatile boolean O00000o = true;
    public O000000o O00000o0;
    public volatile boolean O00000oO;
    public volatile boolean O00000oo = false;
    public BroadcastReceiver O0000O0o = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                L.mqtt(o0oo000oo.O000000o, "screen on");
                boolean unused = o0oo000oo.this.O00000o = true;
                if (o0oo000oo.this.O00000o0 != null) {
                    o0oo000oo.this.O00000o0.O00000oO();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                L.mqtt(o0oo000oo.O000000o, "screen off");
                boolean unused2 = o0oo000oo.this.O00000o = false;
            }
        }
    };

    public interface O000000o {
        void O00000oO();
    }

    public o0oo000oo(Context context) {
        this.O00000Oo = context;
    }

    private void O00000o() {
        if (!this.O00000oO) {
            this.O00000oO = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.O00000Oo.registerReceiver(this.O0000O0o, intentFilter);
        }
    }

    private void O00000o0() {
        TuyaExecutor.getInstance().excutorDiscardOldestPolicy(new Runnable() {
            public void run() {
                o0oo000oo o0oo000oo;
                boolean z;
                PowerManager powerManager = (PowerManager) o0oo000oo.this.O00000Oo.getSystemService("power");
                if (powerManager != null) {
                    if (Build.VERSION.SDK_INT >= 20) {
                        o0oo000oo = o0oo000oo.this;
                        z = powerManager.isInteractive();
                    } else {
                        o0oo000oo = o0oo000oo.this;
                        z = powerManager.isScreenOn();
                    }
                    boolean unused = o0oo000oo.O00000o = z;
                    L.mqtt(o0oo000oo.O000000o, "ScreenOn: " + o0oo000oo.this.O00000o);
                }
            }
        });
        O00000o();
    }

    public void O000000o(O000000o o000000o) {
        if (!this.O00000oo) {
            this.O00000o0 = o000000o;
            TuyaSmartSdk.getEventBus().register(this);
            O00000o0();
            this.O00000oo = true;
        }
    }

    public boolean O000000o() {
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(this.O00000Oo);
        if (!this.O00000o) {
            StringBuilder n = a.n("screenOn: ");
            n.append(this.O00000o);
            L.mqtt(O000000o, n.toString());
        }
        if (!isNetworkAvailable) {
            L.mqtt(O000000o, "networkAvailable: false");
        }
        return this.O00000o && isNetworkAvailable;
    }

    public void O00000Oo() {
        if (this.O00000oo) {
            L.mqtt(O000000o, "onDestroy");
            if (this.O00000oO) {
                this.O00000oO = false;
                this.O00000Oo.unregisterReceiver(this.O0000O0o);
            }
            TuyaSmartSdk.getEventBus().unregister(this);
            this.O00000oo = false;
        }
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        O000000o o000000o;
        StringBuilder n = a.n("network change: ");
        n.append(netWorkStatusEventModel.isAvailable());
        L.mqtt(O000000o, n.toString());
        if (netWorkStatusEventModel.isAvailable() && (o000000o = this.O00000o0) != null) {
            o000000o.O00000oO();
        }
    }

    public void onEvent(ForeGroundStatusModel foreGroundStatusModel) {
        if (foreGroundStatusModel.isForeground()) {
            L.d(O000000o, "app goto foreground，retry connect mqtt");
            O000000o o000000o = this.O00000o0;
            if (o000000o != null) {
                o000000o.O00000oO();
            }
        }
    }
}

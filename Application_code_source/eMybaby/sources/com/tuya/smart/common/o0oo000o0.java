package com.tuya.smart.common;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tuya.sdk.mqttmanager.bean.MqttConfigBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.o0oo000oo;
import com.tuya.smart.mqtt.MqttServiceConstants;
import com.tuya.smart.mqtt.MqttTraceHandler;
import e.b.a.a.a.c;
import e.b.a.a.a.e;
import e.b.a.a.a.f;
import e.b.a.a.a.g;
import e.b.a.a.a.i;
import e.b.a.a.a.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.internal.ws.RealWebSocket;

public class o0oo000o0 implements Handler.Callback, o0oo00000, o0oo000oo.O000000o, o0oo0o0oo, c {
    public static final String O000000o = "MqttManager";
    public static final int O00000oo = 1;
    public static final int O0000O0o = 2;
    public static final int O0000OOo = 3;
    public final Context O00000Oo;
    public final o0oo0oo0o O00000o;
    public List<o0oo0oo00o> O00000o0;
    public SafeHandler O00000oO;
    public long O0000Oo;
    public AtomicBoolean O0000Oo0 = new AtomicBoolean(false);
    public o0oo000oo O0000OoO;
    public ReentrantReadWriteLock O0000Ooo;
    public long O0000o0;
    public boolean O0000o00 = false;
    public MqttConfigBean O0000o0O;

    public o0oo000o0(Context context, o0oo0oo00 o0oo0oo00, MqttConfigBean mqttConfigBean, Notification notification, int i, MqttTraceHandler mqttTraceHandler, f fVar) {
        this.O00000Oo = context;
        this.O00000o = O000000o(context, o0oo0oo00, mqttConfigBean, notification, i, mqttTraceHandler, fVar);
        this.O00000o0 = new ArrayList();
        this.O00000oO = new SafeHandler(Looper.getMainLooper(), (Handler.Callback) this);
        this.O0000OoO = new o0oo000oo(context);
        this.O0000Ooo = new ReentrantReadWriteLock(true);
    }

    private o0oo0oo0o O000000o(Context context, o0oo0oo00 o0oo0oo00, MqttConfigBean mqttConfigBean, Notification notification, int i, MqttTraceHandler mqttTraceHandler, final f fVar) {
        this.O0000o0O = mqttConfigBean;
        return new o0oo0oooo().O000000o(context).O000000o(o0oo0oo00).O000000o((o0oo0o0oo) this).O000000o(mqttConfigBean).O000000o(mqttTraceHandler).O000000o((c) this).O000000o((i) new i() {
            public void connectionLost(Throwable th) {
                o0oo000o0.this.O0000O0o();
                if (!o0oo000o0.this.O00000o0.isEmpty()) {
                    try {
                        o0oo000o0.this.O0000Ooo.readLock().lock();
                        for (o0oo0oo00o O000000o2 : o0oo000o0.this.O00000o0) {
                            O000000o2.O000000o("F004", th == null ? "" : th.getMessage());
                        }
                    } finally {
                        o0oo000o0.this.O0000Ooo.readLock().unlock();
                    }
                }
            }

            public void deliveryComplete(e eVar) {
            }

            public void messageArrived(String str, o oVar) {
                f fVar = fVar;
                if (fVar != null) {
                    try {
                        fVar.messageArrived(str, oVar);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }).O000000o(notification).O000000o(i).O0000Oo();
    }

    private void O00000oo() {
        L.d(O000000o, "realConnect");
        this.O0000Oo = System.currentTimeMillis();
        if (this.O0000o00 || TuyaUtil.isAppForeground(this.O00000Oo)) {
            this.O0000Oo0.set(true);
            this.O0000o0 = System.currentTimeMillis();
            o0oo0o0ooo o0oo0o0ooo = (o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class);
            if (o0oo0o0ooo != null) {
                o0oo0o0ooo.O000000o("015103896e0fee9bf42518e87ecf43f5", (Map<String, Object>) null);
            }
            this.O00000o.O000000o();
            L.d(O000000o, "connect background: " + this.O0000o00);
            return;
        }
        this.O00000oO.sendEmptyMessageDelayed(3, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    }

    /* access modifiers changed from: private */
    public void O0000O0o() {
        if (!O0000OoO()) {
            L.d(O000000o, "mqtt is connecting");
        } else if (this.O0000OoO.O000000o()) {
            L.d(O000000o, "go to connect");
            O0000Oo0();
        } else {
            L.d(O000000o, "wait for connect");
            O0000OOo();
        }
    }

    private void O0000OOo() {
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(2);
        this.O00000oO.sendEmptyMessageDelayed(2, 30000);
    }

    private void O0000Oo() {
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(3);
        this.O00000oO.removeMessages(2);
    }

    private void O0000Oo0() {
        L.d(O000000o, "reConnect");
        O0000Oo();
        this.O00000oO.sendEmptyMessageDelayed(1, o0oo00o0o.O000000o().O00000Oo());
    }

    private boolean O0000OoO() {
        return !this.O00000o.O00000o0() && (!this.O0000Oo0.get() || System.currentTimeMillis() - this.O0000Oo >= RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    }

    public void O000000o() {
        this.O0000OoO.O000000o((o0oo000oo.O000000o) this);
        L.d(O000000o, "start connect");
        O00000oo();
    }

    public void O000000o(o0oo0oo00o o0oo0oo00o) {
        if (o0oo0oo00o != null && !this.O00000o0.contains(o0oo0oo00o)) {
            try {
                this.O0000Ooo.writeLock().lock();
                this.O00000o0.add(o0oo0oo00o);
            } finally {
                this.O0000Ooo.writeLock().unlock();
            }
        }
    }

    public void O000000o(String str, int i, o0oo0ooo0 o0oo0ooo0) {
        this.O00000o.O000000o(str, i, o0oo0ooo0);
    }

    public void O000000o(String str, o0oo0ooo0 o0oo0ooo0) {
        this.O00000o.O000000o(str, o0oo0ooo0);
    }

    public void O000000o(String str, String str2) {
        L.d(O000000o, "onConnectError：" + str + " " + str2);
        o0oo0o0ooo o0oo0o0ooo = (o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class);
        if (o0oo0o0ooo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("port", Integer.valueOf(this.O0000o0O.getPort()));
            hashMap.put(MqttServiceConstants.TRACE_ERROR, str2);
            hashMap.put(BusinessResponse.KEY_ERRCODE, str);
            hashMap.put("ssl", Boolean.valueOf(this.O0000o0O.isSsl()));
            hashMap.put("host", this.O0000o0O.getServerUrl());
            o0oo0o0ooo.O000000o("7ff33bbc8ec019708cdb437ea12f9292", hashMap);
        }
        if (!this.O00000o0.isEmpty()) {
            try {
                this.O0000Ooo.readLock().lock();
                for (o0oo0oo00o O000000o2 : this.O00000o0) {
                    O000000o2.O000000o(str, str2);
                }
            } finally {
                this.O0000Ooo.readLock().unlock();
            }
        }
    }

    public void O000000o(String str, byte[] bArr, int i, boolean z, o0oo0ooo0 o0oo0ooo0) {
        this.O00000o.O000000o(str, bArr, i, z, o0oo0ooo0);
    }

    public void O000000o(String[] strArr, int[] iArr, o0oo0ooo0 o0oo0ooo0) {
        this.O00000o.O000000o(strArr, iArr, o0oo0ooo0);
    }

    public void O00000Oo() {
        this.O00000oO.destroy();
        L.d(O000000o, "close");
        if (!this.O00000o0.isEmpty()) {
            try {
                this.O0000Ooo.writeLock().lock();
                this.O00000o0.clear();
            } finally {
                this.O0000Ooo.writeLock().unlock();
            }
        }
        this.O0000OoO.O00000Oo();
        this.O00000o.O00000Oo();
    }

    public void O00000Oo(o0oo0oo00o o0oo0oo00o) {
        if (o0oo0oo00o != null && this.O00000o0.contains(o0oo0oo00o)) {
            try {
                this.O0000Ooo.writeLock().lock();
                this.O00000o0.remove(o0oo0oo00o);
            } finally {
                this.O0000Ooo.writeLock().unlock();
            }
        }
    }

    public void O00000o() {
        o0oo0o0ooo o0oo0o0ooo = (o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class);
        if (o0oo0o0ooo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timer", Long.valueOf(System.currentTimeMillis() - this.O0000o0));
            hashMap.put("port", Integer.valueOf(this.O0000o0O.getPort()));
            hashMap.put("ssl", Boolean.valueOf(this.O0000o0O.isSsl()));
            hashMap.put("host", this.O0000o0O.getServerUrl());
            o0oo0o0ooo.O000000o("f1b6fe85ba9f18c6e58ac3ec4a80623f", hashMap);
        }
        L.d(O000000o, "onConnectSuccess");
        if (!this.O00000o0.isEmpty()) {
            try {
                this.O0000Ooo.readLock().lock();
                for (o0oo0oo00o O000000o2 : this.O00000o0) {
                    O000000o2.O000000o();
                }
            } finally {
                this.O0000Ooo.readLock().unlock();
            }
        }
    }

    public boolean O00000o0() {
        return this.O00000o.O00000o0();
    }

    public void O00000oO() {
        L.d(O000000o, "deviceStatusOk");
        if (this.O0000OoO.O000000o()) {
            o0oo00o0o.O000000o().O00000o0();
        }
        O0000O0o();
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            O00000oo();
            return false;
        } else if (i != 2 && i != 3) {
            return false;
        } else {
            O0000O0o();
            return false;
        }
    }

    public void onFailure(g gVar, Throwable th) {
        this.O00000oO.removeMessages(3);
        this.O0000Oo0.set(false);
        O0000O0o();
    }

    public void onSuccess(g gVar) {
        this.O00000oO.removeMessages(3);
        this.O0000Oo0.set(false);
    }
}

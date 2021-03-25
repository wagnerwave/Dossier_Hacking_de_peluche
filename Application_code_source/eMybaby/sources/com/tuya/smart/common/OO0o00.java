package com.tuya.smart.common;

import a.a.a.a.a;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.config.enums.GwModeEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.api.config.IApConnectListener;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.interior.enums.ActiveEnum;
import com.tuya.smart.interior.enums.FrameTypeEnum;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class OO0o00 implements Handler.Callback, o0o00ooooo, o0o0o0o0o0, o0oo00oo00, IConfig {
    public static final String O000000o = "ApConfig";
    public static final int O00000Oo = 1;
    public static final int O00000o0 = 2;
    public OO0Oo00 O00000o;
    public String O00000oO;
    public SafeHandler O00000oo;
    public IApConnectListener O0000O0o;
    public volatile boolean O0000OOo;
    public volatile boolean O0000Oo;
    public volatile boolean O0000Oo0;
    public o0o00o0o00 O0000OoO = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));
    public o0o00o00o0 O0000Ooo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public TimerTask O0000o;
    public OOO0OO0 O0000o0;
    public OOO00Oo O0000o00;
    public Timer O0000o0O = new Timer();
    public TimerTask O0000o0o;

    /* renamed from: com.tuya.smart.common.OO0o00$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.tuya.smart.interior.enums.FrameTypeEnum[] r0 = com.tuya.smart.interior.enums.FrameTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                r1 = 1
                r2 = 2
                com.tuya.smart.interior.enums.FrameTypeEnum r3 = com.tuya.smart.interior.enums.FrameTypeEnum.ACTIVE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.tuya.smart.interior.enums.FrameTypeEnum r3 = com.tuya.smart.interior.enums.FrameTypeEnum.AP_CONFIG     // Catch:{ NoSuchFieldError -> 0x0015 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OO0o00.AnonymousClass6.<clinit>():void");
        }
    }

    public OO0o00(OO0Oo00 oO0Oo00) {
        this.O00000o = oO0Oo00;
        O000000o();
    }

    private void O000000o() {
        this.O0000O0o = this.O00000o.O00000oO();
        this.O00000oo = new SafeHandler(Looper.myLooper(), (Handler.Callback) this);
        this.O00000oO = null;
        OOOo00.O000000o();
        this.O0000Ooo.O0000o00().registerDeviceHardwareResponseListener(FrameTypeEnum.ACTIVE.getType(), this);
        this.O0000Ooo.O0000o00().registerDeviceHardwareResponseListener(FrameTypeEnum.AP_CONFIG.getType(), this);
        this.O0000Ooo.O0000o00().registerTuyaHardwareOnlineStatusListener(this);
    }

    private void O000000o(String str) {
        LogUtils.logServer(OOOOO00.O00000Oo, OOOOO00.O000000o(OOOOO00.O0000OoO, this.O00000o.O0000Oo0()));
        OOO00Oo oOO00Oo = this.O0000o00;
        if (oOO00Oo != null) {
            oOO00Oo.O00000oO().put("step", "tcp_connect");
        }
        if (this.O0000o0 != null) {
            this.O0000o0.O00000Oo((Map<String, Object>) null, a.r("step", "tcp_connect"));
        }
        IApConnectListener iApConnectListener = this.O0000O0o;
        if (iApConnectListener != null) {
            iApConnectListener.onDeviceConnect(str);
        }
    }

    private void O00000Oo() {
        O00000o0();
        this.O0000Oo0 = false;
        AnonymousClass2 r2 = new TimerTask() {
            public void run() {
                if (OO0o00.this.O0000Oo) {
                    OO0o00.this.O0000o0o.cancel();
                } else {
                    OO0o00.this.O00000oO();
                }
            }
        };
        this.O0000o0o = r2;
        this.O0000o0O.schedule(r2, 0, 2000);
    }

    private void O00000Oo(String str) {
        O00000o0();
        this.O00000oO = str;
        this.O0000Oo = false;
        AnonymousClass1 r1 = new TimerTask() {
            public void run() {
                if (OO0o00.this.O0000Oo0) {
                    OO0o00.this.O0000o.cancel();
                } else {
                    OO0o00.this.O00000o();
                }
            }
        };
        this.O0000o = r1;
        this.O0000o0O.schedule(r1, 0, 2000);
    }

    /* access modifiers changed from: private */
    public void O00000Oo(String str, int i, boolean z, byte[] bArr) {
        FrameTypeEnum frameTypeEnum;
        L.d(O000000o, str);
        if (this.O0000OOo && TextUtils.equals(this.O00000oO, str) && z && (frameTypeEnum = FrameTypeEnum.to(i)) != null) {
            int i2 = AnonymousClass6.O000000o[frameTypeEnum.ordinal()];
            if (i2 == 1) {
                this.O0000OOo = false;
                this.O0000Oo = true;
                IApConnectListener iApConnectListener = this.O0000O0o;
                if (iApConnectListener != null) {
                    iApConnectListener.onActiveCommandSuccess();
                }
                OOOo00.O000000o(this.O00000oO);
                WiFiUtil.enableNetwork(this.O00000o.O000000o(), this.O00000o.O00000o0());
            } else if (i2 == 2) {
                this.O0000Oo0 = true;
                IApConnectListener iApConnectListener2 = this.O0000O0o;
                if (iApConnectListener2 != null) {
                    iApConnectListener2.onConfigSuccess();
                }
                O00000Oo();
            }
        }
    }

    /* access modifiers changed from: private */
    public void O00000o() {
        this.O00000oo.sendEmptyMessage(1);
    }

    private void O00000o0() {
        TimerTask timerTask = this.O0000o0o;
        if (timerTask != null) {
            timerTask.cancel();
        }
        TimerTask timerTask2 = this.O0000o;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
    }

    /* access modifiers changed from: private */
    public void O00000oO() {
        this.O00000oo.sendEmptyMessage(2);
    }

    private void O00000oo() {
        OOOo00.O000000o(this.O00000oO, TuyaSmartNetWork.getGwApiUrl(), TuyaSmartNetWork.getGwMqttUrl(), (IResultCallback) new IResultCallback() {
            public void onError(String str, String str2) {
            }

            public void onSuccess() {
            }
        });
    }

    private void O0000O0o() {
        L.d(O000000o, "ap config send");
        OOOo00.O000000o(this.O00000oO, this.O00000o.O00000o0(), this.O00000o.O00000o(), (IResultCallback) new IResultCallback() {
            public void onError(String str, String str2) {
            }

            public void onSuccess() {
            }
        });
    }

    public void O000000o(HgwBean hgwBean, boolean z) {
        if (this.O0000OOo) {
            L.d(O000000o, "online: " + z + "; gwid: " + hgwBean.getGwId());
            if (z && hgwBean.getMode() == GwModeEnum.AP.getType()) {
                String gwId = hgwBean.getGwId();
                O000000o(gwId);
                O00000Oo(gwId);
                L.d(O000000o, "sendConfigCommand by hgw online");
            }
        }
    }

    public void O000000o(OOO00Oo oOO00Oo) {
        this.O0000o00 = oOO00Oo;
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000o0 = ooo0oo0;
    }

    public void O000000o(String str, int i, boolean z, byte[] bArr) {
        Activity activity = (Activity) this.O00000o.O000000o();
        if (!activity.isFinishing()) {
            final String str2 = str;
            final int i2 = i;
            final boolean z2 = z;
            final byte[] bArr2 = bArr;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    OO0o00.this.O00000Oo(str2, i2, z2, bArr2);
                }
            });
        }
    }

    public void O000000o(List<HgwBean> list) {
        o0o00o0o00 o0o00o0o00;
        for (HgwBean next : list) {
            if (next.getActive() == ActiveEnum.UNACTIVE.getType() && next.getMode() == GwModeEnum.AP.getType() && (o0o00o0o00 = this.O0000OoO) != null) {
                o0o00o0o00.O000000o().O000000o(next);
                OOO00Oo oOO00Oo = this.O0000o00;
                if (oOO00Oo != null) {
                    oOO00Oo.O00000oo().put("type", OO0OO0o.O00000o0.O000000o);
                }
                if (this.O0000o0 != null) {
                    this.O0000o0.O00000Oo(a.r("type", OO0OO0o.O00000o0.O000000o), (Map<String, Object>) null);
                }
            }
        }
    }

    public void cancel() {
        if (this.O0000OOo) {
            this.O0000OOo = false;
            o0o00o0o00 o0o00o0o00 = this.O0000OoO;
            if (o0o00o0o00 != null) {
                o0o00o0o00.O000000o().O00000Oo((o0oo00oo00) this);
            }
            this.O0000Ooo.O0000o00().unRegisterDeviceHardwareResponseListener(this);
            this.O0000Ooo.O0000o00().unRegisterDeviceHardwareResponseListener(this);
            this.O0000Ooo.O0000o00().unRegisterTuyaHardwareOnlineStatusListener(this);
            O00000o0();
        }
    }

    public boolean handleMessage(Message message) {
        HashMap hashMap;
        String str;
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                O00000oo();
                OOO00Oo oOO00Oo = this.O0000o00;
                str = "activate";
                if (oOO00Oo != null) {
                    oOO00Oo.O00000oO().put("step", str);
                }
                if (this.O0000o0 != null) {
                    hashMap = new HashMap();
                }
            }
            return true;
        }
        O0000O0o();
        OOO00Oo oOO00Oo2 = this.O0000o00;
        str = "config";
        if (oOO00Oo2 != null) {
            oOO00Oo2.O00000oO().put("step", str);
        }
        if (this.O0000o0 != null) {
            hashMap = new HashMap();
        }
        return true;
        hashMap.put("step", str);
        this.O0000o0.O00000Oo((Map<String, Object>) null, hashMap);
        return true;
    }

    public void onDestroy() {
        cancel();
        TuyaSdk.getEventBus().unregister(this);
        SafeHandler safeHandler = this.O00000oo;
        if (safeHandler != null) {
            safeHandler.destroy();
        }
        this.O00000oO = null;
        this.O0000o0O.cancel();
        this.O0000o0O.purge();
    }

    public void start() {
        if (!this.O0000OOo) {
            this.O0000OOo = true;
            o0o00o0o00 o0o00o0o00 = this.O0000OoO;
            if (o0o00o0o00 != null) {
                o0o00o0o00.O000000o().O000000o((o0oo00oo00) this);
            }
        }
    }
}

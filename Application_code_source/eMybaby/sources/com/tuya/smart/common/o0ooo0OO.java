package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.home.sdk.api.config.IConnectListener;
import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.enums.ActivatorModelEnum;

public class o0ooo0OO implements ITuyaActivator {
    public static final String O000000o = "TuyaMultiConnect";
    public final ActivatorBuilder O00000Oo;
    public IConfig O00000o;
    public final ITuyaSmartActivatorListener O00000o0;

    /* renamed from: com.tuya.smart.common.o0ooo0OO$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.tuya.smart.sdk.enums.ActivatorModelEnum[] r0 = com.tuya.smart.sdk.enums.ActivatorModelEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                r1 = 1
                com.tuya.smart.sdk.enums.ActivatorModelEnum r2 = com.tuya.smart.sdk.enums.ActivatorModelEnum.TY_AP     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.tuya.smart.sdk.enums.ActivatorModelEnum r2 = com.tuya.smart.sdk.enums.ActivatorModelEnum.TY_EZ     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0ooo0OO.AnonymousClass2.<clinit>():void");
        }
    }

    public o0ooo0OO(ActivatorBuilder activatorBuilder) {
        this.O00000Oo = activatorBuilder;
        if (activatorBuilder == null) {
            throw new NullPointerException("builder cannot be null");
        } else if (activatorBuilder.getContext() == null) {
            throw new NullPointerException("context cannot be null");
        } else if (!TextUtils.isEmpty(this.O00000Oo.getSsid())) {
            this.O00000o0 = this.O00000Oo.getListener();
            ActivatorModelEnum activatorModel = this.O00000Oo.getActivatorModel();
            if (activatorModel != null) {
                int i = AnonymousClass2.O000000o[activatorModel.ordinal()];
                if (i == 1) {
                    throw new RuntimeException("Multi Config don't support the AP Mode");
                } else if (i == 2) {
                    this.O00000o = O000000o();
                }
            } else {
                throw new RuntimeException("ActivatorModel cannot be null");
            }
        } else {
            throw new RuntimeException("ssid cannot be empty");
        }
    }

    private IConfig O000000o() {
        return new o0OOoOoo((OOOOo0) new OOOOo0(this.O00000Oo.getContext()).O00000Oo(this.O00000Oo.getPassword()).O000000o(this.O00000Oo.getSsid()).O00000o0(this.O00000Oo.getToken()).O000000o(this.O00000Oo.getTimeOut()).O000000o((IConnectListener) new IConnectListener() {
            public void onActiveError(String str, String str2) {
                LogUtils.logServer(OOOOO00.O000000o, TextUtils.equals("1006", str) ? OOOOO00.O000000o(OOOOO00.O0000O0o, o0ooo0OO.this.O00000Oo.getToken()) : OOOOO00.O000000o(OOOOO00.O0000Oo0, o0ooo0OO.this.O00000Oo.getToken(), str));
                if (o0ooo0OO.this.O00000o0 != null) {
                    o0ooo0OO.this.O00000o0.onError(str, str2);
                }
            }

            public void onActiveSuccess(DeviceBean deviceBean) {
                LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O00000oo, o0ooo0OO.this.O00000Oo.getToken()));
                if (o0ooo0OO.this.O00000o0 != null) {
                    o0ooo0OO.this.O00000o0.onActiveSuccess(deviceBean);
                }
            }

            public void onConfigEnd() {
            }

            public void onConfigStart() {
            }

            public void onDeviceBindSuccess(DeviceBean deviceBean) {
                LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O00000oO, o0ooo0OO.this.O00000Oo.getToken()));
                if (o0ooo0OO.this.O00000o0 != null) {
                    o0ooo0OO.this.O00000o0.onStep("device_bind_success", deviceBean);
                }
            }

            public void onDeviceFind(String str) {
                if (o0ooo0OO.this.O00000o0 != null) {
                    o0ooo0OO.this.O00000o0.onStep("device_find", str);
                }
            }

            public void onWifiError(String str) {
            }
        }));
    }

    public void onDestroy() {
        this.O00000o.onDestroy();
    }

    public void start() {
        LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O00000o0, this.O00000Oo.getToken()));
        this.O00000o.start();
    }

    public void stop() {
        this.O00000o.cancel();
    }
}

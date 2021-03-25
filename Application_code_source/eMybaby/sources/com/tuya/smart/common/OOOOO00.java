package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.home.sdk.api.config.IApConnectListener;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.home.sdk.api.config.IConnectListener;
import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.mqtt.MqttServiceConstants;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.enums.ActivatorModelEnum;
import java.util.HashMap;

public class OOOOO00 implements ITuyaActivator {
    public static final String O000000o = "wifi_config_ez";
    public static final String O00000Oo = "wifi_config_ap";
    public static final String O00000o = "active_device";
    public static final String O00000o0 = "start_config";
    public static final String O00000oO = "bind_device";
    public static final String O00000oo = "config_success";
    public static final String O0000O0o = "config_failure";
    public static final String O0000OOo = "bind_home_id";
    public static final String O0000Oo = "udp_wifi_change";
    public static final String O0000Oo0 = "config_error_info";
    public static final String O0000OoO = "udp_search";
    public static final String O0000Ooo = "TuyaConnect";
    public final ITuyaSmartActivatorListener O0000o0;
    public final ActivatorBuilder O0000o00;
    public IConfig O0000o0O;

    /* renamed from: com.tuya.smart.common.OOOOO00$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.OOOOO00.AnonymousClass3.<clinit>():void");
        }
    }

    public OOOOO00(ActivatorBuilder activatorBuilder) {
        IConfig iConfig;
        this.O0000o00 = activatorBuilder;
        if (activatorBuilder == null) {
            throw new NullPointerException("builder cannot be null");
        } else if (activatorBuilder.getContext() == null) {
            throw new NullPointerException("context cannot be null");
        } else if (!TextUtils.isEmpty(activatorBuilder.getSsid())) {
            this.O0000o0 = this.O0000o00.getListener();
            ActivatorModelEnum activatorModel = activatorBuilder.getActivatorModel();
            if (activatorModel != null) {
                int i = AnonymousClass3.O000000o[activatorModel.ordinal()];
                if (i == 1) {
                    iConfig = O00000Oo();
                } else if (i == 2) {
                    iConfig = O000000o();
                } else {
                    return;
                }
                this.O0000o0O = iConfig;
                return;
            }
            throw new RuntimeException("ActivatorModel cannot be null");
        } else {
            throw new RuntimeException("ssid cannot be empty");
        }
    }

    private IConfig O000000o() {
        return new Oo00000(new OOO0o0(this.O0000o00.getContext()).O00000Oo(this.O0000o00.getPassword()).O000000o(this.O0000o00.getSsid()).O00000o0(this.O0000o00.getToken()).O000000o(this.O0000o00.getTimeOut()).O000000o((IConnectListener) new IConnectListener() {
            public void onActiveError(String str, String str2) {
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onError(str, str2);
                }
                LogUtils.logServer(OOOOO00.O000000o, TextUtils.equals("1006", str) ? OOOOO00.O000000o(OOOOO00.O0000O0o, OOOOO00.this.O0000o00.getToken()) : OOOOO00.O000000o(OOOOO00.O0000Oo0, OOOOO00.this.O0000o00.getToken(), str));
            }

            public void onActiveSuccess(DeviceBean deviceBean) {
                LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O00000oo, OOOOO00.this.O0000o00.getToken()));
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onActiveSuccess(deviceBean);
                }
            }

            public void onConfigEnd() {
            }

            public void onConfigStart() {
            }

            public void onDeviceBindSuccess(DeviceBean deviceBean) {
                LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O00000oO, OOOOO00.this.O0000o00.getToken()));
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onStep("device_bind_success", deviceBean);
                }
                L.d(OOOOO00.O0000Ooo, "onDeviceBindSuccess");
            }

            public void onDeviceFind(String str) {
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onStep("device_find", str);
                }
            }

            public void onWifiError(String str) {
            }
        }));
    }

    public static HashMap<String, Object> O000000o(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("step", str);
        hashMap.put("token", str2);
        return hashMap;
    }

    public static HashMap<String, Object> O000000o(String str, String str2, String str3) {
        HashMap<String, Object> O000000o2 = O000000o(str, str2);
        O000000o2.put(MqttServiceConstants.TRACE_ERROR, str3);
        return O000000o2;
    }

    private IConfig O00000Oo() {
        return new OOo0(new OO0Oo00().O00000Oo(this.O0000o00.getSsid()).O00000o0(this.O0000o00.getPassword()).O00000o(this.O0000o00.getToken()).O000000o(this.O0000o00.getContext()).O000000o(this.O0000o00.getTimeOut()).O000000o((IApConnectListener) new IApConnectListener() {
            public void onActiveCommandError(int i) {
            }

            public void onActiveCommandSuccess() {
            }

            public void onActiveError(String str, String str2) {
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onError(str, str2);
                }
                LogUtils.logServer(OOOOO00.O000000o, TextUtils.equals("1006", str) ? OOOOO00.O000000o(OOOOO00.O0000O0o, OOOOO00.this.O0000o00.getToken()) : OOOOO00.O000000o(OOOOO00.O0000Oo0, OOOOO00.this.O0000o00.getToken(), str));
            }

            public void onActiveSuccess(DeviceBean deviceBean) {
                L.d(OOOOO00.O0000Ooo, "onActiveSuccess");
                LogUtils.logServer(OOOOO00.O00000Oo, OOOOO00.O000000o(OOOOO00.O00000oo, OOOOO00.this.O0000o00.getToken()));
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onActiveSuccess(deviceBean);
                }
            }

            public void onConfigError(int i) {
            }

            public void onConfigSuccess() {
            }

            public void onDeviceBindSuccess(DeviceBean deviceBean) {
                L.d(OOOOO00.O0000Ooo, "onDeviceBindSuccess");
                LogUtils.logServer(OOOOO00.O00000Oo, OOOOO00.O000000o(OOOOO00.O00000oO, OOOOO00.this.O0000o00.getToken()));
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onStep("device_bind_success", deviceBean);
                }
            }

            public void onDeviceConnect(String str) {
                a.v("deviceConnnect ", str, OOOOO00.O0000Ooo);
                if (OOOOO00.this.O0000o0 != null) {
                    OOOOO00.this.O0000o0.onStep("device_find", str);
                }
            }

            public void onDeviceDisconnect(String str) {
            }
        }));
    }

    public void onDestroy() {
        this.O0000o0O.onDestroy();
    }

    public void start() {
        this.O0000o0O.start();
        LogUtils.logServer(this.O0000o0O instanceof OOOO0 ? O000000o : O00000Oo, O000000o(O00000o0, this.O0000o00.getToken()));
    }

    public void stop() {
        this.O0000o0O.cancel();
    }
}

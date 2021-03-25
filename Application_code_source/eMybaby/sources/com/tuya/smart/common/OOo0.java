package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.api.config.IApConnectListener;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.home.sdk.api.config.IConnectListener;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class OOo0 extends OOO000o implements IApConnectListener, IConfig {
    public static final String O000000o = "TuyaSmartApConnect";
    public final OO0Oo00 O00000Oo;
    public OO0o O00000o;
    public OO0o00 O00000o0;
    public IApConnectListener O00000oO;
    public OOO0O0O O00000oo;
    public String O0000O0o;
    public OOO00Oo O0000OOo;
    public OOO0OO0 O0000Oo;
    public o0oo0o0ooo O0000Oo0 = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));

    public OOo0(OO0Oo00 oO0Oo00) {
        this.O00000Oo = oO0Oo00;
        O000000o(oO0Oo00.O0000Oo());
        this.O00000oO = oO0Oo00.O00000oO();
        this.O00000o0 = oO0Oo00.O000000o((IApConnectListener) this).O0000O0o();
        if (oO0Oo00.O0000Oo0() != null) {
            this.O00000o = oO0Oo00.O000000o((IApConnectListener) this).O0000OOo();
        }
        this.O0000OOo = new OOO00Oo(new HashMap(), new HashMap(), new HashMap());
        this.O0000Oo = new OOO0OO0();
        O00000o0();
        this.O0000O0o = oO0Oo00.O0000Oo0();
    }

    private void O00000o0() {
        OOO0O0O ooo0o0o = new OOO0O0O(this.O00000Oo.O000000o(), new IConnectListener() {
            public void onActiveError(String str, String str2) {
                OOo0.this.onActiveError(str, str2);
            }

            public void onActiveSuccess(DeviceBean deviceBean) {
                OOo0.this.onActiveSuccess(deviceBean);
            }

            public void onConfigEnd() {
            }

            public void onConfigStart() {
            }

            public void onDeviceBindSuccess(DeviceBean deviceBean) {
                OOo0.this.onDeviceBindSuccess(deviceBean);
            }

            public void onDeviceFind(String str) {
            }

            public void onWifiError(String str) {
            }
        });
        this.O00000oo = ooo0o0o;
        ooo0o0o.O000000o(this.O0000OOo);
        this.O00000oo.O000000o(this.O0000Oo);
    }

    public void cancel() {
        super.cancel();
        this.O00000o0.cancel();
        OO0o oO0o = this.O00000o;
        if (oO0o != null) {
            oO0o.cancel();
        }
        this.O00000oo.O000000o();
    }

    public void onActiveCommandError(int i) {
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onActiveCommandError(i);
        }
    }

    public void onActiveCommandSuccess() {
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onActiveCommandSuccess();
        }
    }

    public void onActiveError(String str, String str2) {
        super.onActiveError(str, str2);
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onActiveError(str, str2);
            OOO00Oo oOO00Oo = this.O0000OOo;
            if (oOO00Oo != null) {
                this.O0000OOo.O00000oO().put("type", (String) oOO00Oo.O00000oo().get("type"));
                this.O0000OOo.O00000oO().put("token", this.O0000O0o);
                this.O0000OOo.O00000oO().put("bssid", WiFiUtil.getBssid(TuyaSdk.getApplication()));
                o0oo0o0ooo o0oo0o0ooo = this.O0000Oo0;
                if (o0oo0o0ooo != null) {
                    o0oo0o0ooo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", this.O0000OOo.O00000oo());
                    this.O0000Oo0.O000000o("f22f53893cedc95aa34844b792f341ba", this.O0000OOo.O00000oO());
                }
            }
            if (this.O0000Oo != null) {
                this.O0000Oo.O00000o0(a.r("config_result", "failure"), (Map<String, Object>) null);
            }
        }
    }

    public void onActiveSuccess(DeviceBean deviceBean) {
        super.O00000Oo();
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onActiveSuccess(deviceBean);
            OOO00Oo oOO00Oo = this.O0000OOo;
            if (oOO00Oo != null) {
                oOO00Oo.O00000Oo(System.currentTimeMillis());
                this.O0000OOo.O00000o().put("type", (String) this.O0000OOo.O00000oo().get("type"));
                this.O0000OOo.O00000o().put("time", Long.valueOf((this.O0000OOo.O00000o0() - this.O0000OOo.O00000Oo()) / 1000));
                o0oo0o0ooo o0oo0o0ooo = this.O0000Oo0;
                if (o0oo0o0ooo != null) {
                    o0oo0o0ooo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", this.O0000OOo.O00000oo());
                    this.O0000Oo0.O000000o(OO0OO0o.O000000o.O000000o, this.O0000OOo.O00000o());
                }
            }
            if (this.O0000Oo != null) {
                this.O0000Oo.O00000o0(a.r("config_result", "success"), (Map<String, Object>) null);
            }
        }
    }

    public void onConfigError(int i) {
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onConfigError(i);
        }
    }

    public void onConfigSuccess() {
        LogUtils.logServer(OOOOO00.O00000Oo, OOOOO00.O000000o(OOOOO00.O00000o, this.O0000O0o));
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onConfigSuccess();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000o0.onDestroy();
        OO0o oO0o = this.O00000o;
        if (oO0o != null) {
            oO0o.onDestroy();
        }
        this.O00000oo.onDestroy();
    }

    public void onDeviceBindSuccess(DeviceBean deviceBean) {
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onDeviceBindSuccess(deviceBean);
        }
    }

    public void onDeviceConnect(String str) {
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onDeviceConnect(str);
        }
        OOOO00O oooo00o = new OOOO00O();
        oooo00o.O00000Oo(str);
        oooo00o.O00000o(true);
        oooo00o.O00000o0(true);
        this.O00000oo.O000000o(oooo00o, this.O0000O0o);
    }

    public void onDeviceDisconnect(String str) {
        IApConnectListener iApConnectListener = this.O00000oO;
        if (iApConnectListener != null) {
            iApConnectListener.onDeviceDisconnect(str);
        }
    }

    public void start() {
        super.start();
        OOO00Oo oOO00Oo = this.O0000OOo;
        if (oOO00Oo != null) {
            this.O00000o0.O000000o(oOO00Oo);
            this.O0000OOo.O000000o(System.currentTimeMillis());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token", this.O00000Oo.O0000Oo0());
        this.O0000Oo.O000000o(hashMap, (Map<String, Object>) null);
        this.O00000o0.O000000o(this.O0000Oo);
        this.O00000o0.start();
        OO0o oO0o = this.O00000o;
        if (oO0o != null) {
            OOO00Oo oOO00Oo2 = this.O0000OOo;
            if (oOO00Oo2 != null) {
                oO0o.O000000o(oOO00Oo2);
            }
            this.O00000o.O000000o(this.O0000Oo);
            this.O00000o.start();
        }
    }
}

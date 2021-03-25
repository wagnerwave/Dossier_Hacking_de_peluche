package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.common.OOO00O0;
import com.tuya.smart.common.OOOO0O;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.home.sdk.api.config.IConnectListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;
import java.util.Map;

public class OOOO0 implements IConfig {
    public static final String O000000o = "MultiEZConfig";
    public final OOO O00000Oo;
    public final IConnectListener O00000o;
    public final Context O00000o0;
    public final OOOO0O O00000oO;
    public final String O00000oo;
    public OOO0O0O O0000O0o;
    public volatile boolean O0000OOo;
    public volatile boolean O0000Oo;
    public Thread O0000Oo0;
    public o0o00o00o0 O0000OoO = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public o0oo0o0ooo O0000Ooo = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public OOO0OO0 O0000o00;

    public OOOO0(OOO0o0 oOO0o0) {
        this.O00000o0 = oOO0o0.O00000o0();
        this.O00000o = oOO0o0.O00000o();
        OOOO0O oooo0o = new OOOO0O(this.O00000o0);
        this.O00000oO = oooo0o;
        oooo0o.O000000o(oOO0o0);
        this.O00000oo = oOO0o0.O00000oo();
        StringBuilder n = a.n("ssid: ");
        n.append(oOO0o0.O000000o());
        L.d(O000000o, n.toString());
        this.O00000Oo = new OOO(this.O00000o0, this.O00000oo);
        OOO0O0O ooo0o0o = new OOO0O0O(this.O00000o0, new IConnectListener() {
            public void onActiveError(String str, String str2) {
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onActiveError(str, str2);
                }
            }

            public void onActiveSuccess(DeviceBean deviceBean) {
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onActiveSuccess(deviceBean);
                    OOO00Oo O00000o0 = OOOO0.this.O00000Oo.O00000o0();
                    if (O00000o0 != null && !O00000o0.O000000o()) {
                        O00000o0.O000000o(true);
                        O00000o0.O00000Oo(System.currentTimeMillis());
                        O00000o0.O00000o().put("type", OO0OO0o.O00000o0.O00000o0);
                        O00000o0.O00000o().put("time", Integer.valueOf(((int) (O00000o0.O00000o0() - O00000o0.O00000Oo())) / 1000));
                        if (OOOO0.this.O0000Ooo != null) {
                            OOOO0.this.O0000Ooo.O000000o(OO0OO0o.O000000o.O000000o, O00000o0.O00000o());
                        }
                    }
                }
            }

            public void onConfigEnd() {
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onConfigEnd();
                }
            }

            public void onConfigStart() {
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onConfigStart();
                }
            }

            public void onDeviceBindSuccess(DeviceBean deviceBean) {
                if (OOOO0.this.O0000Oo0 != null) {
                    OOOO0.this.O0000Oo0.interrupt();
                }
                boolean unused = OOOO0.this.O0000Oo = true;
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onDeviceBindSuccess(deviceBean);
                }
            }

            public void onDeviceFind(String str) {
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onDeviceFind(str);
                }
            }

            public void onWifiError(String str) {
                if (OOOO0.this.O00000o != null) {
                    OOOO0.this.O00000o.onWifiError(str);
                }
            }
        });
        this.O0000O0o = ooo0o0o;
        ooo0o0o.O000000o(this.O00000Oo.O00000o0());
        O00000o0();
    }

    /* access modifiers changed from: private */
    public void O000000o(final String str) {
        this.O0000Oo = false;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                final boolean[] zArr = {false};
                while (!OOOO0.this.O0000Oo && !OOOO0.this.O0000OOo) {
                    OOOo00.O000000o(str, TuyaSmartNetWork.getGwApiUrl(), TuyaSmartNetWork.getGwMqttUrl(), (IResultCallback) new IResultCallback() {
                        public void onError(String str, String str2) {
                            L.d(OOOO0.O000000o, "old device config failure");
                        }

                        public void onSuccess() {
                            OOOO00O oooo00o = new OOOO00O();
                            oooo00o.O00000Oo(str);
                            oooo00o.O00000o0(false);
                            LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O00000o, OOOO0.this.O00000oo));
                            boolean[] zArr = zArr;
                            if (!zArr[0]) {
                                zArr[0] = true;
                                OOOO0.this.O0000O0o.O000000o(oooo00o, OOOO0.this.O00000oo);
                            }
                            L.d(OOOO0.O000000o, "old device config success");
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
        });
        this.O0000Oo0 = thread;
        thread.start();
    }

    private void O00000o0() {
        this.O00000oO.O000000o((OOOO0O.O000000o) new OOOO0O.O000000o() {
            public void O000000o(DeviceBean deviceBean) {
                if (!OOOO0.this.O0000OOo && OOOO0.this.O00000o != null) {
                    StringBuilder n = a.n("device online");
                    n.append(deviceBean.getDevId());
                    L.d(OOOO0.O000000o, n.toString());
                    OOOO0.this.O00000o.onActiveSuccess(deviceBean);
                    OOO00Oo O000000o2 = OOOO0.this.O00000oO.O000000o();
                    if (O000000o2 != null && !O000000o2.O000000o()) {
                        O000000o2.O000000o(true);
                        O000000o2.O00000Oo(System.currentTimeMillis());
                        O000000o2.O00000o().put("type", OO0OO0o.O00000o0.O00000oo);
                        O000000o2.O00000o().put("time", Integer.valueOf(((int) (O000000o2.O00000o0() - O000000o2.O00000Oo())) / 1000));
                        if (OOOO0.this.O0000Ooo != null) {
                            OOOO0.this.O0000Ooo.O000000o(OO0OO0o.O000000o.O000000o, O000000o2.O00000o());
                        }
                    }
                }
            }

            public void O000000o(List<DeviceBean> list) {
                if (!OOOO0.this.O0000OOo) {
                    for (DeviceBean next : list) {
                        if (OOOO0.this.O00000o != null) {
                            OOOO0.this.O00000o.onDeviceFind(next.getDevId());
                        }
                        if (OOOO0.this.O00000o != null) {
                            OOOO0.this.O00000o.onDeviceBindSuccess(next);
                        }
                        StringBuilder n = a.n("find device");
                        n.append(next.getDevId());
                        L.d(OOOO0.O000000o, n.toString());
                    }
                }
            }

            public void O00000Oo(List<ConfigErrorRespBean> list) {
                if (!OOOO0.this.O0000OOo && OOOO0.this.O00000o != null && list != null && list.size() > 0) {
                    OOOO0.this.O00000o.onActiveError("1007", JSON.toJSONString(list));
                }
            }
        });
        this.O00000Oo.O000000o(new OOO00O0.O000000o() {
            public void O000000o(final String str) {
                OOOO0.this.O00000Oo.O00000Oo();
                if (!OOOO0.this.O0000OOo) {
                    a.v("oldDeviceActive: ", str, OOOO0.O000000o);
                    if (OOOO0.this.O00000o != null) {
                        OOOO0.this.O00000o.onDeviceFind(str);
                    }
                    if (OOOO0.this.O0000OoO != null) {
                        OOO00Oo O00000o0 = OOOO0.this.O00000Oo.O00000o0();
                        if (O00000o0 != null) {
                            O00000o0.O00000oO().put("step", OO0OO0o.O00000Oo.O0000Oo);
                        }
                        if (OOOO0.this.O0000o00 != null) {
                            OOOO0.this.O0000o00.O00000Oo((Map<String, Object>) null, a.r("step", OO0OO0o.O00000Oo.O0000Oo));
                        }
                        OOOO0.this.O0000OoO.O000000o(str).removeDevice(new IResultCallback() {
                            public void onError(String str, String str2) {
                                OOOO0.this.O000000o(str);
                            }

                            public void onSuccess() {
                                OOOO0.this.O000000o(str);
                            }
                        });
                    }
                }
            }
        });
    }

    public OOO O000000o() {
        return this.O00000Oo;
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000o00 = ooo0oo0;
    }

    public OOOO0O O00000Oo() {
        return this.O00000oO;
    }

    public void cancel() {
        L.d(O000000o, "MultiEZConfig cancel");
        this.O0000O0o.O000000o();
        this.O0000OOo = true;
        this.O00000Oo.O00000Oo();
        this.O00000oO.O00000o0();
        Thread thread = this.O0000Oo0;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public void onDestroy() {
        L.d(O000000o, "MultiEZConfig onDestroy");
        cancel();
        this.O0000O0o.onDestroy();
        this.O00000oO.onDestroy();
        this.O00000Oo.onDestroy();
    }

    public void start() {
        L.d(O000000o, "MultiEZConfig start");
        this.O00000Oo.O000000o(this.O0000o00);
        this.O00000oO.O000000o(this.O0000o00);
        this.O0000O0o.O000000o(this.O0000o00);
        this.O0000O0o.O000000o();
        this.O0000OOo = false;
        this.O00000Oo.O000000o();
        this.O00000oO.O00000Oo();
        OOO00Oo O000000o2 = this.O00000oO.O000000o();
        if (O000000o2 != null) {
            O000000o2.O000000o(System.currentTimeMillis());
            O000000o2.O00000oo().put("type", OO0OO0o.O00000o0.O00000oo);
            o0oo0o0ooo o0oo0o0ooo = this.O0000Ooo;
            if (o0oo0o0ooo != null) {
                o0oo0o0ooo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", O000000o2.O00000oo());
            }
        }
    }
}

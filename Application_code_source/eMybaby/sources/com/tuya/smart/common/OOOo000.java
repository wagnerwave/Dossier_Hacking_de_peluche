package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.TuyaCache;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.api.IGwSearchListener;
import com.tuya.smart.home.sdk.api.config.IGwConfigListener;
import com.tuya.smart.home.sdk.builder.TuyaGwActivatorBuilder;
import com.tuya.smart.interior.enums.ActiveEnum;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OOOo000 implements ITuyaActivator {
    public static final int O000000o = 1;
    public final ITuyaSmartActivatorListener O00000Oo;
    public OO0o0 O00000o;
    public final TuyaGwActivatorBuilder O00000o0;
    public final long O00000oO;
    public OOo000 O00000oo;
    public o0o00o00o0 O0000O0o = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public o0oo0o0ooo O0000OOo = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public Handler O0000Oo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            OOOo000.this.stop();
            if (OOOo000.this.O00000Oo == null) {
                return false;
            }
            OOOo000.this.O00000Oo.onError("1006", "time out");
            OOO00Oo O000000o2 = OOOo000.this.O00000o != null ? OOOo000.this.O00000o.O000000o() : null;
            if (O000000o2 != null) {
                O000000o2.O00000oO().put("type", OO0OO0o.O00000o0.O0000O0o);
                O000000o2.O00000oO().put("token", OOOo000.this.O00000o0.getToken());
                O000000o2.O00000oO().put("bssid", WiFiUtil.getBssid(TuyaSdk.getApplication()));
                if (OOOo000.this.O0000OOo != null) {
                    OOOo000.this.O0000OOo.O000000o("f22f53893cedc95aa34844b792f341ba", O000000o2.O00000oO());
                }
            }
            if (OOOo000.this.O0000Oo0 == null) {
                return false;
            }
            OOOo000.this.O0000Oo0.O00000o0(a.r("config_result", "failure"), (Map<String, Object>) null);
            return false;
        }
    });
    public OOO0OO0 O0000Oo0;

    public OOOo000(TuyaGwActivatorBuilder tuyaGwActivatorBuilder) {
        this.O00000Oo = tuyaGwActivatorBuilder.getListener();
        this.O00000o0 = tuyaGwActivatorBuilder;
        this.O00000oO = tuyaGwActivatorBuilder.getTimeOut();
        this.O00000oo = new OOo000();
        this.O0000Oo0 = new OOO0OO0();
    }

    /* access modifiers changed from: private */
    public void O000000o(final String str) {
        OO0o0 O00000Oo2 = new OO0o000().O000000o(this.O00000o0.getContext()).O000000o(this.O00000o0.getTimeOut()).O00000Oo(str).O000000o(this.O00000o0.getToken()).O000000o((IGwConfigListener) new IGwConfigListener() {
            public void onDevOnline(DeviceBean deviceBean) {
                Object key = TuyaCache.getInstance().getKey(OOOo000.this.O00000o0.getToken());
                if (OOOo000.this.O0000O0o != null) {
                    DeviceBean deviceBean2 = OOOo000.this.O0000O0o.O0000OOo().getDeviceBean(deviceBean.getDevId());
                    if (deviceBean2.getHgwBean() != null) {
                        deviceBean2.getHgwBean().setActive(ActiveEnum.ACTIVED.getType());
                    }
                }
                if (key != null) {
                    OO0OOOO.O000000o(((Long) key).longValue(), deviceBean.getDevId());
                }
                if (OOOo000.this.O00000Oo != null) {
                    OOOo000.this.O00000Oo.onActiveSuccess(deviceBean);
                    ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class)).O000000o().O000000o(str);
                }
                OOO00Oo O000000o2 = OOOo000.this.O00000o.O000000o();
                if (O000000o2 != null) {
                    O000000o2.O00000Oo(System.currentTimeMillis());
                    O000000o2.O00000o().put("type", OO0OO0o.O00000o0.O0000O0o);
                    O000000o2.O00000o().put("time", Long.valueOf((O000000o2.O00000o0() - O000000o2.O00000Oo()) / 1000));
                    if (OOOo000.this.O0000OOo != null) {
                        OOOo000.this.O0000OOo.O000000o(OO0OO0o.O000000o.O000000o, O000000o2.O00000o());
                    }
                }
                if (OOOo000.this.O0000Oo0 != null) {
                    OOOo000.this.O0000Oo0.O00000o0(a.r("config_result", "success"), (Map<String, Object>) null);
                }
            }

            public void onFind(List<DeviceBean> list) {
                for (DeviceBean next : list) {
                    if (OOOo000.this.O00000Oo != null) {
                        OOOo000.this.O00000Oo.onStep("device_find", next);
                    }
                }
            }

            public void onFindErrorList(List<ConfigErrorRespBean> list) {
                if (OOOo000.this.O00000Oo != null && list != null && list.size() > 0) {
                    OOOo000.this.O00000Oo.onError("1007", JSON.toJSONString(list));
                    if (OOOo000.this.O0000Oo0 != null) {
                        OOOo000.this.O0000Oo0.O00000o0(a.r("config_result", "success"), (Map<String, Object>) null);
                    }
                }
            }
        }).O00000Oo();
        this.O00000o = O00000Oo2;
        O00000Oo2.O000000o(this.O0000Oo0);
    }

    public void onDestroy() {
        stop();
        OO0o0 oO0o0 = this.O00000o;
        if (oO0o0 != null) {
            oO0o0.onDestroy();
        }
    }

    public void start() {
        if (this.O00000o0.getHgwBean() != null) {
            o0oo0o000o O000000o2 = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class)).O000000o();
            if (O000000o2 != null) {
                O000000o2.O000000o(this.O00000o0.getHgwBean());
            }
            if (this.O00000o == null) {
                O000000o(this.O00000o0.getHgwBean().getGwId());
            }
            this.O00000o.start();
        } else {
            this.O00000oo.registerGwSearchListener(new IGwSearchListener() {
                public void onDevFind(HgwBean hgwBean) {
                    o0oo0o000o O000000o2 = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class)).O000000o();
                    if (O000000o2 != null) {
                        O000000o2.O000000o(hgwBean);
                    }
                    if (OOOo000.this.O00000o == null) {
                        OOOo000.this.O000000o(hgwBean.getGwId());
                    }
                    OOOo000.this.O00000o.start();
                }
            });
        }
        this.O0000Oo.sendEmptyMessageDelayed(1, this.O00000oO);
        if (this.O0000OOo != null) {
            this.O0000OOo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", a.r("type", OO0OO0o.O00000o0.O0000O0o));
        }
        if (this.O0000Oo0 != null) {
            HashMap r = a.r("type", OO0OO0o.O00000o0.O0000O0o);
            r.put("token", this.O00000o0.getToken());
            this.O0000Oo0.O000000o(r, (Map<String, Object>) null);
        }
    }

    public void stop() {
        OO0o0 oO0o0 = this.O00000o;
        if (oO0o0 != null) {
            oO0o0.cancel();
        }
        this.O0000Oo.removeMessages(1);
        this.O00000oo.unRegisterGwSearchListener();
    }
}

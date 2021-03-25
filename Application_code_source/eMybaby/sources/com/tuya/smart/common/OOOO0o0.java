package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.device.utils.WiFiUtil;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.builder.TuyaCameraActivatorBuilder;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaCameraDevActivator;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaSmartCameraActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class OOOO0o0 extends BasePresenter implements o0o00ooo0o, ITuyaCameraDevActivator {
    public static final String O000000o = "TuyaCameraConfigImpl";
    public static final int O00000Oo = 1;
    public final ITuyaSmartCameraActivatorListener O00000o;
    public final String O00000o0;
    public final OOO00o O00000oO;
    public final long O00000oo;
    public final String O0000O0o;
    public final String O0000OOo;
    public OOO00Oo O0000Oo = null;
    public o0oo0o0ooo O0000Oo0 = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public Handler O0000OoO = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            OOOO0o0.this.stop();
            if (OOOO0o0.this.O00000o == null) {
                return false;
            }
            OOOO0o0.this.O00000o.onError("1006", "time out");
            if (OOOO0o0.this.O00000oO != null && (OOOO0o0.this.O00000oO instanceof OOO00o)) {
                OOOO0o0 oOOO0o0 = OOOO0o0.this;
                OOO00Oo unused = oOOO0o0.O0000Oo = oOOO0o0.O00000oO.O000000o();
            }
            if (OOOO0o0.this.O0000Oo == null) {
                return false;
            }
            OOOO0o0.this.O0000Oo.O00000oO().put("type", OO0OO0o.O00000o0.O00000oO);
            OOOO0o0.this.O0000Oo.O00000oO().put("token", OOOO0o0.this.O00000o0);
            OOOO0o0.this.O0000Oo.O00000oO().put("bssid", WiFiUtil.getBssid(TuyaSdk.getApplication()));
            if (OOOO0o0.this.O0000Oo0 == null) {
                return false;
            }
            OOOO0o0.this.O0000Oo0.O000000o("f22f53893cedc95aa34844b792f341ba", OOOO0o0.this.O0000Oo.O00000oO());
            return false;
        }
    });

    public OOOO0o0(TuyaCameraActivatorBuilder tuyaCameraActivatorBuilder) {
        this.O00000o0 = tuyaCameraActivatorBuilder.getToken();
        this.O00000oo = tuyaCameraActivatorBuilder.getTimeOut();
        this.O00000o = tuyaCameraActivatorBuilder.getListener();
        this.O0000O0o = tuyaCameraActivatorBuilder.getSsid();
        this.O0000OOo = tuyaCameraActivatorBuilder.getPassword();
        this.O00000oO = new OOO00o(TuyaSdk.getApplication(), this.O00000o0, this);
    }

    public void O000000o(GwDevResp gwDevResp) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000OOo().queryDev(gwDevResp.getGwId(), new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    if (OOOO0o0.this.O00000o != null) {
                        OOOO0o0.this.O00000o.onActiveSuccess(deviceBean);
                        if (OOOO0o0.this.O00000oO != null && (OOOO0o0.this.O00000oO instanceof OOO00o)) {
                            OOOO0o0 oOOO0o0 = OOOO0o0.this;
                            OOO00Oo unused = oOOO0o0.O0000Oo = oOOO0o0.O00000oO.O000000o();
                        }
                        if (OOOO0o0.this.O0000Oo != null) {
                            OOOO0o0.this.O0000Oo.O00000Oo(System.currentTimeMillis());
                            OOOO0o0.this.O0000Oo.O00000o().put("type", OO0OO0o.O00000o0.O00000oO);
                            OOOO0o0.this.O0000Oo.O00000o().put("time", Long.valueOf((OOOO0o0.this.O0000Oo.O00000o0() - OOOO0o0.this.O0000Oo.O00000Oo()) / 1000));
                            if (OOOO0o0.this.O0000Oo0 != null) {
                                OOOO0o0.this.O0000Oo0.O000000o(OO0OO0o.O000000o.O000000o, OOOO0o0.this.O0000Oo.O00000o());
                            }
                        }
                    }
                }

                public void onError(String str, String str2) {
                    if (OOOO0o0.this.O00000o != null) {
                        OOOO0o0.this.O00000o.onError(str, str2);
                    }
                }
            });
        }
        stop();
    }

    public void O000000o(List<GwDevResp> list) {
    }

    public void O00000Oo(List<ConfigErrorRespBean> list) {
        if (this.O00000o != null && list != null && list.size() > 0) {
            this.O00000o.onError("1007", JSON.toJSONString(list));
        }
    }

    public void createQRCode() {
        StringBuilder n = a.n("{\"p\":\"");
        n.append(this.O0000OOo);
        n.append("\",\"s\":\"");
        n.append(this.O0000O0o);
        n.append("\",\"t\":\"");
        String m = a.m(n, this.O00000o0, "\"}");
        ITuyaSmartCameraActivatorListener iTuyaSmartCameraActivatorListener = this.O00000o;
        if (iTuyaSmartCameraActivatorListener != null) {
            iTuyaSmartCameraActivatorListener.onQRCodeSuccess(m);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        L.d(O000000o, "onDestroy");
        Handler handler = this.O0000OoO;
        if (handler != null) {
            handler.removeMessages(1);
        }
        OOO00o oOO00o = this.O00000oO;
        if (oOO00o != null) {
            oOO00o.onDestroy();
        }
    }

    public void start() {
        L.d(O000000o, "start");
        this.O00000oO.O00000Oo();
        this.O0000OoO.sendEmptyMessageDelayed(1, this.O00000oo);
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", a.r("type", OO0OO0o.O00000o0.O00000oO));
        }
        OOO00o oOO00o = this.O00000oO;
        if (oOO00o != null && (oOO00o instanceof OOO00o)) {
            OOO00Oo O000000o2 = oOO00o.O000000o();
            this.O0000Oo = O000000o2;
            if (O000000o2 != null) {
                O000000o2.O000000o(System.currentTimeMillis());
            }
        }
    }

    public void stop() {
        L.d(O000000o, "stop");
        onDestroy();
    }
}

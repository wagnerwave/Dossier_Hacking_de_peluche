package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.api.IDevModel;
import com.tuya.smart.home.sdk.builder.TuyaAutoConfigActivatorBuilder;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class OOOo extends BasePresenter implements o0o00ooo0o, ITuyaActivator {
    public static final String O00000Oo = "TuyaMultiAutoConnect";
    public static final int O00000o0 = 1;
    public o0o00o00o0 O000000o = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public final ITuyaSmartActivatorListener O00000o;
    public final Context O00000oO;
    public final List<String> O00000oo;
    public final long O0000O0o;
    public final String O0000OOo;
    public o0oo0o0ooo O0000Oo = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public o0o00ooo00 O0000Oo0;
    public OOO00Oo O0000OoO = null;
    public Handler O0000Ooo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            OOOo.this.stop();
            if (OOOo.this.O00000o == null) {
                return false;
            }
            OOOo.this.O00000o.onError("1006", "time out");
            if (OOOo.this.O0000Oo0 != null && (OOOo.this.O0000Oo0 instanceof OOO00o)) {
                OOOo oOOo = OOOo.this;
                OOO00Oo unused = oOOo.O0000OoO = ((OOO00o) oOOo.O0000Oo0).O000000o();
            }
            if (OOOo.this.O0000OoO == null) {
                return false;
            }
            OOOo.this.O0000OoO.O00000oO().put("type", OO0OO0o.O00000o0.O0000Oo0);
            OOOo.this.O0000OoO.O00000oO().put("token", OOOo.this.O0000OOo);
            if (OOOo.this.O0000Oo == null) {
                return false;
            }
            OOOo.this.O0000Oo.O000000o("f22f53893cedc95aa34844b792f341ba", OOOo.this.O0000OoO.O00000oO());
            return false;
        }
    });

    public OOOo(TuyaAutoConfigActivatorBuilder tuyaAutoConfigActivatorBuilder) {
        if (tuyaAutoConfigActivatorBuilder == null || tuyaAutoConfigActivatorBuilder.getContext() == null || tuyaAutoConfigActivatorBuilder.getListener() == null || tuyaAutoConfigActivatorBuilder.getDevIds() == null || TextUtils.isEmpty(tuyaAutoConfigActivatorBuilder.getToken())) {
            throw new NullPointerException("builder cannot be null");
        }
        this.O00000o = tuyaAutoConfigActivatorBuilder.getListener();
        this.O00000oO = tuyaAutoConfigActivatorBuilder.getContext();
        this.O00000oo = tuyaAutoConfigActivatorBuilder.getDevIds();
        this.O0000O0o = tuyaAutoConfigActivatorBuilder.getTimeOut();
        this.O0000OOo = tuyaAutoConfigActivatorBuilder.getToken();
    }

    private void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            OOO00o oOO00o = new OOO00o(TuyaSdk.getApplication(), str, this);
            this.O0000Oo0 = oOO00o;
            oOO00o.O00000Oo();
            this.O0000Ooo.sendEmptyMessageDelayed(1, this.O0000O0o);
        }
    }

    public void O000000o(GwDevResp gwDevResp) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setName(gwDevResp.getName());
        deviceBean.setDevId(gwDevResp.getId());
        deviceBean.setIconUrl(gwDevResp.getIconUrl());
        ITuyaSmartActivatorListener iTuyaSmartActivatorListener = this.O00000o;
        if (iTuyaSmartActivatorListener != null) {
            iTuyaSmartActivatorListener.onActiveSuccess(deviceBean);
            o0o00ooo00 o0o00ooo00 = this.O0000Oo0;
            if (o0o00ooo00 != null && (o0o00ooo00 instanceof OOO00o)) {
                this.O0000OoO = ((OOO00o) o0o00ooo00).O000000o();
            }
            OOO00Oo oOO00Oo = this.O0000OoO;
            if (oOO00Oo != null) {
                oOO00Oo.O00000Oo(System.currentTimeMillis());
                this.O0000OoO.O00000o().put("type", OO0OO0o.O00000o0.O0000Oo0);
                this.O0000OoO.O00000o().put("time", Long.valueOf((this.O0000OoO.O00000o0() - this.O0000OoO.O00000Oo()) / 1000));
                o0oo0o0ooo o0oo0o0ooo = this.O0000Oo;
                if (o0oo0o0ooo != null) {
                    o0oo0o0ooo.O000000o(OO0OO0o.O000000o.O000000o, this.O0000OoO.O00000o());
                }
            }
        }
    }

    public void O000000o(List<GwDevResp> list) {
    }

    public void O00000Oo(List<ConfigErrorRespBean> list) {
        if (this.O00000o != null && list != null && list.size() > 0) {
            this.O00000o.onError("1007", JSON.toJSONString(list));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.O0000Ooo;
        if (handler != null) {
            handler.removeMessages(1);
        }
        o0o00ooo00 o0o00ooo00 = this.O0000Oo0;
        if (o0o00ooo00 != null) {
            o0o00ooo00.onDestroy();
        }
    }

    public void start() {
        List<String> list = this.O00000oo;
        if (list == null || list.size() == 0 || this.O000000o == null) {
            L.d("TuyaMultiAutoConnect", "no device support");
            return;
        }
        for (String next : this.O00000oo) {
            IDevModel O000000o2 = this.O000000o.O000000o(this.O00000oO, next);
            if (O000000o2 != null) {
                O000000o2.autoConfigExecute("start", next, this.O0000OOo, this.O0000O0o, new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                    }
                });
            }
        }
        O000000o(this.O0000OOo);
        if (this.O0000Oo != null) {
            this.O0000Oo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", a.r("type", OO0OO0o.O00000o0.O0000Oo0));
        }
        o0o00ooo00 o0o00ooo00 = this.O0000Oo0;
        if (o0o00ooo00 != null && (o0o00ooo00 instanceof OOO00o)) {
            OOO00Oo O000000o3 = ((OOO00o) o0o00ooo00).O000000o();
            this.O0000OoO = O000000o3;
            if (O000000o3 != null) {
                O000000o3.O000000o(System.currentTimeMillis());
            }
        }
    }

    public void stop() {
        List<String> list = this.O00000oo;
        if (list == null || list.size() == 0 || this.O000000o == null) {
            L.d("TuyaMultiAutoConnect", "no device support");
            return;
        }
        for (String next : this.O00000oo) {
            IDevModel O000000o2 = this.O000000o.O000000o(this.O00000oO, next);
            if (O000000o2 != null) {
                O000000o2.autoConfigExecute("stop", next, "", -1, new IResultCallback() {
                    public void onError(String str, String str2) {
                    }

                    public void onSuccess() {
                    }
                });
            }
        }
        onDestroy();
    }
}

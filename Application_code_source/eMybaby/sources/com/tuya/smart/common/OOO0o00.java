package com.tuya.smart.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class OOO0o00 extends BasePresenter implements o0o00ooo0o, ITuyaActivator {
    public static final String O000000o = "TuyaEZActiveConnect";
    public static final int O00000Oo = 1;
    public final long O00000o;
    public final ActivatorBuilder O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final ITuyaSmartActivatorListener O0000O0o;
    public o0o00ooo00 O0000OOo;
    public Handler O0000Oo = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            OOO0o00.this.stop();
            if (OOO0o00.this.O0000O0o == null) {
                return false;
            }
            OOO0o00.this.O0000O0o.onError("1006", "time out");
            return false;
        }
    });
    public o0o00o0o00 O0000Oo0 = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));

    public OOO0o00(ActivatorBuilder activatorBuilder) {
        this.O00000o0 = activatorBuilder;
        if (activatorBuilder == null) {
            throw new NullPointerException("builder cannot be null");
        } else if (activatorBuilder.getContext() == null) {
            throw new NullPointerException("context cannot be null");
        } else if (!TextUtils.isEmpty(this.O00000o0.getSsid())) {
            this.O0000O0o = this.O00000o0.getListener();
            this.O00000o = this.O00000o0.getTimeOut();
            this.O00000oO = this.O00000o0.getSsid();
            this.O00000oo = this.O00000o0.getPassword();
        } else {
            throw new RuntimeException("ssid cannot be empty");
        }
    }

    private void O000000o() {
        L.d(O000000o, "stopSendEC");
        o0o00o0o00 o0o00o0o00 = this.O0000Oo0;
        if (o0o00o0o00 != null) {
            o0o00o0o00.O00000o0().O000000o();
        }
        onDestroy();
    }

    /* access modifiers changed from: private */
    public void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            OOO00o oOO00o = new OOO00o(TuyaSdk.getApplication(), str, this);
            this.O0000OOo = oOO00o;
            oOO00o.O00000Oo();
            this.O0000Oo.sendEmptyMessageDelayed(1, this.O00000o);
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(String str) {
        O000000o();
        o0o00o0o00 o0o00o0o00 = this.O0000Oo0;
        if (o0o00o0o00 != null) {
            o0o00o0o00.O00000o0().O000000o(this.O00000oO, this.O00000oo, str);
        }
    }

    public void O000000o(GwDevResp gwDevResp) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setName(gwDevResp.getName());
        deviceBean.setDevId(gwDevResp.getId());
        deviceBean.setIconUrl(gwDevResp.getIconUrl());
        ITuyaSmartActivatorListener iTuyaSmartActivatorListener = this.O0000O0o;
        if (iTuyaSmartActivatorListener != null) {
            iTuyaSmartActivatorListener.onActiveSuccess(deviceBean);
        }
    }

    public void O000000o(List<GwDevResp> list) {
    }

    public void O00000Oo(List<ConfigErrorRespBean> list) {
        if (this.O0000O0o != null && list != null && list.size() > 0) {
            this.O0000O0o.onError("1007", JSON.toJSONString(list));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.O0000Oo;
        if (handler != null) {
            handler.removeMessages(1);
        }
        o0o00ooo00 o0o00ooo00 = this.O0000OOo;
        if (o0o00ooo00 != null) {
            o0o00ooo00.onDestroy();
        }
    }

    public void start() {
        new oOo00().O000000o((Business.ResultListener<ActiveTokenBean>) new Business.ResultListener<ActiveTokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                OOO0o00.this.O0000O0o.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                String str2 = TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret();
                OOO0o00.this.O00000Oo(str2);
                OOO0o00.this.O000000o(str2);
            }
        });
    }

    public void stop() {
        O000000o();
    }
}

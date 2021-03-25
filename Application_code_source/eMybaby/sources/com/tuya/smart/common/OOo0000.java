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
import com.tuya.smart.home.sdk.builder.TuyaQRCodeActivatorBuilder;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaSmartActivatorListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class OOo0000 extends BasePresenter implements o0o00ooo0o, ITuyaActivator {
    public static final String O000000o = "TuyaQRCodeConfigImpl";
    public static final int O00000Oo = 1;
    public final long O00000o;
    public final String O00000o0;
    public final ITuyaSmartActivatorListener O00000oO;
    public o0o00ooo00 O00000oo;
    public final long O0000O0o;
    public oOo00 O0000OOo;
    public Handler O0000Oo0 = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            OOo0000.this.stop();
            if (OOo0000.this.O00000oO == null) {
                return false;
            }
            OOo0000.this.O00000oO.onError("1006", "time out");
            return false;
        }
    });

    public OOo0000(TuyaQRCodeActivatorBuilder tuyaQRCodeActivatorBuilder) {
        this.O0000O0o = tuyaQRCodeActivatorBuilder.getTimeOut();
        this.O00000oO = tuyaQRCodeActivatorBuilder.getListener();
        this.O00000o0 = tuyaQRCodeActivatorBuilder.getUuid();
        this.O00000o = tuyaQRCodeActivatorBuilder.getHomeId();
        this.O0000OOo = new oOo00();
    }

    /* access modifiers changed from: private */
    public void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000oo = new OOO00o(TuyaSdk.getApplication(), str, this);
            L.d(O000000o, "start");
            this.O00000oo.O00000Oo();
            this.O0000Oo0.sendEmptyMessageDelayed(1, this.O0000O0o);
        }
    }

    public void O000000o(GwDevResp gwDevResp) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000OOo().queryDev(gwDevResp.getGwId(), new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    if (OOo0000.this.O00000oO != null) {
                        OOo0000.this.O00000oO.onActiveSuccess(deviceBean);
                    }
                }

                public void onError(String str, String str2) {
                    if (OOo0000.this.O00000oO != null) {
                        OOo0000.this.O00000oO.onError(str, str2);
                    }
                }
            });
        }
        stop();
    }

    public void O000000o(List<GwDevResp> list) {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        for (GwDevResp O000000o2 : list) {
            DeviceBean O000000o3 = o0o00o00o0.O0000OoO().O000000o(O000000o2);
            ITuyaSmartActivatorListener iTuyaSmartActivatorListener = this.O00000oO;
            if (iTuyaSmartActivatorListener != null) {
                iTuyaSmartActivatorListener.onStep("device_find", O000000o3.getDevId());
                this.O00000oO.onStep("device_bind_success", O000000o3);
            }
        }
    }

    public void O00000Oo(List<ConfigErrorRespBean> list) {
        if (this.O00000oO != null && list != null && list.size() > 0) {
            this.O00000oO.onError("1007", JSON.toJSONString(list));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        L.d(O000000o, "onDestroy");
        Handler handler = this.O0000Oo0;
        if (handler != null) {
            handler.removeMessages(1);
        }
        o0o00ooo00 o0o00ooo00 = this.O00000oo;
        if (o0o00ooo00 != null) {
            o0o00ooo00.onDestroy();
        }
        oOo00 ooo00 = this.O0000OOo;
        if (ooo00 != null) {
            ooo00.onDestroy();
        }
    }

    public void start() {
        this.O0000OOo.O000000o(this.O00000o0, this.O00000o, (Business.ResultListener<ActiveTokenBean>) new Business.ResultListener<ActiveTokenBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                OOo0000.this.O00000oO.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ActiveTokenBean activeTokenBean, String str) {
                if (activeTokenBean != null) {
                    OOo0000.this.O000000o(TuyaSmartNetWork.getRegion() + activeTokenBean.getToken() + activeTokenBean.getSecret());
                }
            }
        });
    }

    public void stop() {
        L.d(O000000o, "stop");
        onDestroy();
    }
}

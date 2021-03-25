package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.PhoneUtil;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaGetBeanCallback;
import com.tuya.smart.sdk.api.ITuyaPush;
import com.tuya.smart.sdk.bean.push.MQCompensationBean;
import com.tuya.smart.sdk.bean.push.PushStatusBean;
import com.tuya.smart.sdk.bean.push.PushType;

public class oo00oo0oo implements o0o0o00000, ITuyaPush {
    public static volatile ITuyaPush O00000Oo;
    public o0o00o00o0 O000000o = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public ITuyaGetBeanCallback<MQCompensationBean> O00000o;
    public oo00o0o0o O00000o0 = new oo00o0o0o();

    public oo00oo0oo() {
        o0o00o00o0 o0o00o00o0 = this.O000000o;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0oo00000o.class, this);
        }
    }

    public static ITuyaPush O000000o() {
        if (O00000Oo == null) {
            synchronized (oo00oo0oo.class) {
                if (O00000Oo == null) {
                    O00000Oo = new oo00oo0oo();
                }
            }
        }
        return O00000Oo;
    }

    public void getPushStatus(final ITuyaResultCallback<PushStatusBean> iTuyaResultCallback) {
        this.O00000o0.O000000o(PhoneUtil.getDeviceID(TuyaSmartNetWork.getAppContext()), (Business.ResultListener<PushStatusBean>) new Business.ResultListener<PushStatusBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, PushStatusBean pushStatusBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, PushStatusBean pushStatusBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(pushStatusBean);
                }
            }
        });
    }

    public void getPushStatusByType(PushType pushType, final ITuyaDataCallback<Boolean> iTuyaDataCallback) {
        this.O00000o0.O000000o(pushType.getValue(), (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(bool);
                }
            }
        });
    }

    public void onDestroy() {
        this.O00000o0.onDestroy();
        O00000Oo = null;
    }

    public void onResult(Object obj) {
        if (this.O00000o != null && (obj instanceof o0oo00000o)) {
            o0oo00000o o0oo00000o = (o0oo00000o) obj;
            this.O00000o.onResult(new MQCompensationBean(o0oo00000o.O000000o(), o0oo00000o.O00000Oo(), o0oo00000o.O00000o0()));
        }
    }

    public void registerDevice(String str, String str2, IResultCallback iResultCallback) {
        this.O00000o0.O000000o(str, str2, iResultCallback);
    }

    public void registerMQPushListener(ITuyaGetBeanCallback<MQCompensationBean> iTuyaGetBeanCallback) {
        this.O00000o = iTuyaGetBeanCallback;
    }

    public void setPushStatus(boolean z, final ITuyaDataCallback<Boolean> iTuyaDataCallback) {
        this.O00000o0.O000000o(PhoneUtil.getDeviceID(TuyaSmartNetWork.getAppContext()), z ? 1 : 0, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(bool);
                }
            }
        });
    }

    public void setPushStatusByType(PushType pushType, boolean z, final ITuyaDataCallback<Boolean> iTuyaDataCallback) {
        this.O00000o0.O000000o(pushType.getValue(), !z, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(bool);
                }
            }
        });
    }
}

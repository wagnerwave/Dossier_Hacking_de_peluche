package com.tuya.smart.common;

import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.sweeper.ITuyaDelHistoryCallback;
import com.tuya.smart.android.sweeper.bean.CloudConfigBean;
import com.tuya.smart.android.sweeper.bean.SweeperHistory;
import com.tuya.smart.android.sweeper.bean.SweeperPathBean;
import com.tuya.smart.common.o00o00o0oo;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.List;

public class o00o00oo00 extends BaseModel {
    public o0o00o0o0o O000000o = ((o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class));
    public o00o00o0o0 O00000Oo = new o00o00o0o0();

    public o00o00oo00() {
        super(TuyaSdk.getApplication());
    }

    public void O000000o(String str, int i, int i2, long j, long j2, ITuyaResultCallback<SweeperHistory> iTuyaResultCallback) {
        final ITuyaResultCallback<SweeperHistory> iTuyaResultCallback2 = iTuyaResultCallback;
        o0o00o0o0o o0o00o0o0o = this.O000000o;
        if (o0o00o0o0o != null) {
            String str2 = str;
            long homeIdByDevId = o0o00o0o0o.O00000o0().getHomeIdByDevId(str);
            long j3 = 0;
            if (homeIdByDevId >= 0) {
                j3 = homeIdByDevId;
            }
            this.O00000Oo.O000000o(str, j3, i, i2, j, j2, new Business.ResultListener<SweeperHistory>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, SweeperHistory sweeperHistory, String str) {
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback2;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, SweeperHistory sweeperHistory, String str) {
                    ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback2;
                    if (iTuyaResultCallback != null) {
                        iTuyaResultCallback.onSuccess(sweeperHistory);
                    }
                }
            });
        } else if (iTuyaResultCallback2 != null) {
            iTuyaResultCallback2.onError(o00o00o0oo.O000000o.O000000o, "local error");
        }
    }

    public void O000000o(String str, final ITuyaDelHistoryCallback iTuyaDelHistoryCallback) {
        this.O00000Oo.O00000Oo(str, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDelHistoryCallback iTuyaDelHistoryCallback = iTuyaDelHistoryCallback;
                if (iTuyaDelHistoryCallback != null) {
                    iTuyaDelHistoryCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDelHistoryCallback iTuyaDelHistoryCallback = iTuyaDelHistoryCallback;
                if (iTuyaDelHistoryCallback != null) {
                    iTuyaDelHistoryCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, final ITuyaResultCallback<CloudConfigBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(str, (Business.ResultListener<CloudConfigBean>) new Business.ResultListener<CloudConfigBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, CloudConfigBean cloudConfigBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, CloudConfigBean cloudConfigBean, String str) {
                ITuyaResultCallback iTuyaResultCallback = iTuyaResultCallback;
                if (iTuyaResultCallback != null) {
                    iTuyaResultCallback.onSuccess(cloudConfigBean);
                }
            }
        });
    }

    public void O000000o(String str, List<String> list, final ITuyaDelHistoryCallback iTuyaDelHistoryCallback) {
        this.O00000Oo.O000000o(str, list, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDelHistoryCallback iTuyaDelHistoryCallback = iTuyaDelHistoryCallback;
                if (iTuyaDelHistoryCallback != null) {
                    iTuyaDelHistoryCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                ITuyaDelHistoryCallback iTuyaDelHistoryCallback = iTuyaDelHistoryCallback;
                if (iTuyaDelHistoryCallback != null) {
                    iTuyaDelHistoryCallback.onSuccess();
                }
            }
        });
    }

    public void O00000Oo(String str, ITuyaResultCallback<SweeperPathBean> iTuyaResultCallback) {
        this.O00000Oo.O000000o(str, iTuyaResultCallback);
    }

    public void onDestroy() {
        this.O00000Oo.cancelAll();
    }
}

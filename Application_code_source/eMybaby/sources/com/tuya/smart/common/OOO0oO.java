package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import com.tuya.sdk.config.bean.GwBindResultBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.interior.config.bean.ConfigDevResp;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class OOO0oO extends BaseModel implements OO0OOo0 {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 4;
    public static final int O00000oo = 5;
    public static final int O0000O0o = 6;
    public static final int O0000OOo = 7;
    public static final int O0000Oo = 9;
    public static final int O0000Oo0 = 8;
    public static final int O0000OoO = 18;
    public static final int O0000Ooo = 16;
    public static final int O0000o00 = 17;
    public oOo00 O0000o0 = new oOo00();
    public OOO0OO0 O0000o0O;

    public OOO0oO(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000o0O = ooo0oo0;
        this.O0000o0.O000000o(ooo0oo0.O000000o());
    }

    public void O000000o(String str) {
        this.O0000o0.O00000o0(str, new Business.ResultListener<ConfigDevResp>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ConfigDevResp configDevResp, String str) {
                OOO0oO.this.resultError(8, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ConfigDevResp configDevResp, String str) {
                ArrayList<GwDevResp> arrayList = configDevResp.getSuccessDevices() == null ? new ArrayList<>() : configDevResp.getSuccessDevices();
                Iterator<GwDevResp> it = arrayList.iterator();
                while (it.hasNext()) {
                    GwDevResp next = it.next();
                    next.setGwId(next.getId());
                    next.setUpdateCacheTime(businessResponse.getT());
                }
                OOO0oO.this.resultSuccess(9, arrayList);
                ArrayList<ConfigErrorRespBean> errorDevices = configDevResp.getErrorDevices();
                if (errorDevices != null && errorDevices.size() > 0) {
                    OOO0oO.this.resultSuccess(18, configDevResp.getErrorDevices());
                }
            }
        });
    }

    public void O000000o(String str, Long l, final IResultCallback iResultCallback) {
        this.O0000o0.O00000Oo(str, l.longValue(), new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, String str2) {
        L.d("ECBindModel", "queryGwDevById");
        if (this.O0000o0O != null) {
            this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "get_devinfo"));
        }
        this.O0000o0.O000000o(str, str2, (Business.ResultListener<GwDevResp>) new Business.ResultListener<GwDevResp>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, GwDevResp gwDevResp, String str) {
                OOO0oO.this.resultError(0, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                if (OOO0oO.this.O0000o0O != null) {
                    OOO0oO.this.O0000o0O.O00000Oo((Map<String, Object>) null, a.r("step", "get_devinfo_failure"));
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, GwDevResp gwDevResp, String str) {
                gwDevResp.setUpdateCacheTime(businessResponse.getT());
                OOO0oO.this.resultSuccess(1, gwDevResp);
            }
        });
    }

    public void O000000o(final ArrayList<String> arrayList, String str) {
        this.O0000o0.O000000o(arrayList, str, (Business.ResultListener<ArrayList<GwBindResultBean>>) new Business.ResultListener<ArrayList<GwBindResultBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<GwBindResultBean> arrayList, String str) {
                OOO0oO.this.resultError(6, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<GwBindResultBean> arrayList, String str) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    boolean z = true;
                    Iterator<GwBindResultBean> it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().getGwId().equals(str2)) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z) {
                        arrayList2.add(str2);
                    }
                }
                OOO0oO.this.resultSuccess(7, arrayList2);
            }
        });
    }

    @Deprecated
    public void O00000Oo(String str) {
        this.O0000o0.O00000Oo(str, new Business.ResultListener<ArrayList<GwDevResp>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<GwDevResp> arrayList, String str) {
                OOO0oO.this.resultError(16, businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<GwDevResp> arrayList, String str) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                Iterator<GwDevResp> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().setUpdateCacheTime(businessResponse.getT());
                }
                OOO0oO.this.resultSuccess(17, arrayList);
            }
        });
    }

    public void onDestroy() {
        this.O0000o0.onDestroy();
    }
}

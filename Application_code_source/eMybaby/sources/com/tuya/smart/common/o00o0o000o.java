package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.timer.bean.CategoryStatusBean;
import com.tuya.sdk.timer.bean.DpTimerListBean;
import com.tuya.sdk.timer.bean.DpTimerPointBean;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.constant.TimerTypeEnum;
import com.tuya.smart.sdk.api.IGetAllTimerWithDevIdCallback;
import com.tuya.smart.sdk.api.IGetDeviceTimerStatusCallback;
import com.tuya.smart.sdk.api.IGetTimerWithTaskCallback;
import com.tuya.smart.sdk.api.IResultStatusCallback;
import com.tuya.smart.sdk.api.ITuyaTimer;
import java.util.ArrayList;
import java.util.Map;

public class o00o0o000o implements ITuyaTimer {
    public static final String O000000o = "TuyaTimerManager";
    public static volatile ITuyaTimer O00000o0;
    public o00o00oooo O00000Oo = new o00o00oooo();

    public class O000000o implements Business.ResultListener<Boolean> {
        public IResultStatusCallback O000000o;

        public O000000o(IResultStatusCallback iResultStatusCallback) {
            this.O000000o = iResultStatusCallback;
        }

        /* renamed from: O000000o */
        public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
            IResultStatusCallback iResultStatusCallback = this.O000000o;
            if (iResultStatusCallback != null) {
                iResultStatusCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }
        }

        /* renamed from: O00000Oo */
        public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
            if (this.O000000o == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.O000000o.onSuccess();
            } else {
                this.O000000o.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }
        }
    }

    private TimerTypeEnum O000000o(String str) {
        TimerTypeEnum timerTypeEnum = TimerTypeEnum.DEVICE;
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        if (o0o00o00oo == null) {
            return timerTypeEnum;
        }
        try {
            return o0o00o00oo.O000000o().O000000o(Long.valueOf(str).longValue()) != null ? TimerTypeEnum.DEVICE_GROUP : timerTypeEnum;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            o00oo0oo00.O00000Oo(O000000o, "String to Long failed");
            return timerTypeEnum;
        }
    }

    public static ITuyaTimer O000000o() {
        if (O00000o0 == null) {
            synchronized (o00o0o000o.class) {
                if (O00000o0 == null) {
                    O00000o0 = new o00o0o000o();
                }
            }
        }
        return O00000o0;
    }

    public void O000000o(String str, String str2, String str3, String str4, TimerTypeEnum timerTypeEnum, final IResultStatusCallback iResultStatusCallback) {
        this.O00000Oo.O000000o(str2, str, str3, str4, timerTypeEnum, (Business.ResultListener<JSONObject>) new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback.onSuccess();
            }
        });
    }

    public void O00000Oo() {
        o00o00oooo o00o00oooo = this.O00000Oo;
        if (o00o00oooo != null) {
            o00o00oooo.onDestroy();
        }
    }

    public void addTimerWithTask(String str, String str2, String str3, String str4, String str5, final IResultStatusCallback iResultStatusCallback) {
        String str6 = str3;
        String str7 = str;
        String str8 = str2;
        String str9 = str4;
        String str10 = str5;
        this.O00000Oo.O000000o(str6, str7, str8, str9, str10, true, O000000o(str3), new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback.onSuccess();
            }
        });
    }

    public void addTimerWithTask(String str, String str2, String str3, Map<String, Object> map, String str4, IResultStatusCallback iResultStatusCallback) {
        TimerTypeEnum O000000o2 = O000000o(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DpTimerPointBean(str4, map));
        O000000o(str, str2, str3, JSON.toJSONString(arrayList), O000000o2, iResultStatusCallback);
    }

    public void getAllTimerWithDeviceId(String str, final IGetAllTimerWithDevIdCallback iGetAllTimerWithDevIdCallback) {
        this.O00000Oo.O000000o(str, O000000o(str), new Business.ResultListener<ArrayList<DpTimerListBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<DpTimerListBean> arrayList, String str) {
                IGetAllTimerWithDevIdCallback iGetAllTimerWithDevIdCallback = iGetAllTimerWithDevIdCallback;
                if (iGetAllTimerWithDevIdCallback != null) {
                    iGetAllTimerWithDevIdCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<DpTimerListBean> arrayList, String str) {
                IGetAllTimerWithDevIdCallback iGetAllTimerWithDevIdCallback = iGetAllTimerWithDevIdCallback;
                if (iGetAllTimerWithDevIdCallback != null) {
                    iGetAllTimerWithDevIdCallback.onSuccess(o00o0o00o0.O00000Oo(arrayList));
                }
            }
        });
    }

    public void getTimerTaskStatusWithDeviceId(String str, final IGetDeviceTimerStatusCallback iGetDeviceTimerStatusCallback) {
        this.O00000Oo.O000000o(str, new Business.ResultListener<ArrayList<CategoryStatusBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<CategoryStatusBean> arrayList, String str) {
                IGetDeviceTimerStatusCallback iGetDeviceTimerStatusCallback = iGetDeviceTimerStatusCallback;
                if (iGetDeviceTimerStatusCallback != null) {
                    iGetDeviceTimerStatusCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<CategoryStatusBean> arrayList, String str) {
                IGetDeviceTimerStatusCallback iGetDeviceTimerStatusCallback = iGetDeviceTimerStatusCallback;
                if (iGetDeviceTimerStatusCallback != null) {
                    iGetDeviceTimerStatusCallback.onSuccess(o00o0o00o0.O000000o(arrayList));
                }
            }
        });
    }

    public void getTimerWithTask(String str, String str2, final IGetTimerWithTaskCallback iGetTimerWithTaskCallback) {
        this.O00000Oo.O000000o(str2, str, O000000o(str2), (Business.ResultListener<DpTimerListBean>) new Business.ResultListener<DpTimerListBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, DpTimerListBean dpTimerListBean, String str) {
                IGetTimerWithTaskCallback iGetTimerWithTaskCallback = iGetTimerWithTaskCallback;
                if (iGetTimerWithTaskCallback != null) {
                    iGetTimerWithTaskCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, DpTimerListBean dpTimerListBean, String str) {
                IGetTimerWithTaskCallback iGetTimerWithTaskCallback = iGetTimerWithTaskCallback;
                if (iGetTimerWithTaskCallback != null) {
                    iGetTimerWithTaskCallback.onSuccess(o00o0o00o0.O000000o(dpTimerListBean));
                }
            }
        });
    }

    public void removeTimerWithTask(String str, String str2, String str3, IResultStatusCallback iResultStatusCallback) {
        String str4 = str2;
        String str5 = str;
        String str6 = str3;
        this.O00000Oo.O000000o(str4, str5, str6, O000000o(str2), new O000000o(iResultStatusCallback));
    }

    public void updateTimerStatusWithTask(String str, String str2, String str3, boolean z, IResultStatusCallback iResultStatusCallback) {
        String str4 = str2;
        String str5 = str;
        String str6 = str3;
        boolean z2 = z;
        this.O00000Oo.O000000o(str4, str5, str6, z2, O000000o(str2), (Business.ResultListener<Boolean>) new O000000o(iResultStatusCallback));
    }

    public void updateTimerTaskStatusWithTask(String str, String str2, int i, IResultStatusCallback iResultStatusCallback) {
        this.O00000Oo.O000000o(str, str2, i, (Business.ResultListener<Boolean>) new O000000o(iResultStatusCallback));
    }

    public void updateTimerWithTask(String str, String str2, String str3, String str4, String str5, final IResultStatusCallback iResultStatusCallback) {
        String str6 = str3;
        String str7 = str;
        String str8 = str4;
        String str9 = str2;
        String str10 = str5;
        this.O00000Oo.O000000o(str6, str7, str8, str9, str10, O000000o(str3), new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback.onSuccess();
            }
        });
    }

    public void updateTimerWithTask(String str, String str2, String str3, String str4, String str5, String str6, boolean z, IResultStatusCallback iResultStatusCallback) {
        TimerTypeEnum O000000o2 = O000000o(str3);
        final IResultStatusCallback iResultStatusCallback2 = iResultStatusCallback;
        this.O00000Oo.O000000o(str3, str, str4, str5, str2, str6, z, O000000o2, new Business.ResultListener<JSONObject>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback2.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, JSONObject jSONObject, String str) {
                iResultStatusCallback2.onSuccess();
            }
        });
    }
}

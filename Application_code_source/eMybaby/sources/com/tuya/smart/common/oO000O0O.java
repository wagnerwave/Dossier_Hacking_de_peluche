package com.tuya.smart.common;

import android.content.Context;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.device.bean.HardwareUpgradeBean;
import com.tuya.smart.android.device.bean.UpgradeInfoBean;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.api.IGetOtaInfoCallback;
import java.util.ArrayList;

public class oO000O0O extends BaseModel {
    public final String O000000o;
    public o00 O00000Oo = new o00();

    public interface O000000o {
        void O000000o();

        void O000000o(String str, String str2);
    }

    public oO000O0O(String str, Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
        this.O000000o = str;
    }

    public void O000000o(int i, final O000000o o000000o) {
        this.O00000Oo.O000000o(this.O000000o, i, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }

    public void O000000o(Business.ResultListener<ArrayList<UpgradeInfoBean>> resultListener) {
        this.O00000Oo.O000000o(this.O000000o, resultListener);
    }

    public void O000000o(final oO000Oo0 oo000oo0) {
        o00 o00 = this.O00000Oo;
        String str = this.O000000o;
        o00.O00000oO(str, str, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                oO000Oo0 oo000oo0 = oo000oo0;
                if (oo000oo0 != null) {
                    oo000oo0.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                oO000Oo0 oo000oo0 = oo000oo0;
                if (oo000oo0 != null) {
                    oo000oo0.O000000o();
                }
            }
        });
    }

    public void O000000o(final oO000o00 oo000o00) {
        if (oO0OO000.O000000o().getDeviceBean(this.O000000o) == null) {
            oo000o00.O000000o("11002", "device is removed");
            return;
        }
        o00 o00 = this.O00000Oo;
        String str = this.O000000o;
        o00.O000000o(str, str, (Business.ResultListener<HardwareUpgradeBean>) new Business.ResultListener<HardwareUpgradeBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, HardwareUpgradeBean hardwareUpgradeBean, String str) {
                oO000o00 oo000o00 = oo000o00;
                if (oo000o00 != null) {
                    oo000o00.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, HardwareUpgradeBean hardwareUpgradeBean, String str) {
                oO000o00 oo000o00 = oo000o00;
                if (oo000o00 != null) {
                    oo000o00.O000000o(hardwareUpgradeBean);
                }
            }
        });
    }

    public void O000000o(final IGetOtaInfoCallback iGetOtaInfoCallback) {
        o00 o00 = this.O00000Oo;
        String str = this.O000000o;
        o00.O00000o0(str, str, new Business.ResultListener<UpgradeInfoBean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, UpgradeInfoBean upgradeInfoBean, String str) {
                IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                if (iGetOtaInfoCallback != null) {
                    iGetOtaInfoCallback.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, UpgradeInfoBean upgradeInfoBean, String str) {
                if (iGetOtaInfoCallback != null && upgradeInfoBean != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(upgradeInfoBean);
                    iGetOtaInfoCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void O00000Oo(final oO000Oo0 oo000oo0) {
        this.O00000Oo.O00000Oo(this.O000000o, new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                oO000Oo0 oo000oo0 = oo000oo0;
                if (oo000oo0 != null) {
                    oo000oo0.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                oO000Oo0 oo000oo0 = oo000oo0;
                if (oo000oo0 != null) {
                    oo000oo0.O000000o();
                }
            }
        });
    }

    public void onDestroy() {
        this.O00000Oo.onDestroy();
    }
}

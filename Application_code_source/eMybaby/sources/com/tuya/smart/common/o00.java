package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.device.bean.HardwareUpgradeBean;
import com.tuya.smart.android.device.bean.UpgradeInfoBean;
import com.tuya.smart.android.network.Business;
import java.util.ArrayList;

public class o00 extends Business {
    public static final String O000000o = "s.m.upgrade.info";
    public static final String O00000Oo = "s.m.upgrade.confirm";
    public static final String O00000o = "tuya.m.device.upgrade.confirm";
    public static final String O00000o0 = "tuya.m.device.upgrade.info";

    private void O00000oo(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000Oo, "2.0", true, o0ooo00oo.O00000o0, str);
        if (!TextUtils.isEmpty(str2)) {
            F.putPostData("devId", str2);
        }
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O000000o(String str, int i, Business.ResultListener<Boolean> resultListener) {
        ApiParams D = a.D(O00000o, "1.0", "devId", str);
        D.putPostData("type", Integer.valueOf(i));
        asyncRequest(D, Boolean.class, resultListener);
    }

    public void O000000o(String str, Business.ResultListener<ArrayList<UpgradeInfoBean>> resultListener) {
        asyncArrayList(a.D("tuya.m.device.upgrade.info", "1.0", "devId", str), UpgradeInfoBean.class, resultListener);
    }

    public void O000000o(String str, String str2, Business.ResultListener<HardwareUpgradeBean> resultListener) {
        ApiParams F = a.F(O000000o, "2.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("devId", str2);
        asyncRequest(F, HardwareUpgradeBean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<Boolean> resultListener) {
        O00000oo(str, (String) null, resultListener);
    }

    public void O00000Oo(String str, String str2, Business.ResultListener<ArrayList<UpgradeInfoBean>> resultListener) {
        ApiParams F = a.F(O000000o, "2.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("devId", str2);
        asyncArrayList(F, UpgradeInfoBean.class, resultListener);
    }

    public void O00000o(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        ApiParams F = a.F(O00000Oo, "1.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("devId", str2);
        asyncRequest(F, Boolean.class, resultListener);
    }

    public void O00000o0(String str, String str2, Business.ResultListener<UpgradeInfoBean> resultListener) {
        ApiParams F = a.F(O000000o, "1.0", true, o0ooo00oo.O00000o0, str);
        F.putPostData("devId", str2);
        asyncRequest(F, UpgradeInfoBean.class, resultListener);
    }

    public void O00000oO(String str, String str2, Business.ResultListener<Boolean> resultListener) {
        O00000oo(str, str2, resultListener);
    }
}

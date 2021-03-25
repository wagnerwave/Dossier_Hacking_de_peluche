package com.tuya.smart.android.base;

import android.text.TextUtils;
import com.tuya.smart.android.common.utils.PhoneUtil;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00oo0oo;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.Map;

public class ApiParams extends TuyaApiParams {
    public ApiParams(String str, String str2) {
        super(str, str2);
    }

    public ApiParams(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public String getEcode() {
        o0o00oo0oo o0o00oo0oo;
        User user;
        if (!(!TextUtils.isEmpty(super.getEcode()) || (o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class)) == null || (user = o0o00oo0oo.O000000o().getUser()) == null)) {
            setEcode(user.getEcode());
        }
        return super.getEcode();
    }

    public String getSession() {
        o0o00oo0oo o0o00oo0oo;
        User user;
        if (!(!TextUtils.isEmpty(super.getSession()) || (o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class)) == null || (user = o0o00oo0oo.O000000o().getUser()) == null)) {
            setSession(user.getSid());
        }
        return super.getSession();
    }

    public Map<String, String> getUrlParams() {
        Map<String, String> urlParams = super.getUrlParams();
        String latitude = TuyaSdk.getLatitude();
        String longitude = TuyaSdk.getLongitude();
        if (TuyaUtil.hasLatOrLon(latitude, longitude)) {
            urlParams.put(TuyaApiParams.KEY_LAT, latitude);
            urlParams.put(TuyaApiParams.KEY_LON, longitude);
        } else {
            urlParams.remove(TuyaApiParams.KEY_LAT);
            urlParams.remove(TuyaApiParams.KEY_LON);
        }
        return urlParams;
    }

    public void initUrlParams(String str) {
        this.urlGETParams.put("deviceId", PhoneUtil.getDeviceID(TuyaSmartNetWork.mAppContext));
        super.initUrlParams(str);
    }

    public void setBizDM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urlGETParams.put("bizDM", str);
        }
    }

    public void setCtId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.urlGETParams.put("ctId", str);
        }
    }
}

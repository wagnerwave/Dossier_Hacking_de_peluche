package com.tuya.smart.common;

import com.tuya.smart.home.sdk.bean.DeviceType;
import com.tuya.smart.home.sdk.bean.ShareReceivedUserDetailBean;
import com.tuya.smart.home.sdk.bean.ShareSentUserDetailBean;
import com.tuya.smart.home.sdk.bean.SharedUserInfoBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.ShareIdBean;
import java.util.List;

public interface oo00o0ooo {
    void O000000o();

    void O000000o(int i, IResultCallback iResultCallback);

    void O000000o(long j, ITuyaResultCallback<ShareSentUserDetailBean> iTuyaResultCallback);

    void O000000o(long j, IResultCallback iResultCallback);

    void O000000o(long j, String str, long j2, long j3, IResultCallback iResultCallback);

    void O000000o(long j, String str, IResultCallback iResultCallback);

    void O000000o(long j, String str, String str2, ShareIdBean shareIdBean, boolean z, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback);

    void O000000o(long j, String str, String str2, List<String> list, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback);

    void O000000o(long j, List<String> list, IResultCallback iResultCallback);

    void O000000o(long j, boolean z, IResultCallback iResultCallback);

    void O000000o(ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback);

    void O000000o(String str, long j, IResultCallback iResultCallback);

    void O000000o(String str, DeviceType deviceType, String str2, String str3, ITuyaResultCallback<Integer> iTuyaResultCallback);

    void O000000o(String str, ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback);

    void O000000o(String str, IResultCallback iResultCallback);

    void O00000Oo(long j, ITuyaResultCallback<ShareReceivedUserDetailBean> iTuyaResultCallback);

    void O00000Oo(long j, IResultCallback iResultCallback);

    void O00000Oo(long j, String str, long j2, long j3, IResultCallback iResultCallback);

    void O00000Oo(long j, String str, IResultCallback iResultCallback);

    void O00000Oo(String str, long j, IResultCallback iResultCallback);

    void O00000Oo(String str, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback);

    void O00000o(String str, long j, IResultCallback iResultCallback);

    void O00000o0(long j, ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback);

    void O00000o0(String str, long j, IResultCallback iResultCallback);
}

package com.tuya.smart.common;

import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.home.sdk.bean.MemberBean;
import com.tuya.smart.home.sdk.bean.MemberWrapperBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetMemberListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaMemberResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.io.File;
import java.util.Map;

public interface o0o0o00oo {
    void O000000o(long j, ITuyaGetMemberListCallback iTuyaGetMemberListCallback);

    void O000000o(long j, IResultCallback iResultCallback);

    void O000000o(long j, ITuyaDataCallback<Map<String, Object>> iTuyaDataCallback);

    void O000000o(long j, String str, String str2, String str3, boolean z, ITuyaMemberResultCallback iTuyaMemberResultCallback);

    void O000000o(long j, String str, String str2, boolean z, IResultCallback iResultCallback);

    void O000000o(long j, String str, boolean z, IResultCallback iResultCallback);

    void O000000o(long j, boolean z, IResultCallback iResultCallback);

    void O000000o(MemberWrapperBean memberWrapperBean, IResultCallback iResultCallback);

    void O000000o(MemberWrapperBean memberWrapperBean, ITuyaDataCallback<MemberBean> iTuyaDataCallback);

    void O000000o(String str, File file, IBooleanCallback iBooleanCallback);

    void O00000Oo(long j, boolean z, IResultCallback iResultCallback);
}

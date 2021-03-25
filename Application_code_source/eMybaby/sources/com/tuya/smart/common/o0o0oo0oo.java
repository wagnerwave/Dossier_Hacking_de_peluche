package com.tuya.smart.common;

import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.home.sdk.api.ITuyaHomeMember;
import com.tuya.smart.home.sdk.bean.MemberBean;
import com.tuya.smart.home.sdk.bean.MemberWrapperBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetMemberListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaMemberResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.io.File;
import java.util.Map;

public class o0o0oo0oo implements ITuyaHomeMember {
    public static o0o0oo0oo O000000o;
    public o0o0o00oo O00000Oo = new o0o0o0000();

    public static o0o0oo0oo O000000o() {
        if (O000000o == null) {
            O000000o = new o0o0oo0oo();
        }
        return O000000o;
    }

    public void addMember(long j, String str, String str2, String str3, boolean z, ITuyaMemberResultCallback iTuyaMemberResultCallback) {
        this.O00000Oo.O000000o(j, str, str2, str3, z, iTuyaMemberResultCallback);
    }

    public void addMember(MemberWrapperBean memberWrapperBean, ITuyaDataCallback<MemberBean> iTuyaDataCallback) {
        this.O00000Oo.O000000o(memberWrapperBean, iTuyaDataCallback);
    }

    public void addMemberAccount(long j, String str, String str2, boolean z, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, str, str2, z, iResultCallback);
    }

    public void getMemberDeviceList(long j, ITuyaDataCallback<Map<String, Object>> iTuyaDataCallback) {
        this.O00000Oo.O000000o(j, iTuyaDataCallback);
    }

    public void processInvitation(long j, boolean z, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(j, z, iResultCallback);
    }

    public void queryMemberList(long j, ITuyaGetMemberListCallback iTuyaGetMemberListCallback) {
        this.O00000Oo.O000000o(j, iTuyaGetMemberListCallback);
    }

    public void removeMember(long j, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, iResultCallback);
    }

    public void updateMember(long j, String str, boolean z, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, str, z, iResultCallback);
    }

    public void updateMember(MemberWrapperBean memberWrapperBean, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(memberWrapperBean, iResultCallback);
    }

    public void updateMemberRole(long j, boolean z, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(j, z, iResultCallback);
    }

    public void uploadMemberAvatar(String str, File file, IBooleanCallback iBooleanCallback) {
        this.O00000Oo.O000000o(str, file, iBooleanCallback);
    }
}

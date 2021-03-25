package com.tuya.smart.home.sdk.api;

import com.tuya.smart.android.user.api.IBooleanCallback;
import com.tuya.smart.home.sdk.bean.MemberBean;
import com.tuya.smart.home.sdk.bean.MemberWrapperBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetMemberListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaMemberResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import java.io.File;
import java.util.Map;

public interface ITuyaHomeMember {
    void addMember(long j, String str, String str2, String str3, boolean z, ITuyaMemberResultCallback iTuyaMemberResultCallback);

    void addMember(MemberWrapperBean memberWrapperBean, ITuyaDataCallback<MemberBean> iTuyaDataCallback);

    void addMemberAccount(long j, String str, String str2, boolean z, IResultCallback iResultCallback);

    void getMemberDeviceList(long j, ITuyaDataCallback<Map<String, Object>> iTuyaDataCallback);

    void processInvitation(long j, boolean z, IResultCallback iResultCallback);

    void queryMemberList(long j, ITuyaGetMemberListCallback iTuyaGetMemberListCallback);

    void removeMember(long j, IResultCallback iResultCallback);

    void updateMember(long j, String str, boolean z, IResultCallback iResultCallback);

    void updateMember(MemberWrapperBean memberWrapperBean, IResultCallback iResultCallback);

    void updateMemberRole(long j, boolean z, IResultCallback iResultCallback);

    void uploadMemberAvatar(String str, File file, IBooleanCallback iBooleanCallback);
}

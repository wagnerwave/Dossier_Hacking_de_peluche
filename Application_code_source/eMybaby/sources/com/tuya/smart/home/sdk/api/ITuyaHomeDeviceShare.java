package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.ShareReceivedUserDetailBean;
import com.tuya.smart.home.sdk.bean.ShareSentUserDetailBean;
import com.tuya.smart.home.sdk.bean.SharedUserInfoBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.ShareIdBean;
import java.util.List;

public interface ITuyaHomeDeviceShare {
    void addShare(long j, String str, String str2, ShareIdBean shareIdBean, boolean z, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback);

    void addShareWithHomeId(long j, String str, String str2, List<String> list, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback);

    void addShareWithMemberId(long j, List<String> list, IResultCallback iResultCallback);

    void confirmShareInviteShare(int i, IResultCallback iResultCallback);

    void disableDevShare(String str, long j, IResultCallback iResultCallback);

    @Deprecated
    void enableDevShare(String str, long j, IResultCallback iResultCallback);

    void getReceivedShareInfo(long j, ITuyaResultCallback<ShareReceivedUserDetailBean> iTuyaResultCallback);

    void getUserShareInfo(long j, ITuyaResultCallback<ShareSentUserDetailBean> iTuyaResultCallback);

    void inviteShare(String str, String str2, String str3, ITuyaResultCallback<Integer> iTuyaResultCallback);

    void onDestroy();

    void queryDevShareUserList(String str, ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback);

    void queryShareDevFromInfo(String str, ITuyaResultCallback<SharedUserInfoBean> iTuyaResultCallback);

    void queryShareReceivedUserList(ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback);

    void queryUserShareList(long j, ITuyaResultCallback<List<SharedUserInfoBean>> iTuyaResultCallback);

    void removeReceivedDevShare(String str, IResultCallback iResultCallback);

    void removeReceivedUserShare(long j, IResultCallback iResultCallback);

    void removeUserShare(long j, IResultCallback iResultCallback);

    void renameReceivedShareNickname(long j, String str, IResultCallback iResultCallback);

    void renameShareNickname(long j, String str, IResultCallback iResultCallback);
}

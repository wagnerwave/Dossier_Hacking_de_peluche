package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.MemberBean;
import java.util.List;

public interface ITuyaGetMemberListCallback {
    void onError(String str, String str2);

    void onSuccess(List<MemberBean> list);
}

package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.HomeBean;
import java.util.List;

public interface ITuyaGetHomeListCallback {
    void onError(String str, String str2);

    void onSuccess(List<HomeBean> list);
}

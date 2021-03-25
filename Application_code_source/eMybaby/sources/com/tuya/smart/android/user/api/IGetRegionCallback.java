package com.tuya.smart.android.user.api;

import com.tuya.smart.android.user.bean.Region;

public interface IGetRegionCallback {
    void onError(String str, String str2);

    void onSuccess(Region region);
}

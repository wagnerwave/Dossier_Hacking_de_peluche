package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.BlueMeshBean;

public interface IBlueMeshCreateCallback {
    void onError(String str, String str2);

    void onSuccess(BlueMeshBean blueMeshBean);
}

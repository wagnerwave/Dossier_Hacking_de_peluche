package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.SigMeshBean;

public interface ISigMeshCreateCallback {
    void onError(String str, String str2);

    void onSuccess(SigMeshBean sigMeshBean);
}

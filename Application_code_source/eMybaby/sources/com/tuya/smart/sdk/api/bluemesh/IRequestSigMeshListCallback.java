package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;

public interface IRequestSigMeshListCallback {
    void onError(String str, String str2);

    void onSuccess(ArrayList<SigMeshBean> arrayList);
}

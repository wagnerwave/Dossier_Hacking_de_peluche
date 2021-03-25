package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.ArrayList;

public interface IRequestMeshListCallback {
    void onError(String str, String str2);

    void onSuccess(ArrayList<BlueMeshBean> arrayList);
}

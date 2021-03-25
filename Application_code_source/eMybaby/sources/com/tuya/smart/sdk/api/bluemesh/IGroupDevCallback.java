package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.BlueMeshSubDevBean;
import java.util.List;

public interface IGroupDevCallback {
    void onError(String str, String str2);

    void onSuccess(List<BlueMeshSubDevBean> list);
}

package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.BlueMeshGroupBean;
import com.tuya.smart.sdk.bean.BlueMeshSubDevBean;
import java.util.List;

public interface IGetGroupAndDevListCallback {
    void onError(String str, String str2);

    void onSuccess(List<BlueMeshGroupBean> list, List<BlueMeshSubDevBean> list2);
}

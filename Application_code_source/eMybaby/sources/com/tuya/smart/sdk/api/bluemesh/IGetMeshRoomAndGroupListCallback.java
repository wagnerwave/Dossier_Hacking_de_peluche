package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.BlueMeshGroupBean;
import com.tuya.smart.sdk.bean.BlueMeshRoomBean;
import java.util.List;

public interface IGetMeshRoomAndGroupListCallback {
    void onError(String str, String str2);

    void onSuccess(List<BlueMeshRoomBean> list, List<BlueMeshGroupBean> list2);
}

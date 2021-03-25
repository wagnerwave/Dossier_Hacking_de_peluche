package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.List;
import java.util.Set;

public interface IBlueMeshManager {
    void createBlueMesh(long j, String str, IBlueMeshCreateCallback iBlueMeshCreateCallback);

    BlueMeshBean getBlueMeshBean(String str);

    List<BlueMeshBean> getBlueMeshList();

    DpsParseBean getTuyaMeshParseBean(String str, String str2);

    void onDestroy();

    String parseVenderIdFromDp(Set set, String str);

    void requestMeshList(long j, IRequestMeshListCallback iRequestMeshListCallback);

    void requestUpgradeInfo(String str, IRequestUpgradeInfoCallback iRequestUpgradeInfoCallback);

    void updateBuleMesh(List<BlueMeshBean> list);
}

package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.List;

public interface ISigMeshManager {
    void createSigMesh(long j, ISigMeshCreateCallback iSigMeshCreateCallback);

    SigMeshBean getSigMeshBean(String str);

    List<SigMeshBean> getSigMeshList();

    void onDestroy();

    void requestSigMeshList(long j, IRequestSigMeshListCallback iRequestSigMeshListCallback);

    void updateSigMesh(List<SigMeshBean> list);
}

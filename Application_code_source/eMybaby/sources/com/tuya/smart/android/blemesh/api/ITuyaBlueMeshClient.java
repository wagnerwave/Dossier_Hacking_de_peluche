package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.sdk.bean.BlueMeshBean;

public interface ITuyaBlueMeshClient {
    @Deprecated
    void destroyMesh();

    void destroyMesh(String str);

    MeshClientStatusEnum getStatus();

    void initMesh(String str);

    void initMesh(String str, boolean z);

    void startClient(BlueMeshBean blueMeshBean);

    void startClient(BlueMeshBean blueMeshBean, long j);

    void startSearch();

    void stopClient();

    void stopSearch();
}

package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.sdk.bean.SigMeshBean;

public interface ITuyaSigMeshClient {
    void destroyMesh(String str);

    MeshClientStatusEnum getStatus();

    void initMesh(String str);

    void initMesh(String str, boolean z);

    void startClient(SigMeshBean sigMeshBean);

    void startClient(SigMeshBean sigMeshBean, long j);

    void startSearch();

    void stopClient();

    void stopSearch();
}

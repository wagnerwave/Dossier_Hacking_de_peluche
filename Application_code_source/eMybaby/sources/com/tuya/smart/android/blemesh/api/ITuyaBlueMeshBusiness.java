package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.bean.BLEUpgradeBean;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;

public interface ITuyaBlueMeshBusiness<R> {
    void getMeshList(long j, BusinessResultListener<ArrayList<BlueMeshBean>, R> businessResultListener);

    void getSigMeshList(long j, BusinessResultListener<ArrayList<SigMeshBean>, R> businessResultListener);

    void meshFirmwareUpgradeCheck(String str, BusinessResultListener<ArrayList<BLEUpgradeBean>, R> businessResultListener);
}

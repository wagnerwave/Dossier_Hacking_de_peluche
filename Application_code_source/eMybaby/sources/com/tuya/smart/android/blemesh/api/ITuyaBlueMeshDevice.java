package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.IMeshDevListener;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;

public interface ITuyaBlueMeshDevice extends ITuyaBlueMesh {
    void publishDps(String str, String str2, DpsParseBean dpsParseBean, IResultCallback iResultCallback);

    void queryAllOnLineStatusByLocal(IResultCallback iResultCallback);

    void queryAllStatusByLocal(IResultCallback iResultCallback);

    void querySubDevStatusByLocal(String str, String str2, IResultCallback iResultCallback);

    void registerMeshDevListener(IMeshDevListener iMeshDevListener);

    void unRegisterMeshDevListener();
}

package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public interface ITuyaBlueMesh {
    void addGroup(String str, String str2, String str3, IAddGroupCallback iAddGroupCallback);

    void addSubDev(String str, String str2, String str3, String str4, String str5, IAddSubDevCallback iAddSubDevCallback);

    void addSubDev(String str, String str2, String str3, String str4, String str5, String str6, String str7, IAddSubDevCallback iAddSubDevCallback);

    void broadcastDps(String str, String str2, IResultCallback iResultCallback);

    void getDataByDpIds(String str, List<Integer> list, IResultCallback iResultCallback);

    DeviceBean getMeshSubDevBean(String str);

    DeviceBean getMeshSubDevBeanByMac(String str);

    DeviceBean getMeshSubDevBeanByNodeId(String str);

    List<DeviceBean> getMeshSubDevList();

    boolean isCloudOnline();

    void multicastDps(String str, String str2, String str3, IResultCallback iResultCallback);

    void onDestroy();

    void publishDps(String str, String str2, String str3, IResultCallback iResultCallback);

    void publishRawData(byte[] bArr, IResultCallback iResultCallback);

    void removeMesh(IResultCallback iResultCallback);

    void removeMeshSubDev(String str, IResultCallback iResultCallback);

    void renameMesh(String str, IResultCallback iResultCallback);

    void renameMeshSubDev(String str, String str2, IResultCallback iResultCallback);
}

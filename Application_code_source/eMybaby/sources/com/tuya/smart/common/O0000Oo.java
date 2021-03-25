package com.tuya.smart.common;

import com.tuya.smart.android.mvp.model.IModel;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddGroupCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddRoomCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshCreateCallback;
import com.tuya.smart.sdk.api.bluemesh.IGetMeshRoomAndGroupListCallback;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshCreateCallback;
import java.io.File;
import java.util.List;

public interface O0000Oo extends IModel {
    void O000000o(long j, ISigMeshCreateCallback iSigMeshCreateCallback);

    void O000000o(long j, String str, IBlueMeshCreateCallback iBlueMeshCreateCallback);

    void O000000o(String str, int i, IGetMeshRoomAndGroupListCallback iGetMeshRoomAndGroupListCallback);

    void O000000o(String str, IResultCallback iResultCallback);

    void O000000o(String str, String str2, int i, IAddRoomCallback iAddRoomCallback);

    void O000000o(String str, String str2, IResultCallback iResultCallback);

    void O000000o(String str, String str2, File file, IResultCallback iResultCallback);

    void O000000o(String str, String str2, String str3, int i, String str4, int i2, IAddGroupCallback iAddGroupCallback);

    void O000000o(String str, String str2, String str3, int i, String str4, IAddGroupCallback iAddGroupCallback);

    void O000000o(String str, String str2, String str3, IResultCallback iResultCallback);

    void O000000o(String str, String str2, String str3, String str4, int i, IResultCallback iResultCallback);

    void O000000o(String str, String str2, String str3, String str4, String str5, IAddSubDevCallback iAddSubDevCallback);

    void O000000o(String str, String str2, String str3, String str4, String str5, String str6, IAddSubDevCallback iAddSubDevCallback);

    void O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, IAddSubDevCallback iAddSubDevCallback);

    void O000000o(String str, String str2, List<Integer> list, IResultCallback iResultCallback);

    void O000000o(String str, byte[] bArr, IResultCallback iResultCallback);

    void O00000Oo(String str, String str2, IResultCallback iResultCallback);

    void O00000Oo(String str, String str2, String str3, String str4, int i, IResultCallback iResultCallback);
}

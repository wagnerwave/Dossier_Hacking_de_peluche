package com.tuya.smart.common;

import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshClient;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshConfig;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshDevice;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshGroup;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshOta;
import com.tuya.smart.android.blemesh.api.ITuyaSigMeshClient;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshOtaBuilder;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshManager;
import com.tuya.smart.sdk.api.bluemesh.IMeshStatusListener;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshManager;

public interface o0o000oooo {
    ITuyaBlueMeshDevice O000000o(String str);

    ITuyaBlueMeshGroup O000000o(long j);

    ITuyaBlueMeshGroup O000000o(String str, String str2, String str3);

    ITuyaBlueMeshOta O000000o(TuyaBlueMeshOtaBuilder tuyaBlueMeshOtaBuilder);

    IBlueMeshManager O000000o();

    ITuyaBlueMeshDevice O00000Oo(String str);

    ITuyaBlueMeshGroup O00000Oo(long j);

    ISigMeshManager O00000Oo();

    IMeshStatusListener O00000o();

    void O00000o0();

    ITuyaBlueMeshClient O00000oO();

    ITuyaSigMeshClient O00000oo();

    ITuyaBlueMeshConfig O0000O0o();
}

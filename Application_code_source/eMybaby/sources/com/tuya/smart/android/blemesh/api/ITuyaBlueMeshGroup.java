package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.callback.ILocalQueryGroupDevCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaGroup;

public interface ITuyaBlueMeshGroup extends ITuyaGroup {
    void queryDeviceInGroupByLocal(ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback);

    void queryGroupStatus(IResultCallback iResultCallback);
}

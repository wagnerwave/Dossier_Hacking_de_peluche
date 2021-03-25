package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.builder.SearchBuilder;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshActivatorBuilder;
import com.tuya.smart.android.blemesh.builder.TuyaSigMeshActivatorBuilder;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMeshActivator;

public interface ITuyaBlueMeshConfig {
    ITuyaBlueMeshActivator newActivator(TuyaBlueMeshActivatorBuilder tuyaBlueMeshActivatorBuilder);

    ITuyaBlueMeshActivator newSigActivator(TuyaSigMeshActivatorBuilder tuyaSigMeshActivatorBuilder);

    ITuyaBlueMeshSearch newTuyaBlueMeshSearch(SearchBuilder searchBuilder);

    ITuyaBlueMeshActivator newWifiActivator(TuyaBlueMeshActivatorBuilder tuyaBlueMeshActivatorBuilder);
}

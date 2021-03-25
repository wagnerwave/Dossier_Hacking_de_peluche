package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.builder.ActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaAutoConfigActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaCameraActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaGwSubDevActivatorBuilder;
import com.tuya.smart.home.sdk.builder.TuyaQRCodeActivatorBuilder;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.api.ITuyaActivatorCreateToken;
import com.tuya.smart.sdk.api.ITuyaActivatorGetToken;
import com.tuya.smart.sdk.api.ITuyaCameraDevActivator;

public interface ITuyaDeviceActivator {
    void getActivatorToken(long j, ITuyaActivatorGetToken iTuyaActivatorGetToken);

    void getActivatorToken(long j, String str, ITuyaActivatorGetToken iTuyaActivatorGetToken);

    void getActivatorToken(ITuyaActivatorCreateToken iTuyaActivatorCreateToken);

    void getMeshToken(long j, String str, ITuyaActivatorGetToken iTuyaActivatorGetToken);

    ITuyaActivator newActivator(ActivatorBuilder activatorBuilder);

    ITuyaActivator newAutoConfigDevActivator(TuyaAutoConfigActivatorBuilder tuyaAutoConfigActivatorBuilder);

    ITuyaCameraDevActivator newCameraDevActivator(TuyaCameraActivatorBuilder tuyaCameraActivatorBuilder);

    ITuyaActivator newEZWifiConfigDevActivator(ActivatorBuilder activatorBuilder);

    ITuyaActivator newGatewayRouterDevActivator(TuyaAutoConfigActivatorBuilder tuyaAutoConfigActivatorBuilder);

    ITuyaActivator newGwActivator(TuyaGwActivatorBuilder tuyaGwActivatorBuilder);

    ITuyaActivator newGwSubDevActivator(TuyaGwSubDevActivatorBuilder tuyaGwSubDevActivatorBuilder);

    ITuyaActivator newMultiActivator(ActivatorBuilder activatorBuilder);

    ITuyaActivator newQRCodeDevActivator(TuyaQRCodeActivatorBuilder tuyaQRCodeActivatorBuilder);

    ITuyaGwActivator newTuyaGwActivator();
}

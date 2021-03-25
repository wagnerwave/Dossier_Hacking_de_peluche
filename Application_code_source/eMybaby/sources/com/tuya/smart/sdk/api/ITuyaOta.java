package com.tuya.smart.sdk.api;

public interface ITuyaOta {
    void getOtaInfo(IGetOtaInfoCallback iGetOtaInfoCallback);

    void onDestroy();

    void setOtaListener(IOtaListener iOtaListener);

    void startOta();
}

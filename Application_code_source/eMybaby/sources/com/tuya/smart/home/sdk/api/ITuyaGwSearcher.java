package com.tuya.smart.home.sdk.api;

public interface ITuyaGwSearcher {
    void registerGwSearchListener(IGwSearchListener iGwSearchListener);

    void unRegisterGwSearchListener();
}

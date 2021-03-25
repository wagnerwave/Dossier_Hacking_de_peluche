package com.tuya.smart.sdk.api;

public interface ITuyaActivator {
    void onDestroy();

    void start();

    void stop();
}

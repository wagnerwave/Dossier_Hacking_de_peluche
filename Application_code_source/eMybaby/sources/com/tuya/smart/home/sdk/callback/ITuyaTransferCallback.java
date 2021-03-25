package com.tuya.smart.home.sdk.callback;

public interface ITuyaTransferCallback {
    void onConnectError(String str, String str2);

    void onConnectSuccess();
}

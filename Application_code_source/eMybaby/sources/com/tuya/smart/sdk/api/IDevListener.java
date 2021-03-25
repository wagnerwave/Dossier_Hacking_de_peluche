package com.tuya.smart.sdk.api;

public interface IDevListener {
    void onDevInfoUpdate(String str);

    void onDpUpdate(String str, String str2);

    void onNetworkStatusChanged(String str, boolean z);

    void onRemoved(String str);

    void onStatusChanged(String str, boolean z);
}

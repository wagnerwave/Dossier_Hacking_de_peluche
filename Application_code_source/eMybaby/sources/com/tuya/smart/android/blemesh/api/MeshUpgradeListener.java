package com.tuya.smart.android.blemesh.api;

public interface MeshUpgradeListener {
    void onFail(String str, String str2);

    void onSendSuccess();

    void onUpgrade(int i);

    void onUpgradeSuccess();
}

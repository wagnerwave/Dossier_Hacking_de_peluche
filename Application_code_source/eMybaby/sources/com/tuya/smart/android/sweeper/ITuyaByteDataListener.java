package com.tuya.smart.android.sweeper;

public interface ITuyaByteDataListener {
    void onFailure(int i, String str);

    void onSweeperByteData(byte[] bArr);
}

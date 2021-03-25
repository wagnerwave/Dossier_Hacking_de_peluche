package com.tuya.smart.sdk.api.bluemesh;

import java.util.List;

public interface IMeshDevListener {
    void onDevInfoUpdate(String str);

    void onDpUpdate(String str, String str2, boolean z);

    void onNetworkStatusChanged(String str, boolean z);

    void onRawDataUpdate(byte[] bArr);

    void onRemoved(String str);

    void onStatusChanged(List<String> list, List<String> list2, String str);
}

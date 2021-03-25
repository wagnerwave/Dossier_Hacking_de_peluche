package com.tuya.smart.android.blemesh.callback;

import java.util.List;

public interface ILocalQueryGroupDevCallback {
    void onError(String str, String str2);

    void onSuccess(List<String> list);
}

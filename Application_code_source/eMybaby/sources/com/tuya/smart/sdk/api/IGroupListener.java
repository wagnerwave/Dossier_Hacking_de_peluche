package com.tuya.smart.sdk.api;

public interface IGroupListener {
    void onDpUpdate(long j, String str);

    void onGroupInfoUpdate(long j);

    void onGroupRemoved(long j);
}

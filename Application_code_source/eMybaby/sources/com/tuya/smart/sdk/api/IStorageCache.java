package com.tuya.smart.sdk.api;

public interface IStorageCache {
    Object getKey();

    long getResptime();

    void setResptime(long j);
}

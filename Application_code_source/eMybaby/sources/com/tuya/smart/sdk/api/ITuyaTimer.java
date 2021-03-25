package com.tuya.smart.sdk.api;

import java.util.Map;

public interface ITuyaTimer {
    @Deprecated
    void addTimerWithTask(String str, String str2, String str3, String str4, String str5, IResultStatusCallback iResultStatusCallback);

    void addTimerWithTask(String str, String str2, String str3, Map<String, Object> map, String str4, IResultStatusCallback iResultStatusCallback);

    void getAllTimerWithDeviceId(String str, IGetAllTimerWithDevIdCallback iGetAllTimerWithDevIdCallback);

    void getTimerTaskStatusWithDeviceId(String str, IGetDeviceTimerStatusCallback iGetDeviceTimerStatusCallback);

    void getTimerWithTask(String str, String str2, IGetTimerWithTaskCallback iGetTimerWithTaskCallback);

    void removeTimerWithTask(String str, String str2, String str3, IResultStatusCallback iResultStatusCallback);

    void updateTimerStatusWithTask(String str, String str2, String str3, boolean z, IResultStatusCallback iResultStatusCallback);

    void updateTimerTaskStatusWithTask(String str, String str2, int i, IResultStatusCallback iResultStatusCallback);

    void updateTimerWithTask(String str, String str2, String str3, String str4, String str5, IResultStatusCallback iResultStatusCallback);

    void updateTimerWithTask(String str, String str2, String str3, String str4, String str5, String str6, boolean z, IResultStatusCallback iResultStatusCallback);
}

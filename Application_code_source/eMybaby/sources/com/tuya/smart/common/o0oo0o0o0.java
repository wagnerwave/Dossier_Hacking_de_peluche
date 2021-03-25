package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.mqtt.MqttTraceHandler;

public class o0oo0o0o0 implements MqttTraceHandler {
    public void traceDebug(String str, String str2) {
        L.i(str, str2);
    }

    public void traceError(String str, String str2) {
        L.e(str, str2);
    }

    public void traceException(String str, String str2, Exception exc) {
        StringBuilder p = a.p(str2, ": ");
        p.append(exc.getMessage());
        L.e(str, p.toString());
    }
}

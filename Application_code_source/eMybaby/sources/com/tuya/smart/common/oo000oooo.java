package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.mqtt.MqttServiceConstants;

public class oo000oooo {
    public static String O000000o(Context context, String str) {
        String str2;
        String str3 = "";
        String lowerCase = str == null ? str3 : str.toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || (!lowerCase.contains("javax.net.ssl.sslhandshakeexception") && !lowerCase.contains("java.security.cert.certpathvalidatorexception") && !lowerCase.contains("com.android.org.bouncycastle.jce.exception.extcertpathvalidatorexception"))) {
            String string = TuyaUtil.getString(context, "ty_network_error", "Network error, please retry.");
            if (!NetworkUtil.isNetworkAvailable(context)) {
                return string;
            }
            if (lowerCase.equals("timeout")) {
                str3 = "50408";
            } else if (lowerCase.startsWith("unable to resolve host")) {
                str3 = "50504";
            } else if (lowerCase.startsWith("read timed out")) {
                str3 = "50503";
            } else if (lowerCase.startsWith("failed to connect to")) {
                str3 = "50505";
            } else if (lowerCase.startsWith("no route to host")) {
                str3 = "50506";
            } else if (lowerCase.startsWith("connect timed out")) {
                str3 = "50507";
            } else if (lowerCase.startsWith("ssl handshake timed out")) {
                str3 = "50508";
            } else if (lowerCase.startsWith("connection closed by peer")) {
                str3 = "50509";
            } else if (lowerCase.startsWith("stream was reset: protocol_error")) {
                str3 = "50510";
            } else if (lowerCase.startsWith("canceled")) {
                str3 = "50511";
            } else if (lowerCase.startsWith("502")) {
                str3 = "50512";
            } else if (lowerCase.startsWith("503")) {
                str3 = "50513";
            } else if (lowerCase.startsWith("json error")) {
                str3 = "50514";
            }
            str2 = string;
        } else {
            str2 = TuyaUtil.getString(context, "ty_time_error", "Local clock is not accurate,please repair in time");
            str3 = "50502";
        }
        String l = a.l(str2, " ", str3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MqttServiceConstants.TRACE_ERROR, (Object) lowerCase);
        L.logServer("network_error", jSONObject);
        return l;
    }
}

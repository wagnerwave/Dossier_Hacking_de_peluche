package com.tuya.smart.mqtt;

import com.tuya.smart.android.common.utils.MD5Util;
import e.b.a.a.a.w.b;

public class TuyaMqttFilePersistence extends b {
    public TuyaMqttFilePersistence(String str) {
        super(str);
    }

    public void open(String str, String str2) {
        super.open(MD5Util.md5AsBase64(str), str2);
    }
}

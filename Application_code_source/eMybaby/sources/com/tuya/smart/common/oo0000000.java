package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.smart.android.common.utils.ByteUtils;
import com.tuya.smart.android.common.utils.L;

public class oo0000000 extends o0ooooooo {
    public static final String O0000Oo = "mqtt_1_1";

    public oo0000000(o0oooo0o0 o0oooo0o0) {
        super(o0oooo0o0);
    }

    public void O000000o(o0ooo0oo0 o0ooo0oo0) {
        byte[] jSONBytes = JSON.toJSONBytes(o0ooo0o00.O000000o(this.O0000O0o, this.O00000oO, this.O00000Oo), new SerializerFeature[0]);
        if (jSONBytes == null) {
            L.e(O0000Oo, "control bytes == null");
            if (o0ooo0oo0 != null) {
                o0ooo0oo0.O000000o("dp error", "dataBytes==null");
                return;
            }
            return;
        }
        byte[] contact = ByteUtils.contact(this.O00000o0.getBytes(), o0ooo00oo.O000000o(this.O0000Oo0, this.O0000OOo, jSONBytes, this.O00000o), ByteUtils.intToBytes2(this.O0000Oo0), ByteUtils.intToBytes2(this.O0000OOo), jSONBytes);
        if (o0ooo0oo0 != null) {
            o0ooo0oo0.O000000o(contact);
        }
    }
}

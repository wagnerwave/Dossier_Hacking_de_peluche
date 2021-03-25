package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.mqttprotocol.bean.PublishBean;

public class oo000000o extends o0ooooooo {
    public oo000000o(o0oooo0o0 o0oooo0o0) {
        super(o0oooo0o0);
    }

    public void O000000o(o0ooo0oo0 o0ooo0oo0) {
        PublishBean O000000o = o0ooo0o00.O000000o(o0ooo0o00.O000000o(this.O000000o, this.O0000O0o, this.O00000o0, this.O00000oO, JSON.toJSONString(this.O00000Oo, SerializerFeature.WriteMapNullValue)), this.O00000o);
        O000000o.setSign(o0ooo00oo.O000000o(O000000o, this.O00000o));
        if (o0ooo0oo0 != null) {
            o0ooo0oo0.O000000o(JSON.toJSONString(O000000o).getBytes());
        }
    }
}

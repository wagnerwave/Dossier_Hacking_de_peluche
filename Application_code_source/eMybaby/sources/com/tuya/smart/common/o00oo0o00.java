package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.sdk.hardwareprotocol.bean.HRequest;

public abstract class o00oo0o00 {
    public static final String O0000OOo = "LocalControl";
    public final Object O000000o;
    public final String O00000Oo;
    public String O00000o;
    public final String O00000o0;
    public int O00000oO;
    public int O00000oo;
    public int O0000O0o;

    public o00oo0o00(o00o0ooo0 o00o0ooo0) {
        this.O00000oO = o00o0ooo0.O000000o();
        this.O00000o = o00o0ooo0.O00000Oo();
        this.O000000o = o00o0ooo0.O00000o0();
        this.O00000Oo = o00o0ooo0.O00000oO();
        this.O00000o0 = o00o0ooo0.O00000o();
        this.O00000oo = o00o0ooo0.O0000O0o();
        this.O0000O0o = o00o0ooo0.O00000oo();
    }

    public HRequest O000000o() {
        HRequest hRequest = new HRequest();
        hRequest.setDevId(this.O00000o);
        hRequest.setType(this.O00000oO);
        hRequest.setData(JSON.toJSONString(this.O000000o, SerializerFeature.WriteMapNullValue).getBytes());
        return hRequest;
    }

    public abstract void O000000o(o00o0o0o0<HRequest> o00o0o0o0);
}

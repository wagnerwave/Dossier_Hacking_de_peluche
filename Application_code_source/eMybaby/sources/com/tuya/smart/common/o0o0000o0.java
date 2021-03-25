package com.tuya.smart.common;

import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.home.sdk.api.IHomeCacheManager;
import com.tuya.smart.home.sdk.api.ITuyaHome;
import com.tuya.smart.home.sdk.api.ITuyaHomeManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeMember;
import com.tuya.smart.home.sdk.api.ITuyaRoom;

public class o0o0000o0 implements o0o00o0o0o {
    public static final String O000000o = "TuyaHomePlugin";

    public ITuyaHome O000000o(long j) {
        return new o0o0oo00o(j);
    }

    public ITuyaHomeManager O000000o() {
        return o0o0oo0o0.O000000o();
    }

    public ITuyaHomeMember O00000Oo() {
        return o0o0oo0oo.O000000o();
    }

    public ITuyaRoom O00000Oo(long j) {
        return new o0o0ooo00(j);
    }

    public o0oo0o0oo0 O00000o() {
        return o0o0o0oo0.O000000o();
    }

    public IHomeCacheManager O00000o0() {
        return TuyaHomeRelationCacheManager.O000000o();
    }

    public o0oo0o0o0o O00000oO() {
        return o0o00o00o.O000000o();
    }

    public void O00000oo() {
        try {
            o0o0oo0o0.O000000o().onDestroy();
            o0o00o000.O000000o().O00000o0();
            o0o00o0o0.O000000o().O00000o0();
            o0o0ooo0o.O00000Oo().O00000o();
        } catch (Exception e2) {
            L.e(O000000o, e2.getMessage());
            e2.printStackTrace();
        }
    }
}

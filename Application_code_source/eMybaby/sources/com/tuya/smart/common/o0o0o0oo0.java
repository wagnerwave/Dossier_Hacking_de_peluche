package com.tuya.smart.common;

import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.interior.device.bean.GroupRespBean;

public class o0o0o0oo0 implements o0oo0o0oo0 {
    public static final o0oo0o0oo0 O000000o = new o0o0o0oo0();

    public static o0oo0o0oo0 O000000o() {
        return O000000o;
    }

    public void O000000o(String str, GroupRespBean groupRespBean) {
        o0o00o00oo o0o00o00oo = (o0o00o00oo) Oo0.O000000o(o0o00o00oo.class);
        if (o0o00o00oo != null) {
            o0o00o00oo.O000000o().O00000Oo(groupRespBean);
        }
        TuyaHomeRelationCacheManager.O000000o().addGroupToHome(TuyaHomeRelationCacheManager.O000000o().getHomeIdByMeshId(str), groupRespBean.getId());
        TuyaHomeRelationCacheManager.O000000o().addGroupToMesh(str, groupRespBean.getId());
    }
}

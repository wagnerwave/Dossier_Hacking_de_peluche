package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class oO0O0Oo0 {
    public static final String O000000o = "Device";

    public static Map<String, Object> O000000o(GroupRespBean groupRespBean, Map<String, Object> map) {
        Map dps = groupRespBean.getDps();
        if (dps == null) {
            dps = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            dps.put(next.getKey(), next.getValue());
        }
        return map;
    }

    public static Map<String, Object> O000000o(String str, Map<String, Object> map) {
        if (oO00O0o0.O000000o().O00000o0(str) == null) {
            return null;
        }
        Map dps = oOo0oooO.O000000o().getDps(str);
        if (dps == null) {
            dps = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            dps.put(next.getKey(), next.getValue());
        }
        return map;
    }

    public static void O000000o(String str) {
        o0O0O00O.O000000o(str, str);
    }

    public static void O000000o(String str, String str2, String str3, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str3, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        boolean O00000o0 = oOO0OO0O.O00000o0(str, linkedHashMap);
        if (!oOO0OO0O.O00000Oo(str, (Map<String, Object>) linkedHashMap)) {
            L.d(O000000o, "checkReceiveCommond error");
            return;
        }
        Map<String, Object> O000000o2 = O000000o(str, (Map<String, Object>) linkedHashMap);
        if (O000000o2 != null && O000000o2.size() > 0) {
            L.d(O000000o, "Cloud: " + z + " dps: " + str3);
            if (O00000o0) {
                str3 = JSON.toJSONString(O000000o2);
            }
            O000000o(str, str3, z);
        }
    }

    public static void O000000o(String str, String str2, boolean z) {
        o0O0O00O.O000000o(str, str2, z);
    }
}

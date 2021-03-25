package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.device.bean.SchemaBean;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class o0000000o0 {
    public static final String O000000o = "01";
    public static final String O00000Oo = "02";
    public static final String O00000o = "02";
    public static final String O00000o0 = "01";
    public static final String O00000oO = "SigMeshDpParserFactory";

    public static o000000000 O000000o(o000o0ooo0 o000o0ooo0) {
        return o000o0ooo0 instanceof o000o00ooo ? new o000000o00() : new o00000000o();
    }

    public static o000000000 O000000o(String str) {
        return !TextUtils.equals(O00000o0(str), "01") ? new o000000o00() : TextUtils.equals(O00000Oo(str), "01") ? new o00000000o() : TextUtils.equals(O00000Oo(str), "02") ? new ooooooooo() : new o00000000o();
    }

    public static String O000000o(Map<String, SchemaBean> map, String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        HashMap hashMap = new HashMap();
        for (String str2 : linkedHashMap.keySet()) {
            if (map.containsKey(str2)) {
                hashMap.put(map.get(str2).getCode(), linkedHashMap.get(str2));
            } else {
                L.e(O00000oO, "dpKey:" + str2 + "   not found dpCode");
            }
        }
        return new JSONObject((Map<String, Object>) hashMap).toJSONString();
    }

    public static String O00000Oo(String str) {
        String O000000o2 = OO00o00.O000000o(str);
        if (TextUtils.isEmpty(O000000o2) || O000000o2.length() != 4) {
            return "";
        }
        StringBuilder n = a.n(oOO0O0O0.O0000oO0);
        n.append(O000000o2.substring(0, 1));
        return n.toString();
    }

    public static String O00000Oo(Map<String, SchemaBean> map, String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        HashMap hashMap = new HashMap();
        for (String str2 : linkedHashMap.keySet()) {
            String O00000o02 = O00000o0(map, str2);
            if (!TextUtils.isEmpty(O00000o02)) {
                hashMap.put(O00000o02, linkedHashMap.get(str2));
            } else {
                L.e(O00000oO, "dpCode:" + str2 + "   not found dp");
            }
        }
        return new JSONObject((Map<String, Object>) hashMap).toJSONString();
    }

    public static String O00000o0(String str) {
        String O000000o2 = OO00o00.O000000o(str);
        if (TextUtils.isEmpty(O000000o2) || O000000o2.length() != 4) {
            return "";
        }
        StringBuilder n = a.n(oOO0O0O0.O0000oO0);
        n.append(O000000o2.substring(2, 3));
        return n.toString();
    }

    public static String O00000o0(Map<String, SchemaBean> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (TextUtils.equals(((SchemaBean) next.getValue()).getCode(), str)) {
                return (String) next.getKey();
            }
        }
        return "";
    }
}

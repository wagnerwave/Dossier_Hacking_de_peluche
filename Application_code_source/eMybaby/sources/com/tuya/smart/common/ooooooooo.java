package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.smart.android.device.bean.SchemaBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ooooooooo extends o0000000oo {
    public static final String O000000o = "switch_1";
    public static final String O00000Oo = "switch_2";
    public static final String O00000o = "switch_4";
    public static final String O00000o0 = "switch_3";
    public static final String O00000oO = "switch_5";
    public static final String O00000oo = "TuyaSigMeshParser";

    private List<ooo0o0o00> O00000Oo(String str, Map<String, SchemaBean> map, boolean z) {
        String O000000o2 = o0000000o0.O000000o(map, str);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(O000000o2, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            String str2 = (String) entry.getKey();
            if (!TextUtils.equals(str2, O000000o) && !TextUtils.equals(str2, O00000Oo) && !TextUtils.equals(str2, O00000o0) && !TextUtils.equals(str2, O00000o) && !TextUtils.equals(str2, O00000oO)) {
                ooo0o0o00 O000000o3 = O000000o(str2, entry.getValue(), map, z);
                if (O000000o3 == null) {
                    o00oo0oo00.O00000Oo("TuyaSigMeshParser", str2 + "  schemaBean is null skip");
                } else {
                    arrayList.add(O000000o3);
                }
            }
        }
        return arrayList;
    }

    public ooo0o0o00 O000000o(int i) {
        oo0ooooo0 oo0ooooo0 = new oo0ooooo0();
        oo0ooooo0.O000000o(i);
        return oo0ooooo0;
    }

    public String O000000o(String str, o000o0ooo0 o000o0ooo0) {
        String O000000o2 = super.O000000o(str, o000o0ooo0);
        return !TextUtils.isEmpty(O000000o2) ? O000000o2 : "";
    }

    public List<ooo0o0o00> O000000o() {
        List<ooo0o0o00> O000000o2 = super.O000000o();
        O000000o2.add(O000000o(1));
        O000000o2.add(O000000o(2));
        O000000o2.add(O000000o(3));
        O000000o2.add(O000000o(4));
        return O000000o2;
    }

    public List<ooo0o0o00> O000000o(String str, Map<String, SchemaBean> map, boolean z) {
        List<ooo0o0o00> O000000o2 = super.O000000o(str, map, z);
        O000000o2.addAll(O00000Oo(str, map, z));
        return O000000o2;
    }
}

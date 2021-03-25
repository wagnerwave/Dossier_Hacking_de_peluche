package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.sdk.sigmesh.bean.DpCommandBean;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class o000000o00 extends o0000000oo {
    public static final String O000000o = "VendorSigParser";

    private List<ooo0o0o00> O00000Oo(String str, Map<String, SchemaBean> map, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            String str2 = (String) entry.getKey();
            SchemaBean schemaBean = map.get(str2);
            if (schemaBean == null) {
                o00oo0oo00.O00000Oo(O000000o, str2 + "  schemaBean is null skip");
            } else if (entry.getValue() != null) {
                DpCommandBean O000000o2 = O000000o(str2, entry.getValue(), schemaBean);
                if (O000000o2 != null) {
                    arrayList2.add(O000000o2);
                }
            } else {
                arrayList3.add(str2);
                arrayList3.add(OO000o0.O00000o);
                arrayList3.add("1");
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add(O000000o((List<DpCommandBean>) arrayList2, z));
        }
        if (arrayList3.size() > 0) {
            arrayList.add(O000000o((List<String>) arrayList3));
        }
        return arrayList;
    }

    public String O000000o(String str, o000o0ooo0 o000o0ooo0) {
        SchemaBean schemaBean;
        Class cls = o0o00o00o0.class;
        HashMap hashMap = new HashMap();
        String format = String.format("%04x", new Object[]{Integer.valueOf(o000o0ooo0.O0000oOO() & 65528)});
        DeviceBean subDeviceBeanByNodeId = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getSubDeviceBeanByNodeId(str, format);
        if (o000o0ooo0 instanceof o000o00ooo) {
            Iterator<DpCommandBean> it = ((o000o00ooo) o000o0ooo0).C_().iterator();
            while (it.hasNext()) {
                DpCommandBean next = it.next();
                Object dpValue = next.getDpValue();
                if (TextUtils.equals(next.getDpType(), "enum") && subDeviceBeanByNodeId != null && (schemaBean = subDeviceBeanByNodeId.getSchemaMap().get(next.getDpId())) != null) {
                    JSONArray jSONArray = JSON.parseObject(schemaBean.getProperty()).getJSONArray("range");
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.size()) {
                            break;
                        } else if (((Integer) next.getDpValue()).intValue() == i) {
                            dpValue = jSONArray.getString(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                hashMap.put(next.getDpId(), dpValue);
            }
        }
        if (hashMap.size() == 0) {
            return "";
        }
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getSubDevRespBean(str, format);
        String jSONString = JSON.toJSONString(hashMap);
        if (subDevRespBean != null) {
            subDevRespBean.getDps().putAll((LinkedHashMap) JSON.parseObject(jSONString, new TypeReference<LinkedHashMap<String, Object>>() {
            }, new Feature[0]));
        }
        return jSONString;
    }

    public List<ooo0o0o00> O000000o() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(oOO0O0O0.O0000oO0);
        arrayList2.add(new ooo0ooo0o(arrayList));
        return arrayList2;
    }

    public List<ooo0o0o00> O000000o(String str, Map<String, SchemaBean> map, boolean z) {
        return O00000Oo(str, map, z);
    }
}

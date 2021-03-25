package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.sdk.sigmesh.bean.DpCommandBean;
import com.tuya.smart.android.device.bean.BitmapSchemaBean;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.enums.DataTypeEnum;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class o0000000oo implements o000000000 {
    public static final String O000000o = "TuyaSigMeshParser";
    public static final String O0000Oo = "switch";
    public static final Map<String, String> O0000OoO = new HashMap();
    public static final Map<String, Integer> O0000Ooo = new HashMap();

    static {
        O0000OoO.put(o00000000o.O000000o, O0000Oo);
        O0000OoO.put(ooooooooo.O000000o, O0000Oo);
        O0000OoO.put(ooooooooo.O00000Oo, O0000Oo);
        O0000OoO.put(ooooooooo.O00000o0, O0000Oo);
        O0000OoO.put(ooooooooo.O00000o, O0000Oo);
        O0000OoO.put(ooooooooo.O00000oO, O0000Oo);
        O0000Ooo.put(o00000000o.O000000o, 0);
        O0000Ooo.put(ooooooooo.O000000o, 0);
        O0000Ooo.put(ooooooooo.O00000Oo, 1);
        O0000Ooo.put(ooooooooo.O00000o0, 2);
        O0000Ooo.put(ooooooooo.O00000o, 3);
        O0000Ooo.put(ooooooooo.O00000oO, 4);
    }

    private String O000000o(String str, DeviceBean deviceBean, int i) {
        List<String> O000000o2 = O000000o(str);
        if (deviceBean == null) {
            return O000000o2.size() > 0 ? O000000o2.get(0) : "";
        }
        Map<String, SchemaBean> schemaMap = deviceBean.getSchemaMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : schemaMap.entrySet()) {
            for (String next2 : O000000o2) {
                if (TextUtils.equals(((SchemaBean) next.getValue()).getCode(), next2)) {
                    arrayList.add(next2);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (O0000Ooo.containsKey(str2) && O0000Ooo.get(str2).intValue() == i) {
                a.v("found dpCode:", str2, "TuyaSigMeshParser");
                return str2;
            }
        }
        return "";
    }

    private List<String> O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : O0000OoO.entrySet()) {
            if (TextUtils.equals((CharSequence) next.getValue(), str)) {
                arrayList.add(next.getKey());
            }
        }
        return arrayList;
    }

    public DpCommandBean O000000o(String str, Object obj, SchemaBean schemaBean) {
        DpCommandBean dpCommandBean = new DpCommandBean();
        dpCommandBean.setDpId(str);
        dpCommandBean.setDpValue(obj);
        if (schemaBean.getType().equals(DataTypeEnum.OBJ.getType())) {
            dpCommandBean.setDpType(schemaBean.getSchemaType());
            if (TextUtils.equals(schemaBean.getSchemaType(), "enum")) {
                JSONArray jSONArray = JSON.parseObject(schemaBean.getProperty()).getJSONArray("range");
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArray.size()) {
                        break;
                    } else if (TextUtils.equals(jSONArray.getString(i2), (String) obj)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                dpCommandBean.setDpValue(Integer.valueOf(i));
            } else if (TextUtils.equals(schemaBean.getSchemaType(), BitmapSchemaBean.type)) {
                return null;
            }
        } else {
            dpCommandBean.setDpType(schemaBean.getType());
        }
        return dpCommandBean;
    }

    public ooo0o0o00 O000000o(String str, Object obj, Map<String, SchemaBean> map, boolean z) {
        String str2;
        SchemaBean schemaBean;
        Iterator<Map.Entry<String, SchemaBean>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = "";
                schemaBean = null;
                break;
            }
            Map.Entry next = it.next();
            if (TextUtils.equals(((SchemaBean) next.getValue()).getCode(), str)) {
                str2 = (String) next.getKey();
                schemaBean = (SchemaBean) next.getValue();
                break;
            }
        }
        if (TextUtils.isEmpty(str2) || schemaBean == null) {
            return null;
        }
        if (obj == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            return O000000o((List<String>) arrayList);
        }
        DpCommandBean O000000o2 = O000000o(str2, obj, schemaBean);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(O000000o2);
        return O000000o((List<DpCommandBean>) arrayList2, z);
    }

    public ooo0o0o00 O000000o(List<String> list) {
        return new ooo0ooo0o(list);
    }

    public ooo0o0o00 O000000o(List<DpCommandBean> list, boolean z) {
        return z ? new ooo0oooo0(list) : new ooo0ooooo(list);
    }

    public ooo0o0o00 O000000o(boolean z, boolean z2, int i) {
        oo0oooo0o oo0oooooo = z2 ? new oo0oooooo(z, oo0o0oooo.O000000o().O0000OOo()) : new ooo000000(z, oo0o0oooo.O000000o().O0000OOo());
        oo0oooooo.O000000o(i);
        return oo0oooooo;
    }

    public String O000000o(String str, o000o0ooo0 o000o0ooo0) {
        String str2;
        HashMap hashMap = new HashMap();
        if (o000o0ooo0 instanceof o0000o00o0) {
            o0000o00o0 o0000o00o0 = (o0000o00o0) o000o0ooo0;
            int O0000oOO = o0000o00o0.O0000oOO();
            int i = 65528 & O0000oOO;
            int i2 = O0000oOO - i;
            str2 = String.format("%04x", new Object[]{Integer.valueOf(i)});
            hashMap.put(O000000o(O0000Oo, ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDeviceBeanByNodeId(str, str2), i2), o0000o00o0.r_() != null ? o0000o00o0.r_() : Boolean.valueOf(o0000o00o0.q_()));
        } else {
            str2 = "";
        }
        return hashMap.size() == 0 ? "" : O000000o(JSON.toJSONString(hashMap), str, str2);
    }

    public String O000000o(String str, String str2, String str3) {
        Class cls = o0o00o00o0.class;
        DeviceRespBean subDevRespBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getSubDevRespBean(str2, str3);
        DeviceBean subDeviceBeanByNodeId = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getSubDeviceBeanByNodeId(str2, str3);
        if (subDeviceBeanByNodeId != null) {
            str = o0000000o0.O00000Oo(subDeviceBeanByNodeId.getSchemaMap(), str);
        }
        if (subDevRespBean != null) {
            subDevRespBean.getDps().putAll((LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
            }, new Feature[0]));
        }
        return str;
    }

    public List<ooo0o0o00> O000000o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(O00000oO());
        return arrayList;
    }

    public List<ooo0o0o00> O000000o(String str, Map<String, SchemaBean> map, boolean z) {
        String O000000o2 = o0000000o0.O000000o(map, str);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(O000000o2, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(O0000OoO.get(str2), O0000Oo)) {
                arrayList.add(O000000o(((Boolean) entry.getValue()).booleanValue(), z, O0000Ooo.containsKey(str2) ? O0000Ooo.get(str2).intValue() : 0));
            }
        }
        return arrayList;
    }

    public List<ooo0o0o00> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(O00000oO());
        return arrayList;
    }

    public ooo0o0o00 O00000oO() {
        return new oo0ooooo0();
    }
}

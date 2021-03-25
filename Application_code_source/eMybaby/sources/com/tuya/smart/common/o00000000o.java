package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.bean.ValueSchemaBean;
import com.tuya.smart.android.device.enums.DataTypeEnum;
import com.tuya.smart.home.sdk.utils.SchemaMapper;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class o00000000o extends o0000000oo {
    public static final String O000000o = "switch_led";
    public static final String O00000Oo = "bright_value";
    public static final String O00000o = "work_mode";
    public static final String O00000o0 = "temp_value";
    public static final String O00000oO = "colour_data";
    public static final String O00000oo = "white";
    public static final String O0000O0o = "colour";
    public static final String O0000OOo = "scene";
    public static final String O0000Oo0 = "music";
    public static final String O0000o00 = "LightSigParser";

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r4 = O000000o(O00000Oo, r4.getSchemaMap());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int O000000o(int r3, com.tuya.smart.sdk.bean.DeviceBean r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x003f
            java.util.Map r4 = r4.getSchemaMap()
            java.lang.String r0 = "bright_value"
            com.tuya.smart.android.device.bean.SchemaBean r4 = r2.O000000o((java.lang.String) r0, (java.util.Map<java.lang.String, com.tuya.smart.android.device.bean.SchemaBean>) r4)
            if (r4 == 0) goto L_0x003f
            java.lang.String r0 = r4.getType()
            com.tuya.smart.android.device.enums.DataTypeEnum r1 = com.tuya.smart.android.device.enums.DataTypeEnum.OBJ
            java.lang.String r1 = r1.getType()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r4.getSchemaType()
            java.lang.String r1 = "value"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x003f
            java.lang.String r4 = r4.getProperty()
            com.tuya.smart.android.device.bean.ValueSchemaBean r4 = com.tuya.smart.home.sdk.utils.SchemaMapper.toValueSchema(r4)
            float r3 = (float) r3
            r0 = 1199570688(0x477fff00, float:65535.0)
            float r3 = r3 / r0
            int r4 = r4.getMax()
            float r4 = (float) r4
            float r3 = r3 * r4
            int r3 = (int) r3
        L_0x003f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o00000000o.O000000o(int, com.tuya.smart.sdk.bean.DeviceBean):int");
    }

    private SchemaBean O000000o(String str, Map<String, SchemaBean> map) {
        SchemaBean schemaBean = null;
        for (Map.Entry next : map.entrySet()) {
            if (TextUtils.equals(str, ((SchemaBean) next.getValue()).getCode())) {
                schemaBean = (SchemaBean) next.getValue();
            }
        }
        return schemaBean;
    }

    private ooo0o0o00 O000000o(Object obj, Map<String, SchemaBean> map, boolean z) {
        SchemaBean O000000o2 = O000000o(O00000Oo, map);
        if (O000000o2 == null || !O000000o2.getType().equals(DataTypeEnum.OBJ.getType()) || !TextUtils.equals(O000000o2.getSchemaType(), "value")) {
            return null;
        }
        double intValue = (double) ((Integer) obj).intValue();
        double max = (double) SchemaMapper.toValueSchema(O000000o2.getProperty()).getMax();
        Double.isNaN(intValue);
        Double.isNaN(max);
        int ceil = (int) Math.ceil((((intValue / max) * 100.0d) * 65535.0d) / 100.0d);
        if (ceil <= 0) {
            ceil = 1;
        }
        if (ceil >= 65535) {
            ceil = 65535;
        }
        return z ? new ooo00o000(ceil, oo0o0oooo.O000000o().O0000OOo()) : new ooo00o00o(ceil, oo0o0oooo.O000000o().O0000OOo());
    }

    private String O000000o(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : O0000Oo0 : O0000OOo : "colour" : "white";
    }

    private String O000000o(int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        double d2 = (double) (((float) i) / 65535.0f);
        double d3 = (double) (((float) i2) / 65535.0f);
        double d4 = (double) (((float) i3) / 65535.0f);
        Double.isNaN(d4);
        double d5 = d4 * 2.0d;
        double d6 = d5 <= 1.0d ? d5 : 2.0d - d5;
        Double.isNaN(d3);
        double d7 = d3 * d6;
        double d8 = d5 + d7;
        Double.isNaN(d2);
        stringBuffer.append(String.format("%04x", new Object[]{Integer.valueOf((int) (d2 * 360.0d))}));
        stringBuffer.append(String.format("%04x", new Object[]{Integer.valueOf((int) (((d7 * 2.0d) / d8) * 1000.0d))}));
        stringBuffer.append(String.format("%04x", new Object[]{Integer.valueOf((int) ((d8 / 2.0d) * 1000.0d))}));
        return stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r4 = O000000o(O00000o0, r4.getSchemaMap());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int O00000Oo(int r3, com.tuya.smart.sdk.bean.DeviceBean r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0040
            java.util.Map r4 = r4.getSchemaMap()
            java.lang.String r0 = "temp_value"
            com.tuya.smart.android.device.bean.SchemaBean r4 = r2.O000000o((java.lang.String) r0, (java.util.Map<java.lang.String, com.tuya.smart.android.device.bean.SchemaBean>) r4)
            if (r4 == 0) goto L_0x0040
            java.lang.String r0 = r4.getType()
            com.tuya.smart.android.device.enums.DataTypeEnum r1 = com.tuya.smart.android.device.enums.DataTypeEnum.OBJ
            java.lang.String r1 = r1.getType()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = r4.getSchemaType()
            java.lang.String r1 = "value"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x0040
            java.lang.String r4 = r4.getProperty()
            com.tuya.smart.android.device.bean.ValueSchemaBean r4 = com.tuya.smart.home.sdk.utils.SchemaMapper.toValueSchema(r4)
            int r3 = r3 + -800
            float r3 = (float) r3
            r0 = 1184235520(0x46960000, float:19200.0)
            float r3 = r3 / r0
            int r4 = r4.getMax()
            float r4 = (float) r4
            float r3 = r3 * r4
            int r3 = (int) r3
        L_0x0040:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o00000000o.O00000Oo(int, com.tuya.smart.sdk.bean.DeviceBean):int");
    }

    private ooo0o0o00 O00000Oo(Object obj, Map<String, SchemaBean> map, boolean z) {
        SchemaBean O000000o2 = O000000o(O00000o0, map);
        if (O000000o2 == null || !O000000o2.getType().equals(DataTypeEnum.OBJ.getType()) || !TextUtils.equals(O000000o2.getSchemaType(), "value")) {
            return null;
        }
        int intValue = ((Integer) obj).intValue();
        ValueSchemaBean valueSchema = SchemaMapper.toValueSchema(O000000o2.getProperty());
        double min = (double) (intValue - valueSchema.getMin());
        double max = (double) (valueSchema.getMax() - valueSchema.getMin());
        Double.isNaN(min);
        Double.isNaN(max);
        int i = AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SETSTREAMCTRL_REQ;
        int ceil = ((int) Math.ceil((((min / max) * 100.0d) * 19200.0d) / 100.0d)) + AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SETSTREAMCTRL_REQ;
        if (ceil >= 800) {
            i = ceil;
        }
        if (i > 20000) {
            i = 20000;
        }
        return z ? new ooo0000o0(i, 0, oo0o0oooo.O000000o().O0000OOo()) : new ooo0000oo(i, 0, oo0o0oooo.O000000o().O0000OOo());
    }

    private List<ooo0o0o00> O00000Oo(String str, Map<String, SchemaBean> map, boolean z) {
        ooo0o0o00 O000000o2;
        String O000000o3 = o0000000o0.O000000o(map, str);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) JSON.parseObject(O000000o3, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0])).entrySet()) {
            String str2 = (String) entry.getKey();
            if (TextUtils.equals(str2, O00000Oo)) {
                O000000o2 = O000000o((Object) Integer.valueOf(((Integer) entry.getValue()).intValue()), map, z);
                if (O000000o2 == null) {
                }
            } else if (TextUtils.equals(str2, O00000o0)) {
                O000000o2 = O00000Oo((Object) Integer.valueOf(((Integer) entry.getValue()).intValue()), map, z);
                if (O000000o2 == null) {
                }
            } else if (TextUtils.equals(str2, O00000o)) {
                O000000o2 = O00000o0((String) entry.getValue(), map, z);
                if (O000000o2 == null) {
                }
            } else if (TextUtils.equals(str2, O00000oO)) {
                O000000o2 = O00000o((String) entry.getValue(), map, z);
                if (O000000o2 == null) {
                }
            } else if (!TextUtils.equals(str2, O000000o)) {
                O000000o2 = O000000o(str2, entry.getValue(), map, z);
                if (O000000o2 == null) {
                    o00oo0oo00.O00000Oo(O0000o00, str2 + "  schemaBean is null skip");
                }
            }
            arrayList.add(O000000o2);
        }
        return arrayList;
    }

    private ooo0o0o00 O00000o(String str, Map<String, SchemaBean> map, boolean z) {
        if (str.length() != 12) {
            o00oo0oo00.O00000Oo(O0000o00, "hsv value is not format " + str);
            return null;
        }
        int i = 0;
        int parseInt = Integer.parseInt(str.substring(0, 4), 16);
        int parseInt2 = Integer.parseInt(str.substring(4, 8), 16);
        int parseInt3 = Integer.parseInt(str.substring(8, 12), 16);
        double d2 = (double) parseInt;
        Double.isNaN(d2);
        double d3 = d2 / 360.0d;
        double d4 = (double) parseInt2;
        Double.isNaN(d4);
        double d5 = d4 / 1000.0d;
        double d6 = (double) parseInt3;
        Double.isNaN(d6);
        double d7 = d6 / 1000.0d;
        double d8 = (2.0d - d5) * d7;
        double d9 = (d5 * d7) / (d8 <= 1.0d ? d8 : 2.0d - d8);
        double d10 = d8 / 2.0d;
        int ceil = (int) Math.ceil(((d3 * 100.0d) * 65535.0d) / 100.0d);
        if (ceil < 0) {
            ceil = 0;
        }
        int i2 = 65535;
        if (ceil > 65535) {
            ceil = 65535;
        }
        int ceil2 = (int) Math.ceil(((d9 * 100.0d) * 65535.0d) / 100.0d);
        if (ceil2 >= 0) {
            i = ceil2;
        }
        if (i > 65535) {
            i = 65535;
        }
        int ceil3 = (int) Math.ceil(((d10 * 100.0d) * 65535.0d) / 100.0d);
        if (ceil3 <= 0) {
            ceil3 = 1;
        }
        if (ceil3 <= 65535) {
            i2 = ceil3;
        }
        return z ? new ooo000o0o(i2, ceil, i, oo0o0oooo.O000000o().O0000OOo()) : new ooo000oo0(i2, ceil, i, oo0o0oooo.O000000o().O0000OOo());
    }

    private ooo0o0o00 O00000o0(String str, Map<String, SchemaBean> map, boolean z) {
        ooo00o0oo ooo00o0oo;
        SchemaBean O000000o2 = O000000o(O00000o, map);
        if (O000000o2 == null || !O000000o2.getType().equals(DataTypeEnum.OBJ.getType()) || !TextUtils.equals(O000000o2.getSchemaType(), "enum")) {
            return null;
        }
        int i = -1;
        if (TextUtils.equals("white", str)) {
            i = 0;
        } else if (TextUtils.equals("colour", str)) {
            i = 1;
        } else if (TextUtils.equals(O0000OOo, str)) {
            i = 2;
        } else if (TextUtils.equals(O0000Oo0, str)) {
            i = 3;
        }
        if (z) {
            return ooo00o0oo;
        }
        ooo00o0oo = new ooo00o0oo(i);
        return ooo00o0oo;
    }

    public String O000000o(String str, o000o0ooo0 o000o0ooo0) {
        String O000000o2;
        String str2;
        Integer valueOf;
        String O000000o3 = super.O000000o(str, o000o0ooo0);
        if (!TextUtils.isEmpty(O000000o3)) {
            return O000000o3;
        }
        HashMap hashMap = new HashMap();
        String format = String.format("%04x", new Object[]{Integer.valueOf(o000o0ooo0.O0000oOO() & 65528)});
        DeviceBean subDeviceBeanByNodeId = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDeviceBeanByNodeId(str, format);
        if (o000o0ooo0 instanceof o000o00000) {
            o000o00000 o000o00000 = (o000o00000) o000o0ooo0;
            hashMap.put(O00000Oo, Integer.valueOf(O000000o(o000o00000.z_() != null ? o000o00000.z_().intValue() : o000o00000.y_(), subDeviceBeanByNodeId)));
        } else {
            if (o000o0ooo0 instanceof o0000oooo0) {
                o0000oooo0 o0000oooo0 = (o0000oooo0) o000o0ooo0;
                valueOf = Integer.valueOf(O00000Oo(o0000oooo0.v_() != null ? o0000oooo0.v_().intValue() : o0000oooo0.u_(), subDeviceBeanByNodeId));
            } else if (o000o0ooo0 instanceof o0000ooo0o) {
                o0000ooo0o o0000ooo0o = (o0000ooo0o) o000o0ooo0;
                int O00000Oo2 = O00000Oo(o0000ooo0o.O00000oo() != null ? o0000ooo0o.O00000oo().intValue() : o0000ooo0o.O00000oO(), subDeviceBeanByNodeId);
                hashMap.put(O00000Oo, Integer.valueOf(O000000o(o0000ooo0o.t_() != null ? o0000ooo0o.t_().intValue() : o0000ooo0o.s_(), subDeviceBeanByNodeId)));
                valueOf = Integer.valueOf(O00000Oo2);
            } else {
                if (o000o0ooo0 instanceof o0000ooooo) {
                    o0000ooooo o0000ooooo = (o0000ooooo) o000o0ooo0;
                    O000000o2 = O000000o(o0000ooooo.O00000oO(), o0000ooooo.x_(), o0000ooooo.w_());
                    str2 = O00000oO;
                } else if (o000o0ooo0 instanceof o000o0000o) {
                    O000000o2 = O000000o(((o000o0000o) o000o0ooo0).A_());
                    str2 = O00000o;
                }
                hashMap.put(str2, O000000o2);
            }
            hashMap.put(O00000o0, valueOf);
        }
        return hashMap.isEmpty() ? "" : O000000o(JSON.toJSONString(hashMap), str, format);
    }

    public List<ooo0o0o00> O000000o() {
        List<ooo0o0o00> O000000o2 = super.O000000o();
        O000000o2.add(O00000o());
        O000000o2.add(new ooo00o0o0());
        O000000o2.add(new ooo000o00());
        return O000000o2;
    }

    public List<ooo0o0o00> O000000o(String str, Map<String, SchemaBean> map, boolean z) {
        List<ooo0o0o00> O000000o2 = super.O000000o(str, map, z);
        O000000o2.addAll(O00000Oo(str, map, z));
        return O000000o2;
    }

    public ooo0o0o00 O00000o() {
        return new ooo00000o();
    }

    public ooo0o0o00 O00000o0() {
        return new ooo000ooo();
    }
}

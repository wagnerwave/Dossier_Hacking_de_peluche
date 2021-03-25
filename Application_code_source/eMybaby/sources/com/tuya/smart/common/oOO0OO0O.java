package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.Base64;
import com.tuya.smart.android.common.utils.HexUtil;
import com.tuya.smart.android.device.bean.BitmapSchemaBean;
import com.tuya.smart.android.device.bean.EnumSchemaBean;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import com.tuya.smart.android.device.bean.ValueSchemaBean;
import com.tuya.smart.android.device.enums.DataTypeEnum;
import com.tuya.smart.android.device.enums.ModeEnum;
import com.tuya.smart.home.sdk.utils.SchemaMapper;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.LinkedHashMap;
import java.util.Map;

public class oOO0OO0O {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.getSchemaInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String O000000o(java.lang.String r1, java.lang.String r2, java.util.LinkedHashMap<java.lang.String, java.lang.Object> r3) {
        /*
            com.tuya.smart.common.oO0O00Oo r0 = com.tuya.smart.common.oO0O00Oo.O000000o()
            com.tuya.smart.sdk.bean.ProductBean r1 = r0.O000000o((java.lang.String) r1)
            if (r1 == 0) goto L_0x0019
            com.tuya.smart.sdk.bean.ProductBean$SchemaInfo r1 = r1.getSchemaInfo()
            if (r1 == 0) goto L_0x0019
            java.util.Map r1 = r1.getSchemaMap()
            java.lang.String r1 = O000000o((java.util.Map<java.lang.String, com.tuya.smart.android.device.bean.SchemaBean>) r1, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r3)
            return r1
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oOO0OO0O.O000000o(java.lang.String, java.lang.String, java.util.LinkedHashMap):java.lang.String");
    }

    public static String O000000o(String str, String str2, Map<String, Object> map) {
        return O000000o(oOo0oooO.O000000o().getSchema(str), str2, map);
    }

    public static String O000000o(Map<String, SchemaBean> map, String str, Map<String, Object> map2) {
        if (map == null) {
            return str;
        }
        boolean z = false;
        for (Map.Entry next : map2.entrySet()) {
            SchemaBean schemaBean = map.get(next.getKey());
            if (schemaBean != null && schemaBean.getType().equals(DataTypeEnum.RAW.getType())) {
                z = true;
                try {
                    next.setValue(new String(Base64.encodeBase64(HexUtil.hexStringToBytes((String) next.getValue()))));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return z ? JSON.toJSONString(map2) : str;
    }

    public static boolean O000000o(String str, LinkedHashMap<String, Object> linkedHashMap) {
        ProductBean.SchemaInfo schemaInfo;
        ProductBean O000000o = oO0O00Oo.O000000o().O000000o(str);
        if (O000000o == null || (schemaInfo = O000000o.getSchemaInfo()) == null) {
            return false;
        }
        return O000000o(schemaInfo.getSchemaMap(), (Map<String, Object>) linkedHashMap);
    }

    public static boolean O000000o(String str, Map<String, Object> map) {
        return O000000o(oOo0oooO.O000000o().getSchema(str), map);
    }

    public static boolean O000000o(Map<String, SchemaBean> map, Map<String, Object> map2) {
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map2.entrySet()) {
            Object value = next.getValue();
            SchemaBean schemaBean = map.get(next.getKey());
            if (schemaBean != null) {
                if (TextUtils.equals(schemaBean.getMode(), ModeEnum.RO.getType())) {
                    return false;
                }
                if (schemaBean.getType().equals(DataTypeEnum.OBJ.getType())) {
                    String schemaType = schemaBean.getSchemaType();
                    if (TextUtils.equals(schemaType, "bool")) {
                        if (!(value instanceof Boolean)) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, "enum")) {
                        String str = (String) value;
                        EnumSchemaBean enumSchema = SchemaMapper.toEnumSchema(schemaBean.getProperty());
                        if (enumSchema == null || enumSchema.getRange() == null || !enumSchema.getRange().contains(str)) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, StringSchemaBean.type)) {
                        if (((String) value).length() > SchemaMapper.toStringSchema(schemaBean.getProperty()).getMaxlen()) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, "value")) {
                        int intValue = ((Integer) value).intValue();
                        ValueSchemaBean valueSchema = SchemaMapper.toValueSchema(schemaBean.getProperty());
                        if (intValue < valueSchema.getMin() || intValue > valueSchema.getMax()) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, BitmapSchemaBean.type)) {
                        BitmapSchemaBean bitmapSchema = SchemaMapper.toBitmapSchema(schemaBean.getProperty());
                        int intValue2 = ((Integer) value).intValue();
                        if (intValue2 < 0 && intValue2 >= (1 << bitmapSchema.getMaxlen())) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    String str2 = (String) value;
                    if (schemaBean.getType().equals(DataTypeEnum.RAW.getType())) {
                        if (!HexUtil.checkHexString(str2) || str2.length() % 2 == 1) {
                            return false;
                        }
                    } else if (TextUtils.isEmpty(str2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean O00000Oo(String str, Map<String, Object> map) {
        Map<String, SchemaBean> schema = oOo0oooO.O000000o().getSchema(str);
        if (schema == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            SchemaBean schemaBean = schema.get(next.getKey());
            if (schemaBean != null) {
                if (schemaBean.getType().equals(DataTypeEnum.OBJ.getType())) {
                    String schemaType = schemaBean.getSchemaType();
                    if (TextUtils.equals(schemaType, "bool")) {
                        if (!(value instanceof Boolean)) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, "enum")) {
                        String str2 = (String) value;
                        EnumSchemaBean enumSchema = SchemaMapper.toEnumSchema(schemaBean.getProperty());
                        if (enumSchema == null || enumSchema.getRange() == null || !enumSchema.getRange().contains(str2)) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, StringSchemaBean.type)) {
                        if (((String) value).length() > SchemaMapper.toStringSchema(schemaBean.getProperty()).getMaxlen()) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, "value")) {
                        int intValue = ((Integer) value).intValue();
                        ValueSchemaBean valueSchema = SchemaMapper.toValueSchema(schemaBean.getProperty());
                        if (intValue < valueSchema.getMin() || intValue > valueSchema.getMax()) {
                            return false;
                        }
                    } else if (TextUtils.equals(schemaType, BitmapSchemaBean.type)) {
                        BitmapSchemaBean bitmapSchema = SchemaMapper.toBitmapSchema(schemaBean.getProperty());
                        int intValue2 = ((Integer) value).intValue();
                        if (intValue2 < 0 && intValue2 >= (1 << bitmapSchema.getMaxlen())) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    String str3 = (String) value;
                    if (schemaBean.getType().equals(DataTypeEnum.RAW.getType())) {
                        if (!HexUtil.checkHexString(str3) || str3.length() % 2 == 1) {
                            return false;
                        }
                    } else if (TextUtils.isEmpty(str3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean O00000Oo(Map<String, Object> map, Map<String, SchemaBean> map2) {
        boolean z = false;
        if (map2 == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            SchemaBean schemaBean = map2.get(next.getKey());
            if (schemaBean != null && schemaBean.getType().equals(DataTypeEnum.RAW.getType())) {
                z = true;
                try {
                    next.setValue(HexUtil.bytesToHexString(Base64.decodeBase64(((String) next.getValue()).getBytes())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return z;
    }

    public static void O00000o(String str, Map<String, Object> map) {
        ProductBean.SchemaInfo schemaInfo = oO0O00Oo.O000000o().O000000o(str).getSchemaInfo();
        if (schemaInfo != null) {
            O00000Oo(map, schemaInfo.getSchemaMap());
        }
    }

    public static boolean O00000o0(String str, Map<String, Object> map) {
        return O00000Oo(map, oOo0oooO.O000000o().getSchema(str));
    }
}

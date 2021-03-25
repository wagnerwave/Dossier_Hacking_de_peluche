package com.tuya.smart.home.sdk.utils;

import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.device.bean.BitmapSchemaBean;
import com.tuya.smart.android.device.bean.BoolSchemaBean;
import com.tuya.smart.android.device.bean.EnumSchemaBean;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import com.tuya.smart.android.device.bean.ValueSchemaBean;

public class SchemaMapper {
    public static BitmapSchemaBean toBitmapSchema(String str) {
        return (BitmapSchemaBean) JSON.parseObject(str, BitmapSchemaBean.class);
    }

    public static BoolSchemaBean toBoolSchema(String str) {
        return (BoolSchemaBean) JSON.parseObject(str, BoolSchemaBean.class);
    }

    public static EnumSchemaBean toEnumSchema(String str) {
        return (EnumSchemaBean) JSON.parseObject(str, EnumSchemaBean.class);
    }

    public static StringSchemaBean toStringSchema(String str) {
        return (StringSchemaBean) JSON.parseObject(str, StringSchemaBean.class);
    }

    public static ValueSchemaBean toValueSchema(String str) {
        return (ValueSchemaBean) JSON.parseObject(str, ValueSchemaBean.class);
    }
}

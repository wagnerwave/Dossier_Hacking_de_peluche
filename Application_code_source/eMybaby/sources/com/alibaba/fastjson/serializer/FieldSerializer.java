package com.alibaba.fastjson.serializer;

import a.a.a.a.a;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Member;
import java.util.Collection;
import okhttp3.HttpUrl;

public final class FieldSerializer implements Comparable<FieldSerializer> {
    public final int features;
    public final FieldInfo fieldInfo;
    public final String format;
    public char[] name_chars;
    public RuntimeSerializerInfo runtimeInfo;
    public final boolean writeNull;

    public static class RuntimeSerializerInfo {
        public ObjectSerializer fieldSerializer;
        public Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(FieldInfo fieldInfo2) {
        boolean z;
        this.fieldInfo = fieldInfo2;
        JSONField annotation = fieldInfo2.getAnnotation();
        String str = null;
        if (annotation != null) {
            z = false;
            for (SerializerFeature serializerFeature : annotation.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    z = true;
                }
            }
            String trim = annotation.format().trim();
            str = trim.length() != 0 ? trim : str;
            this.features = SerializerFeature.of(annotation.serialzeFeatures());
        } else {
            this.features = 0;
            z = false;
        }
        this.writeNull = z;
        this.format = str;
        String str2 = fieldInfo2.name;
        int length = str2.length();
        this.name_chars = new char[(length + 3)];
        str2.getChars(0, str2.length(), this.name_chars, 1);
        char[] cArr = this.name_chars;
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
    }

    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    public Object getPropertyValue(Object obj) {
        try {
            return this.fieldInfo.get(obj);
        } catch (Exception e2) {
            FieldInfo fieldInfo2 = this.fieldInfo;
            Member member = fieldInfo2.method;
            if (member == null) {
                member = fieldInfo2.field;
            }
            throw new JSONException(a.k("get property error。 ", member.getDeclaringClass().getName() + "." + member.getName()), e2);
        }
    }

    public void writePrefix(JSONSerializer jSONSerializer) {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i = serializeWriter.features;
        if ((SerializerFeature.QuoteFieldNames.mask & i) == 0 || (i & SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeFieldName(this.fieldInfo.name, true);
            return;
        }
        char[] cArr = this.name_chars;
        serializeWriter.write(cArr, 0, cArr.length);
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) {
        String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            Class<?> cls = obj == null ? this.fieldInfo.fieldClass : obj.getClass();
            this.runtimeInfo = new RuntimeSerializerInfo(jSONSerializer.config.get(cls), cls);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == runtimeSerializerInfo.runtimeFieldClass) {
                ObjectSerializer objectSerializer = runtimeSerializerInfo.fieldSerializer;
                FieldInfo fieldInfo2 = this.fieldInfo;
                objectSerializer.write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType);
                return;
            }
            ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls2);
            FieldInfo fieldInfo3 = this.fieldInfo;
            objectSerializer2.write(jSONSerializer, obj, fieldInfo3.name, fieldInfo3.fieldType);
        } else if ((this.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0 && Number.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
            jSONSerializer.out.write(48);
        } else if ((this.features & SerializerFeature.WriteNullBooleanAsFalse.mask) != 0 && Boolean.class == runtimeSerializerInfo.runtimeFieldClass) {
            jSONSerializer.out.write("false");
        } else if ((this.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Collection.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
            runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, (Object) null, this.fieldInfo.name, runtimeSerializerInfo.runtimeFieldClass);
        } else {
            jSONSerializer.out.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
    }
}
